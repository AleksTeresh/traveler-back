/*
 * This file is generated by jOOQ.
*/
package fi.istrange.traveler.db.tables.pojos;


import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;


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
public class GroupCard implements Serializable {

    private static final long serialVersionUID = -952901318;

    private Long       id;
    private Date       startTime;
    private Date       endTime;
    private BigDecimal lon;
    private BigDecimal lat;
    private String     ownerFk;
    private Boolean    active;

    public GroupCard() {}

    public GroupCard(GroupCard value) {
        this.id = value.id;
        this.startTime = value.startTime;
        this.endTime = value.endTime;
        this.lon = value.lon;
        this.lat = value.lat;
        this.ownerFk = value.ownerFk;
        this.active = value.active;
    }

    public GroupCard(
        Long       id,
        Date       startTime,
        Date       endTime,
        BigDecimal lon,
        BigDecimal lat,
        String     ownerFk,
        Boolean    active
    ) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.lon = lon;
        this.lat = lat;
        this.ownerFk = ownerFk;
        this.active = active;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getLon() {
        return this.lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return this.lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getOwnerFk() {
        return this.ownerFk;
    }

    public void setOwnerFk(String ownerFk) {
        this.ownerFk = ownerFk;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GroupCard (");

        sb.append(id);
        sb.append(", ").append(startTime);
        sb.append(", ").append(endTime);
        sb.append(", ").append(lon);
        sb.append(", ").append(lat);
        sb.append(", ").append(ownerFk);
        sb.append(", ").append(active);

        sb.append(")");
        return sb.toString();
    }
}
