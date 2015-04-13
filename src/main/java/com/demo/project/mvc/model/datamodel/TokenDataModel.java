package com.demo.project.mvc.model.datamodel;

import com.demo.project.mvc.common.model.BaseResponse;

/**
 * Created by saif on 4/13/15.
 */
public class TokenDataModel extends BaseResponse {

    private String token;
    private int userId;
    private int userStatus;
    private String userName;
    private String remoteIp;
    private String loginMessage;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
