package com.example.service.impl;

import com.example.service.IDemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {

    @Value("${globleurl}")
    private String url;

    public String testDemo(){
        System.out.println("DemoService.testDemo");
        System.err.println("url="+url);
        return url;
    }
}
