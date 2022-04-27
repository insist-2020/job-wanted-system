package com.base.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    private int id;
    private String jobName;
    private String jobAddress;
    private String jobTime;
    private int minMoney;
    private int maxMoney;
    private String jobEducation;
    private String jobSource;
    private String jobNarration;
    private String jobType;

}
