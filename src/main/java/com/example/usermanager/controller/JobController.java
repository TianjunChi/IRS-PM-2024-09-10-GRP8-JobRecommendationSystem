package com.example.usermanager.controller;


import com.example.usermanager.entity.Job;
import com.example.usermanager.entity.User;
import com.example.usermanager.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jobs")
@Slf4j
public class JobController {
    @Resource
    JobService jobService;

    @GetMapping("/getJobListByUser")
    public List<Job> getJobListByUser(User user){
        return new ArrayList<>();
    }
}
