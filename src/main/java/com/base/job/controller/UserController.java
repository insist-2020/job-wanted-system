package com.base.job.controller;

import com.base.job.model.User;
import com.base.job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public User selectUserByUsernameAndPassword(String userName,String passWord){
        return userService.selectUserByUsernameAndPassword(userName,passWord);
    }


}
