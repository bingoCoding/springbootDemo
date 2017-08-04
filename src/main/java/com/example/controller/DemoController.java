package com.example.controller;


import com.example.service.IDemoService;
import com.example.service.impl.DemoService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private IDemoService demoService;


    @RequestMapping("/test")
    public String testDemo(){
        return demoService.testDemo();
    }
}
