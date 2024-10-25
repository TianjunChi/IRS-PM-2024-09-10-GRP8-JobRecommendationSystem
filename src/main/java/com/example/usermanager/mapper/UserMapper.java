package com.example.usermanager.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.usermanager.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    public User getUserByPhoneNumber(String phoneNumber);

    public User getUserByPassword(String phoneNumber, String password);

    boolean updateUser(User user);
}
