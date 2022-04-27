package com.base.job.controller;

import com.base.job.model.Company;
import com.base.job.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping("selectCompanyAll")
    public List<Company> selectCompanyAll(){
        return companyService.selectCompanyAll();
    }

    @RequestMapping("companySearch")
    public String sompanySearch(String companyName, String companyAddress, Model model){
        List<Company> companyList = companyService.companySearch(companyName, companyAddress);
        return "candidates";
    }

}
