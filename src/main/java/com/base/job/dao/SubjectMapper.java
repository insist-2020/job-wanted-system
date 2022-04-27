package com.base.job.dao;

import com.base.job.model.Subjects;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {

    List<Subjects> selectSubjectsAll();

}
