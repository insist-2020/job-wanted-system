package com.base.job.dao;

import com.base.job.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectUserByUsernameAndPassword(@Param("userName") String userName, @Param("passWord") String Password);

    int userCount();

}
