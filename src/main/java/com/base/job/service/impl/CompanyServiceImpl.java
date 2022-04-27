package com.base.job.service.impl;

import com.base.job.dao.CompanyMapper;
import com.base.job.model.Company;
import com.base.job.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<Company> selectCompanyAll() {
        return companyMapper.selectCompanyAll();
    }

    @Override
    public int companyCount() {
        return companyMapper.companyCount();
    }

    @Override
    public List<Company> companySearch(String companyName, String companyAddress) {
        return companyMapper.selectCompanyByNameAndAddress(companyName,companyAddress);
    }
}
