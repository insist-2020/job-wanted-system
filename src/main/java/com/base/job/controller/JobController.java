package com.base.job.controller;

import com.base.job.model.Job;
import com.base.job.model.JobTopCount;
import com.base.job.result.BaseResult;
import com.base.job.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class JobController {

    @Resource
    JobService jobService;

    @RequestMapping("/selectJobAll")
    public List<Job> selectJobAll(){
        return jobService.selectJobAll();
    }

    @RequestMapping("/selectJobByName")
    public List<Job> selectJobByName(String jobName){
        return jobService.selectJobByName(jobName);
    }

    @RequestMapping("/jobSearch")
    public String jobSearch(String jobName, String jobAddress, Model model){
        List<Job> jobList = jobService.jobSearch(jobName,jobAddress);
        model.addAttribute("jobList",jobList);
        return "browsejobs";
    }

    @RequestMapping("/jobTop")
    @ResponseBody
    public BaseResult jobTop(){
        List<JobTopCount> list = jobService.selectJobNameTop();
        if (list == null){
            return BaseResult.fail(1,"数据为空");
        }
        return BaseResult.success(list);
    }


}
