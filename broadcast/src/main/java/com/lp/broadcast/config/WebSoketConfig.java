package com.lp.broadcast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * websocket 是通过一个socket来实现异步通信能力的。
 * 但是直接使用WebSockt协议开发程序会比较繁琐。所以一般会用一个子协议STOMP，它是一个更高级别的协议，
 * 协议使用一个基于帧（frame）的格式来定义消息。
 *
 * 通过@EnableWebSocketMessageBroker注解，开启STOMP协议，来传输基于代理（message broker）的消息,
 * 这时控制器支持使用@MessageMapping,类似@RequestMapping.
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSoketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * 注册STOMP协议的节点（endpoint），并映射指定的URL
     * 并指定使用SockJS协议
     * @param stompEndpointRegistry
     *
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointURL").withSockJS();
    }

    /**
     * 配置消息代理
     * 广播式应配置一个/topic消息代理
     * @param registry
     *
     *  topic : Use topic when there are more than one subscribers for a message.
     *  queue : Use queue for peer to peer communication.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
