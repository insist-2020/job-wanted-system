package com.base.job.controller;

import com.base.job.model.IndexCount;
import com.base.job.model.Tab;
import com.base.job.result.BaseResult;
import com.base.job.service.CompanyService;
import com.base.job.service.JobService;
import com.base.job.service.TabService;
import com.base.job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TabController {

    @Autowired
    TabService tabService;
    @Autowired
    UserService userService;
    @Autowired
    JobService jobService;
    @Autowired
    CompanyService companyService;

    @RequestMapping("selectTabAll")
    public List<Tab> selectTabAll(){
        return tabService.selectTabAll();
    }


    @RequestMapping("count")
    @ResponseBody
    public BaseResult<IndexCount> count(){
        int userCount = userService.userCount();
        int jobCount = jobService.jobCount();
        int companyCount = companyService.companyCount();

        IndexCount indexCount = new IndexCount(userCount,jobCount,companyCount);

        if (userCount != 0 && jobCount !=0 && companyCount != 0){
                return BaseResult.success(indexCount);
        }
        return BaseResult.fail(1,"查询为空");


    }



}
