package com.lp.broadcast.controller;


import com.lp.broadcast.domain.UserBroker;
import com.lp.broadcast.domain.UserMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/abc")
    @SendTo("/topic/sendto")
    public UserBroker fabuMessage(UserMessage userMessage){
        try {
            System.out.println("*******************==");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserBroker ub=new UserBroker();
        ub.setBackName("hello "+userMessage.getName());
        return ub;
    }
}
