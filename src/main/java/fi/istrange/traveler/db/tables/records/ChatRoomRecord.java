/*
 * This file is generated by jOOQ.
*/
package fi.istrange.traveler.db.tables.records;


import fi.istrange.traveler.db.tables.ChatRoom;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ChatRoomRecord extends UpdatableRecordImpl<ChatRoomRecord> implements Record3<Long, Boolean, Date> {

    private static final long serialVersionUID = -489195575;

    /**
     * Setter for <code>public.chat_room.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.chat_room.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.chat_room.active</code>.
     */
    public void setActive(Boolean value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.chat_room.active</code>.
     */
    public Boolean getActive() {
        return (Boolean) get(1);
    }

    /**
     * Setter for <code>public.chat_room.creation_time</code>.
     */
    public void setCreationTime(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.chat_room.creation_time</code>.
     */
    public Date getCreationTime() {
        return (Date) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Boolean, Date> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Boolean, Date> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ChatRoom.CHAT_ROOM.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field2() {
        return ChatRoom.CHAT_ROOM.ACTIVE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return ChatRoom.CHAT_ROOM.CREATION_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value2() {
        return getActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value3() {
        return getCreationTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRoomRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRoomRecord value2(Boolean value) {
        setActive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRoomRecord value3(Date value) {
        setCreationTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChatRoomRecord values(Long value1, Boolean value2, Date value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChatRoomRecord
     */
    public ChatRoomRecord() {
        super(ChatRoom.CHAT_ROOM);
    }

    /**
     * Create a detached, initialised ChatRoomRecord
     */
    public ChatRoomRecord(Long id, Boolean active, Date creationTime) {
        super(ChatRoom.CHAT_ROOM);

        set(0, id);
        set(1, active);
        set(2, creationTime);
    }
}