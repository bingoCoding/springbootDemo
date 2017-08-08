package com.example.service;

import com.example.model.User;

public interface IUserService {
    User findUserByUserName(String username);
}
