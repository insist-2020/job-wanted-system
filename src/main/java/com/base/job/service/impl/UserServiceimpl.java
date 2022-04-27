package com.base.job.service.impl;

import com.base.job.dao.UserMapper;
import com.base.job.model.User;
import com.base.job.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User selectUserByUsernameAndPassword(String userName, String passWord) {
        return userMapper.selectUserByUsernameAndPassword(userName,passWord);
    }

    @Override
    public int userCount() {
        return userMapper.userCount();
    }
}
