package com.demo.project.mvc.common.enums;

/**
 * Created by saif on 4/13/15.
 */
public enum ResponseCode {

    OPERATION_SUCCESSFUL(100),
    AUTHENTICATION_FAILED(102),
    INVALID_ARGUMENT(103),
    SECURITY_ERROR(104),
    DATABASE_ERROR(105),
    RUNTIME_ERROR(106),
    REMOTE_ERROR(107);

    private int code;

    private ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
