package com.lp.chat.controller;

import com.lp.chat.domain.UserBroker;
import com.lp.chat.domain.UserMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.Principal;

@Controller
public class MessageController {

    /**
     * 通过messagingTemplate向浏览器发送消息
     */
    @Resource
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        if (principal.getName().equals("aaa")){
            messagingTemplate.convertAndSendToUser("bbb","/queue/notifications",
                    principal.getName()+"-send: "+msg);
        }else{
            messagingTemplate.convertAndSendToUser("aaa","/queue/notifications",
                    principal.getName()+"-send: "+msg);
        }
    }


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
