package com.base.job.dao;

import com.base.job.model.Company;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {

    List<Company> selectCompanyAll();

    int companyCount();

    List<Company> selectCompanyByNameAndAddress(@Param("companyName") String companyName,@Param("companyAddress") String companyAddress);


}
