package fi.istrange.traveler.api.messaging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import fi.istrange.traveler.api.UserProfileRes;
import fi.istrange.traveler.db.tables.pojos.ChatRoom;

import java.sql.Date;
import java.util.List;

/**
 * Created by aleksandr on 7.5.2017.
 */
public class ChatRoomRes {
    private Long id;
    private boolean active;
    private Date timestamp;
    private List<UserProfileRes> participants;

    @JsonCreator
    public ChatRoomRes(
            @JsonProperty("id") Long id,
            @JsonProperty("active") boolean active,
            @JsonProperty("timestamp") Date timestamp,
            @JsonProperty("participants") List<UserProfileRes> participants
    ) {
        this.id = id;
        this.active = active;
        this.timestamp = timestamp;
        this.participants = participants;
    }

    public Long getId() { return id; }

    public boolean isActive() { return active; }

    public Date getTimestamp() { return timestamp; }

    public List<UserProfileRes> getParticipants() { return participants; }

    public static ChatRoomRes fromEntity(ChatRoom chatRoom, List<UserProfileRes> participants) {
        return new ChatRoomRes(
                chatRoom.getId(),
                chatRoom.getActive(),
                chatRoom.getCreationTime(),
                participants
        );
    }
}
