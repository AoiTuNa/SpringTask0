package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.user.User;

public interface MessageSender {
    public boolean sendMessage(User user, String message);
}

