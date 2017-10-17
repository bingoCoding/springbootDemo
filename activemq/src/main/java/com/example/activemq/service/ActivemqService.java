package com.example.activemq.service;

import com.example.activemq.activemq.Msg;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;

/**
 * 定义消息发送及目的地
 * CommandLineRunner 用于程序启动后执行
 */
@Configuration
public class ActivemqService implements CommandLineRunner{

    @Resource
    private JmsTemplate jmsTemplate;

    @Override
    public void run(String... strings) throws Exception {
        jmsTemplate.send("myDestination",new Msg());
    }
}
