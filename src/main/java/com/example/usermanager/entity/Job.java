package com.example.usermanager.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Job {
    private String jobId;
    private String jobTitle;
    private String jobDescription;
    private String companyName;
    private String skills;  //CONTENT-BASED
    private String location;
    private String employmentType; // Full-time, Part-time
    private double salary;
}
