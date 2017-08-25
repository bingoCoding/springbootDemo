package com.example.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringApplication1.class);

        DemoAnotationService demoAnotationService1 = applicationContext.getBean(DemoAnotationService.class);
        DemoAnotationService demoAnotationService2 = applicationContext.getBean(DemoAnotationService.class);

        DemoMethodService demoMethodService1 = applicationContext.getBean(DemoMethodService.class);
        DemoMethodService demoMethodService2 = applicationContext.getBean(DemoMethodService.class);

        System.err.println("sigal="+demoAnotationService1.equals(demoAnotationService2));
        System.err.println("prototype="+demoMethodService1.equals(demoMethodService2));

        applicationContext.close();
    }
}