package com.example.usermanager.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.usermanager.entity.Job;

import java.util.List;


public interface JobService extends IService<Job> {
    List<Job> getDefaultJobs();
}
