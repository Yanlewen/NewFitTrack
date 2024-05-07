package com.example.service;

import com.example.pojo.User;

public interface UserService {

    User login(User user);

    void signup(User user);
    //boolean signup(User user);
}
