package com.example.usermanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.usermanager.entity.User;

public interface UserService extends IService<User> {
    User getUserByPhoneNumber(String phoneNumber);

    User getUserByPassword(String phoneNumber, String password);

    boolean updateUser(User user);
}
