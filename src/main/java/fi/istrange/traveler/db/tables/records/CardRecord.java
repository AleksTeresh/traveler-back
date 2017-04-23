/*
 * This file is generated by jOOQ.
*/
package fi.istrange.traveler.db.tables.records;


import fi.istrange.traveler.db.tables.Card;

import java.math.BigDecimal;
import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class CardRecord extends UpdatableRecordImpl<CardRecord> implements Record7<Long, Date, Date, BigDecimal, BigDecimal, String, Boolean> {

    private static final long serialVersionUID = 1240652132;

    /**
     * Setter for <code>public.card.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.card.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.card.start_time</code>.
     */
    public void setStartTime(Date value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.card.start_time</code>.
     */
    public Date getStartTime() {
        return (Date) get(1);
    }

    /**
     * Setter for <code>public.card.end_time</code>.
     */
    public void setEndTime(Date value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.card.end_time</code>.
     */
    public Date getEndTime() {
        return (Date) get(2);
    }

    /**
     * Setter for <code>public.card.lon</code>.
     */
    public void setLon(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.card.lon</code>.
     */
    public BigDecimal getLon() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.card.lat</code>.
     */
    public void setLat(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.card.lat</code>.
     */
    public BigDecimal getLat() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>public.card.owner_fk</code>.
     */
    public void setOwnerFk(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.card.owner_fk</code>.
     */
    public String getOwnerFk() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.card.active</code>.
     */
    public void setActive(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.card.active</code>.
     */
    public Boolean getActive() {
        return (Boolean) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, Date, Date, BigDecimal, BigDecimal, String, Boolean> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Long, Date, Date, BigDecimal, BigDecimal, String, Boolean> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Card.CARD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field2() {
        return Card.CARD.START_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field3() {
        return Card.CARD.END_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field4() {
        return Card.CARD.LON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<BigDecimal> field5() {
        return Card.CARD.LAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Card.CARD.OWNER_FK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return Card.CARD.ACTIVE;
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
    public Date value2() {
        return getStartTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value3() {
        return getEndTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value4() {
        return getLon();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal value5() {
        return getLat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getOwnerFk();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord value2(Date value) {
        setStartTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord value3(Date value) {
        setEndTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord value4(BigDecimal value) {
        setLon(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord value5(BigDecimal value) {
        setLat(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord value6(String value) {
        setOwnerFk(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord value7(Boolean value) {
        setActive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CardRecord values(Long value1, Date value2, Date value3, BigDecimal value4, BigDecimal value5, String value6, Boolean value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CardRecord
     */
    public CardRecord() {
        super(Card.CARD);
    }

    /**
     * Create a detached, initialised CardRecord
     */
    public CardRecord(Long id, Date startTime, Date endTime, BigDecimal lon, BigDecimal lat, String ownerFk, Boolean active) {
        super(Card.CARD);

        set(0, id);
        set(1, startTime);
        set(2, endTime);
        set(3, lon);
        set(4, lat);
        set(5, ownerFk);
        set(6, active);
    }
}
