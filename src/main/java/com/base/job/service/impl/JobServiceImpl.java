package com.base.job.service.impl;

import com.base.job.dao.JobMapper;
import com.base.job.model.Job;
import com.base.job.model.JobTopCount;
import com.base.job.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    @Resource
    JobMapper jobMapper;


    @Override
    public List<Job> selectJobAll() {
        List<Job> list =jobMapper.selectJobAll();
        for (Job j:list
             ) {
            System.out.println(j.getId());
            System.out.println(j.getJobName());
        }
        return jobMapper.selectJobAll();
    }

    @Override
    public List<Job> selectJobByName(String jobName) {
        return jobMapper.selectJobByName(jobName);
    }

    @Override
    public int jobCount() {
        return jobMapper.jobCount();
    }

    @Override
    public List<Job> jobSearch(String jobName, String jobAddress) {
        return jobMapper.selectJobByNameAndAddress(jobName,jobAddress);
    }

    @Override
    public List<JobTopCount> selectJobNameTop() {
        return jobMapper.selectJobNameTop();
    }
}
