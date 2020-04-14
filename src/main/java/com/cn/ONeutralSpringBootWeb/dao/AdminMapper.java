package com.cn.ONeutralSpringBootWeb.dao;

import com.cn.ONeutralSpringBootWeb.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

    UserInfo findUserByName(String userName);

    void setUserView(String username);

    int register(UserInfo userInfo);

    int isRegistered(String username);

    int updateStatus(String username);

    String getEmailByUserName(String username);

    int isEmail(String email);
}
