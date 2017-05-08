package fi.istrange.traveler.resources.profile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fi.istrange.traveler.api.UserProfileRes;
import fi.istrange.traveler.api.messaging.ChatRoomRes;
import fi.istrange.traveler.bundle.ApplicationBundle;
import fi.istrange.traveler.dao.ChatRoomUserDao;
import fi.istrange.traveler.dao.UserPhotoDao;
import fi.istrange.traveler.db.tables.daos.ChatRoomDao;
import fi.istrange.traveler.db.tables.daos.MessageDao;
import fi.istrange.traveler.db.tables.daos.TravelerUserDao;
import fi.istrange.traveler.db.tables.pojos.ChatRoomUser;
import fi.istrange.traveler.db.tables.pojos.Message;
import fi.istrange.traveler.sse.EventPublisher;
import io.dropwizard.auth.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dhatim.dropwizard.jwt.cookie.authentication.DefaultJwtCookiePrincipal;
import org.jooq.DSLContext;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aleksandr on 7.5.2017.
 */
@Path("/profile/chat-rooms")
@Produces(MediaType.APPLICATION_JSON)
@Api("messaging")
@PermitAll
public class ChatResource {
    private final ChatRoomDao chatRoomDao;
    private final MessageDao messageDao;
    private final ChatRoomUserDao chatRoomUserDao;
    private final TravelerUserDao userDao;
    private final UserPhotoDao userPhotoDao;

    public ChatResource (
            ApplicationBundle applicationBundle
    ) {
        this.chatRoomDao = new ChatRoomDao(applicationBundle.getJooqBundle().getConfiguration());
        this.messageDao = new MessageDao(applicationBundle.getJooqBundle().getConfiguration());
        this.chatRoomUserDao = new ChatRoomUserDao();
        this.userDao = new TravelerUserDao(applicationBundle.getJooqBundle().getConfiguration());
        this.userPhotoDao = new UserPhotoDao(applicationBundle.getJooqBundle().getConfiguration().connectionProvider());
    }

    @GET
    @ApiOperation("Get a list of all the chatrooms with their participants, but without messages")
    public List<ChatRoomRes> getChatRooms(
            @ApiParam(hidden = true) @Auth DefaultJwtCookiePrincipal principal,
            @Context DSLContext db
    ) {
        List<ChatRoomUser> chatRooms = chatRoomUserDao.fetchAllByUsername(principal.getName(), db);

       return chatRoomDao.fetchById(
               chatRooms.stream()
                        .map(p -> p.getChatRoomId())
                        .collect(Collectors.toList())
                        .toArray(new Long[chatRooms.size()])
        ).stream()
                .map(p -> ChatRoomRes.fromEntity(
                        p,
                        chatRoomUserDao.fetchAllByChatRoomId(p.getId(), db)
                            .stream()
                            .map(t -> UserProfileRes.fromEntity(
                                    userDao.fetchOneByUsername(t.getUsername()),
                                    userPhotoDao.fetchPhotoOidByUsername(t.getUsername(), db)
                            ))
                            .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @ApiOperation("Get messages of a chatroom")
    public List<Message> getMessages(
            @ApiParam(hidden = true) @Auth DefaultJwtCookiePrincipal principal,
            @PathParam("id") Long chatRoomId,
            @QueryParam("offset") @DefaultValue("0") int offset,
            @QueryParam("limit") @DefaultValue("70") int limit,
            @Context DSLContext db
    ) {
        authorizeChatRoomAccess(principal.getName(), chatRoomId, db);

        return this.messageDao.fetchByChatRoomId(chatRoomId);
    }

    @POST
    @Path("/{id}")
    @ApiOperation("Send a message to a chatroom")
    public void sendMessage(
            @ApiParam(hidden = true) @Auth DefaultJwtCookiePrincipal principal,
            @PathParam("id") Long chatRoomId,
            String text,
            @Context DSLContext db
    ) {
        authorizeChatRoomAccess(principal.getName(), chatRoomId, db);

        Message message = new Message(
                this.messageDao.count() + 1,
                text,
                new Date(new java.util.Date().getTime()),
                principal.getName(),
                chatRoomId
        );
        this.messageDao.insert(message);

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);

            EventPublisher.pub(json, chatRoomId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("Leave a chatroom")
    public void deactivateChatroom(
            @ApiParam(hidden = true) @Auth DefaultJwtCookiePrincipal principal,
            @PathParam("id") Long chatRoomId,
            String text,
            @Context DSLContext db
    ) {
        authorizeChatRoomAccess(principal.getName(), chatRoomId, db);

        // TODO: add leave a chatroom implementation here
    }

    private boolean authorizeChatRoomAccess(
            String username,
            Long chatRoomId,
            DSLContext db
    ) {
        if (
            chatRoomUserDao.fetchAllByUsername(username, db)
                    .stream()
                    .map(p -> p.getChatRoomId())
                    .collect(Collectors.toList())
                    .indexOf(chatRoomId) == -1
        ) {
            throw new NotAuthorizedException("Access to the chatroom is forbidden");
        }

        return true;
    }
}
