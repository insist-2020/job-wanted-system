package com.base.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {

    private int id;
    private String subjectName;
    private String subjectNarration;
    private String subjectTime;
    private String subjectPhoto;

}
