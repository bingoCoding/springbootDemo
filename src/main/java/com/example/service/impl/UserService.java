package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService{

    @Resource
    private UserDao userDao;


    @Override
    public User findUserByUserName(String username) {
        User user=new User();
        user.setUsername(username);
//        user=userDao.selectOne(user);
        return user;
    }
}
