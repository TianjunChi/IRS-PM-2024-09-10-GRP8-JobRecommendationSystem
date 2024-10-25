package com.example.usermanager.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.usermanager.entity.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapper extends BaseMapper<Job> {
    List<Job> getDefaultJobs();
}
