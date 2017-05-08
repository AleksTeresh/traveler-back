/*
 * This file is generated by jOOQ.
*/
package fi.istrange.traveler.db.tables.pojos;


import java.io.Serializable;
import java.sql.Date;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Message implements Serializable {

    private static final long serialVersionUID = -1982525366;

    private Long   id;
    private String messageText;
    private Date   creationTime;
    private String username;
    private Long   chatRoomId;

    public Message() {}

    public Message(Message value) {
        this.id = value.id;
        this.messageText = value.messageText;
        this.creationTime = value.creationTime;
        this.username = value.username;
        this.chatRoomId = value.chatRoomId;
    }

    public Message(
        Long   id,
        String messageText,
        Date   creationTime,
        String username,
        Long   chatRoomId
    ) {
        this.id = id;
        this.messageText = messageText;
        this.creationTime = creationTime;
        this.username = username;
        this.chatRoomId = chatRoomId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getChatRoomId() {
        return this.chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Message (");

        sb.append(id);
        sb.append(", ").append(messageText);
        sb.append(", ").append(creationTime);
        sb.append(", ").append(username);
        sb.append(", ").append(chatRoomId);

        sb.append(")");
        return sb.toString();
    }
}
