package com.example.spring.aspectj;

import org.springframework.stereotype.Service;

/**
 * 使用方法规则被拦截的类
 */
@Service
public class DemoMethodService {

    public void add(){
        System.err.println("Action="+DemoMethodService.class.getName());
    }
}
