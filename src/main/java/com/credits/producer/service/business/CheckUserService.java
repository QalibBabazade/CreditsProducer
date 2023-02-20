package com.credits.producer.service.business;

import org.springframework.stereotype.Service;

@Service
public class CheckUserService {
    public boolean checkUser(Long userId) {
        boolean checkUser = true;
        if(userId == null){
            checkUser = false;
        }
        return checkUser;
    }
}
