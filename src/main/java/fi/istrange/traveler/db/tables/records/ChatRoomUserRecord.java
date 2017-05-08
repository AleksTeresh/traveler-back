/*
 * This file is generated by jOOQ.
*/
package fi.istrange.traveler.db.tables.records;


import fi.istrange.traveler.db.tables.ChatRoomUser;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


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
public class ChatRoomUserRecord extends TableRecordImpl<ChatRoomUserRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = 1120867329;

    /**
     * Setter for <code>public.chat_room_user.chat_room_id</code>.
     */
    public void setChatRoomId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.chat_room_user.chat_room_id</code>.
     */
    public Long getChatRoomId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.chat_room_user.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.chat_room_user.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ChatRoomUser.CHAT_ROOM_USER.CHAT_ROOM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return ChatRoomUser.CHAT_ROOM_USER.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getChatRoomId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRoomUserRecord value1(Long value) {
        setChatRoomId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRoomUserRecord value2(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRoomUserRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChatRoomUserRecord
     */
    public ChatRoomUserRecord() {
        super(ChatRoomUser.CHAT_ROOM_USER);
    }

    /**
     * Create a detached, initialised ChatRoomUserRecord
     */
    public ChatRoomUserRecord(Long chatRoomId, String username) {
        super(ChatRoomUser.CHAT_ROOM_USER);

        set(0, chatRoomId);
        set(1, username);
    }
}
