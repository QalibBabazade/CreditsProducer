package com.credits.producer.dto.response;

import java.io.Serializable;

public class StatusResponse implements Serializable {

    private Integer code;
    private String message;

    public static final Integer SUCCESS_CODE = 1;
    public static final String SUCCESS_MESSAGE = "Success!!!";

    public StatusResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public StatusResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static StatusResponse getSuccessMessage(){
        return new StatusResponse(SUCCESS_CODE,SUCCESS_MESSAGE);
    }
}
