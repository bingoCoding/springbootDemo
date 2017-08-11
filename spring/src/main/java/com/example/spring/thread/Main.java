package com.example.spring.thread;

import com.example.spring.scope.DemoAnotationService;
import com.example.spring.scope.DemoMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringApplication1.class);

        AsyncTaskService asyncTaskService = applicationContext.getBean(AsyncTaskService.class);

        for(int i=0;i<10;i++){
            asyncTaskService.executeTask(i);
            asyncTaskService.executeTaskPlus(i);
        }


        applicationContext.close();
    }
}