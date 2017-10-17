package com.example.activemq.activemq;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;

@Configuration
public class Receiver {

    @JmsListener(destination = "myDestination")
    public void receiveMessage(String message){
        System.out.println("接受到："+message);
    }

}
