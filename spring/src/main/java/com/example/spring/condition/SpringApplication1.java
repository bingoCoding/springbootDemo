package com.example.spring.condition;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan("com.example.spring.condition")
public class SpringApplication1 {

//    @Bean
//    @Conditional(WindowsCondition.class)
//    public BeanService wiService(){
//        return new WindowsService();
//    }
//
//    @Bean
//    @Conditional(LinuxCondition.class)
//    public BeanService liService(){
//        return new LinuxService();
//    }
}
