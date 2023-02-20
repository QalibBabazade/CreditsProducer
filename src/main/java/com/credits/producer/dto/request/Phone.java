package com.credits.producer.dto.request;

import java.io.Serializable;

public class Phone implements Serializable {

    private String descripiton;
    private String phoneNumber;


    public String getDescripiton() {
        return descripiton;
    }

    public void setDescripiton(String descripiton) {
        this.descripiton = descripiton;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
