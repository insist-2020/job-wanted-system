package com.base.job.service;

import com.base.job.model.Job;
import com.base.job.model.JobTopCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobService {

    /**
     * 查询所有的职位
     * @return
     */
    List<Job> selectJobAll();

    /**
     * 根据位置名称查询职位
     * @param jobName
     * @return
     */
    List<Job> selectJobByName(String jobName);

    int jobCount();

    List<Job> jobSearch(String jobName,String jobAddress);

    List<JobTopCount> selectJobNameTop();


}
