package com.nhnacademy.edu.springframework.messagesender.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private String stNum;

    public User(String name, String stNum){
        this.name = name;
        this.stNum = stNum;
    }

}
