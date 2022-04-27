package com.base.job.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private int id;
    private String companyName;
    private String companyNarration;
    private String companyPhoto;
    private String companyAddress;

}
