package messagesendtest;


import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSenderService;
import com.nhnacademy.edu.springframework.messagesender.annotation.Dooray;
import com.nhnacademy.edu.springframework.messagesender.service.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class MessageSendTest {

    @InjectMocks
    private DoorayMessageSender messageSender;

    @Mock
    private DoorayHookSender doorayHookSender;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void callHookSenderTest(){
        messageSender.sendMessage(new User("gildong","1234"),"바아아보");
        verify(doorayHookSender).send(any());
    }

}
