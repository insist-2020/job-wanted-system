package com.base.job.controller;

import com.base.job.dao.SubjectMapper;
import com.base.job.model.Subjects;
import com.base.job.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping("selectSubjectAll")
    public List<Subjects> selectSubjectAll(){
        return subjectService.selectSubjectAll();
    }


}
