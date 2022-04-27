package com.base.job.service;

import com.base.job.model.Subjects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    List<Subjects> selectSubjectAll();


}
