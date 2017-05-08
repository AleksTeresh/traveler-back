package fi.istrange.traveler.dao;

import fi.istrange.traveler.db.Tables;
import fi.istrange.traveler.db.tables.pojos.ChatRoomUser;
import org.jooq.Condition;
import org.jooq.DSLContext;

import java.util.List;

/**
 * Created by aleksandr on 7.5.2017.
 */
public class ChatRoomUserDao {

    public List<ChatRoomUser> fetchAllByUsername(
            String username,
            DSLContext db
    ) {
        return fetch(Tables.CHAT_ROOM_USER.USERNAME.equal(username), db);
    }

    public List<ChatRoomUser> fetchAllByChatRoomId(
            Long id,
            DSLContext db
    ) {
        return fetch(Tables.CHAT_ROOM_USER.CHAT_ROOM_ID.equal(id), db);
    }

    public List<ChatRoomUser> fetch(
            Condition condition,
            DSLContext db
    ) {
        return db.select()
                .from(Tables.CHAT_ROOM_USER)
                .where(condition)
                .fetch()
                .map(p -> new ChatRoomUser(
                        p.get(Tables.CHAT_ROOM_USER.CHAT_ROOM_ID),
                        p.get(Tables.CHAT_ROOM_USER.USERNAME)
                ));
    }

    public void insert(
            List<String> usernames,
            Long chatRoomId,
            DSLContext db
    ) {
        usernames.stream()
                .forEach(p -> insert(p, chatRoomId, db));
    }

    public void insert(
            String username,
            Long chatRoomId,
            DSLContext db
    ) {
        db.insertInto(
                Tables.CHAT_ROOM_USER,
                Tables.CHAT_ROOM_USER.USERNAME,
                Tables.CHAT_ROOM_USER.CHAT_ROOM_ID
            ).values(username, chatRoomId)
            .execute();
    }
}
