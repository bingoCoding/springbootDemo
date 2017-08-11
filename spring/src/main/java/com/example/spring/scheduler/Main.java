package com.example.spring.scheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringApplication1.class);


        Thread.currentThread().setDaemon(true);
        applicationContext.close();
    }
}