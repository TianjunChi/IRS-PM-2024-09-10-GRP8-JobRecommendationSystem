package com.example.usermanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

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
    private String projectExperience;
    private String school;
    private String hobby;
    private String desiredJob;   //DevType
    private Double salary;

    public User(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.passwd = password;
    }
}
