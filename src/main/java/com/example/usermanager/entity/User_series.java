package com.example.usermanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_series {
    private int userId;

    private String passwd;

    private String userName;
    private String phoneNumber;
    private String emailAddress;
    private String hometown;

    private String degree;  //formalEducation
    private String major;   //underMajor
    private String[] skills;
    private String projectExperience;
    private String hobby;
    private String[] desiredJob;   //DevType

    public User_series(int id, String hobby, String degree, String[] skills, String major, String[] desiredJob, String projectExperience){
        this.userId = id;
        this.hobby = hobby;
        this.degree = degree;
        this.skills = skills;
        this.major = major;
        this.desiredJob = desiredJob;
        this.projectExperience = projectExperience;
    }
}
