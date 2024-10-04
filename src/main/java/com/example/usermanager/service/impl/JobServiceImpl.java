package com.example.usermanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.usermanager.entity.Job;
import com.example.usermanager.mapper.JobMapper;
import com.example.usermanager.service.JobService;
import org.springframework.stereotype.Service;


@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
}
