package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class DoorayMessageSender implements MessageSender{
    private final DoorayHookSender doorayHookSender;

    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        doorayHookSender.send(DoorayHook.builder().botName(user.getName()).text(message).build());
        return true;
    }
}
