package com.base.job.service;

import com.base.job.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<Company> selectCompanyAll();

    int companyCount();

    List<Company> companySearch(String companyName,String companyAddress);

}
