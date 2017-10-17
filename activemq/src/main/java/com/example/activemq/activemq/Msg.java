package com.example.activemq.activemq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 消息定义
 */
public class Msg implements MessageCreator{
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试发送消息");
    }
}
