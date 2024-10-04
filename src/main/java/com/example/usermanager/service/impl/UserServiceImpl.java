package com.example.usermanager.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.usermanager.entity.User;
import com.example.usermanager.mapper.UserMapper;
import com.example.usermanager.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByPassword(String phoneNumber, String password) {
        return userMapper.getUserByPassword(phoneNumber,password);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        return userMapper.getUserByPhoneNumber(phoneNumber);
    }
}
