package com.example.spring.aspectj;

import org.springframework.stereotype.Service;

/**
 * 使用注解被拦截的类
 */
@Service
public class DemoAnotationService {

    @Action(name = "注解式拦截的方法")
    public void add(){
        System.err.println("Action="+DemoAnotationService.class.getName());
    }
}
