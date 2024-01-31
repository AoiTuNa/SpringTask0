package com.nhnacademy.edu.springframework.messagesender.configuration;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSenderService;
import com.nhnacademy.edu.springframework.messagesender.annotation.Dooray;
import com.nhnacademy.edu.springframework.messagesender.aop.TimeRecord;
import com.nhnacademy.edu.springframework.messagesender.service.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:setting.properties")
public class MainConfig {

    @Bean
    public TimeRecord timeRecord() {
        return new TimeRecord();
    }

    @Bean
    public DoorayMessageSender doorayMessageSender(DoorayHookSender doorayHookSender) {
        return new DoorayMessageSender(doorayHookSender);
    }

    @Bean
    @Dooray
    public MessageSenderService messageSenderService(DoorayMessageSender doorayMessageSender) {
        return new MessageSenderService(doorayMessageSender);
    }

    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate, @Value("${hookUrl}") String hookUrl) {
        return new DoorayHookSender(restTemplate, hookUrl);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}