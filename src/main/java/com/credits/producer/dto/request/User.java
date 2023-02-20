package com.credits.producer.dto.request;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
