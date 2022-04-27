package com.base.job.service.impl;

import com.base.job.dao.SubjectMapper;
import com.base.job.model.Subjects;
import com.base.job.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public List<Subjects> selectSubjectAll() {
        return subjectMapper.selectSubjectsAll();
    }
}
