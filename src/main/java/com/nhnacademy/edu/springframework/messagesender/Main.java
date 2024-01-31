package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.user.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.messagesender");
        MessageSenderService messageSenderService = context.getBean("messageSenderService",MessageSenderService.class);
        User user = new User("홍충표","AIGY01-040");
        messageSenderService.doSendMessage(user,"대충 만들어보는 글씨");

    }
}
