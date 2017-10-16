package com.example.springbootjpa.controller;

import com.example.springbootjpa.Dao.PersonDao;
import com.example.springbootjpa.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PersonController {

    @Resource
    private PersonDao personDao;

    @RequestMapping("/auto")
    @ResponseBody
    public Page<Person> auto(Person person){
        return personDao.findByAuto(person,new PageRequest(0,10));
    }

}
