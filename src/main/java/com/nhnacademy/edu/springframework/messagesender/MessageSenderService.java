package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.annotation.Dooray;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSenderService {
    private MessageSender messageSender;


    @Autowired
    public MessageSenderService(@Dooray MessageSender messageSender){
        this.messageSender = messageSender;
    }
    public void doSendMessage(User user, String message){
        messageSender.sendMessage(user,message);
    }
}
