package com.example.spring.event;

import com.example.spring.scope.DemoAnotationService;
import com.example.spring.scope.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringApplication1.class);

        DemoPublish demoPublish = applicationContext.getBean(DemoPublish.class);
        demoPublish.publish("abcdefghijklmn");

        applicationContext.close();
    }
}