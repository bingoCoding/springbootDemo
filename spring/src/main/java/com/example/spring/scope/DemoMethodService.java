package com.example.spring.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 使用方法规则被拦截的类
 */
@Scope("prototype")
@Service
public class DemoMethodService {

    public void add(){
        System.err.println("Action="+ DemoMethodService.class.getName());
    }
}
