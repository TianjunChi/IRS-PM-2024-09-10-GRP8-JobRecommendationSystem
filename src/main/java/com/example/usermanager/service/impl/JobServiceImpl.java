package com.example.usermanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.usermanager.entity.Job;
import com.example.usermanager.mapper.JobMapper;
import com.example.usermanager.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
    @Resource
    JobMapper jobMapper;
    @Override
    public List<Job> getDefaultJobs() {
        return jobMapper.getDefaultJobs();
    }
}
