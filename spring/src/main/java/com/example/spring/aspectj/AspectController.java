package com.example.spring.aspectj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AspectController {
    @Resource
    private DemoMethodService demoMethodService;

    @Resource
    private DemoAnotationService demoAnotationService;

    @RequestMapping("/testAspectj")
    public String testAspect(){
        demoAnotationService.add();
        demoMethodService.add();
        return "ok";
    }
}
