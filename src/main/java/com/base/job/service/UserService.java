package com.base.job.service;

import com.base.job.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User selectUserByUsernameAndPassword(String userName,String passWord);

    int userCount();

}
