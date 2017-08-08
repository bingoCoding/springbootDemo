package com.example.controller;

import com.example.model.Student;
import com.example.service.ITestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ITestService testService;

    @RequestMapping("/findbyid/{id}")
    public PageInfo findById(@PathVariable("id") String id){
        PageHelper.startPage(1,3);
        List<Student> list=testService.findById();
        PageInfo<Student> p=new PageInfo<Student>(list);
        return p;

    }
}
