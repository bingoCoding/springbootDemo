package com.example.spring.scope;

import org.springframework.stereotype.Service;

/**
 * 使用注解被拦截的类
 */
@Service
public class DemoAnotationService {

    public void add(){
        System.err.println("Action="+ DemoAnotationService.class.getName());
    }
}
