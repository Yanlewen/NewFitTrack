package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        user.setPassword(password);

        // 调用Mapper层方法验证用户信息
        return userMapper.getPasswordAndUsername(user);
    }

    @Override
    public void signup(User user) {
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(password);
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
    }
    //@Override
    //public boolean signup(User user) {
        //String password = user.getPassword();
        //password = DigestUtils.md5DigestAsHex(password.getBytes());
        //user.setPassword(password);
        //user.setUpdateTime(LocalDateTime.now());
        //user.setCreateTime(LocalDateTime.now());
        //int rowsAffected = userMapper.insert(user);
        //return rowsAffected == 1;
    //}
}
