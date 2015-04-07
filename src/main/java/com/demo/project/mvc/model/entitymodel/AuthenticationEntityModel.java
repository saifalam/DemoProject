package com.demo.project.mvc.model.entitymodel;

import javax.persistence.*;

/**
 * Created by saif on 4/7/15.
 */
@Entity
@Table(name = "authentication")
public class AuthenticationEntityModel {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;

    @Column(name="user_reg_id")
    private int userId;

    @Column(name="user_password")
    private String userPassword;

    @Column(name="is_active")
    private int isActive;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
