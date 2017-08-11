package com.example.spring.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service("beanService")
@Conditional(WindowsCondition.class)
public class WindowsService implements BeanService {

    @Override
    public void showCmd() {
        System.err.println("cmd");
    }
}
