package com.base.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexCount {

    private int userCount;
    private int jobCount;
    private int companyCount;


}
