package com.example.usermanager.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("my_user")
public class User {
    private int userId;

    private String passwd;

    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private String hometown;

    private String degree;  //formalEducation
    private String major;   //underMajor
    private String skills;
    private String yearsCoding;
    private String hobby;
    private String desiredJob;   //DevType

    public User(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.passwd = password;
    }
}
