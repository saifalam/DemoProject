package com.demo.project.mvc.model.viewmodel;




import com.demo.project.mvc.validator.Phone;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by saif on 3/20/15.
 */
public class UserRegistrationViewModel {

    @NotNull
    private String fullName;

    @NotNull
    private String userName;

    @NotNull
    private Gender gender;

    @Phone
    private String mobileNo;

    @Email @NotEmpty
    private String email;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull @Past
    private Date dateOfBirth;

    public  enum Gender{
        MALE,FEMALE;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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
