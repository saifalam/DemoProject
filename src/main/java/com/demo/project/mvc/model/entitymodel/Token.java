package com.demo.project.mvc.model.entitymodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by saif on 4/13/15.
 */
@Entity
@Table(name = "User_Token")
public class Token {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "create_on")
    private Date createOn;

    @Column(name = "expired_on")
    private Date expiredOn;

    @Column(name = "requested_ip")
    private String requestedIP;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(Date expiredOn) {
        this.expiredOn = expiredOn;
    }

    public String getRequestedIP() {
        return requestedIP;
    }

    public void setRequestedIP(String requestedIP) {
        this.requestedIP = requestedIP;
    }
}
