package com.example.spring.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service("beanService")
@Conditional(LinuxCondition.class)
public class LinuxService implements BeanService {

    @Override
    public void showCmd() {
        System.err.println("ls");
    }
}
