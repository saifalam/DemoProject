package com.demo.project.mvc.common.enums;

/**
 * Created by saif on 4/13/15.
 */
public enum UserStatus {

    ACTIVE(1),
    CLOSE(2);

    private int code;

    private UserStatus(int code) {
        this.code = code;
    }

    public static String getNameByValue(int code) {
        String name = "";
        for (UserStatus activityLogStatus : UserStatus.values()) {
            if (activityLogStatus.getCode() == code) {
                name = activityLogStatus.name();
                break;
            }
        }
        return name;
    }

    public int getCode() {
        return this.code;
    }
}
