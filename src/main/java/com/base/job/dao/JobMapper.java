package com.base.job.dao;

import com.base.job.model.Job;
import com.base.job.model.JobTopCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobMapper {

    List<Job> selectJobAll();

    List<Job> selectJobByName(@Param("jobName")String jobName);

    void insertJobByJsoup(List<Job> jobList);

    int jobCount();

    List<Job> selectJobByNameAndAddress(@Param("jobName") String jobName,@Param("jobAddress") String jobAddress);

    List<JobTopCount> selectJobNameTop();
}
