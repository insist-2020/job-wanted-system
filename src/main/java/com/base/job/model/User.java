package com.base.job.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    private int id;
    private String userName;
    private String password;
    private int userPower;
    private String userPhoto;


}
