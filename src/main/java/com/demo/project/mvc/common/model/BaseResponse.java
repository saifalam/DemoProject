package com.demo.project.mvc.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saif on 4/13/15.
 */
public class BaseResponse {

    private int responseCode;

    private List<String> errors;

    public BaseResponse() {
        errors = new ArrayList<String>();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
