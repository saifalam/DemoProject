package com.demo.project.mvc.model.entitymodel;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by saif on 3/20/15.
 */
@Entity
@Table(name = "user_registration")
public class UserRegistrationEntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "id")
    private int id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="user_name")
    private String userName;

    @Column(name="gender")
    private String gender;

    @Column(name="phone")
    private String mobileNo;

    @Column(name="email")
    private String email;

    @Column(name="dob")
    private Date dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
