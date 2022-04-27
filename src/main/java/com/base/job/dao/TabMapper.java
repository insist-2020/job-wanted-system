package com.base.job.dao;

import com.base.job.model.Tab;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TabMapper {

    List<Tab> selectTabAll();

}
