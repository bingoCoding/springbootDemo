package com.example.service.impl;

import com.example.dao.StudentMapper;
import com.example.model.Student;
import com.example.model.StudentExample;
import com.example.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findById() {
        StudentExample example = new StudentExample();
//        example.createCriteria().andIdEqualTo(id);
//        List<Student> list= studentMapper.selectByExample(example);
        List<Student> list=studentMapper.selectAll();
        return list;

    }
}
