package com.example.spring.condition;

import com.example.spring.thread.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringApplication1.class);

        BeanService beanService = applicationContext.getBean(BeanService.class);

        beanService.showCmd();


        applicationContext.close();
    }
}