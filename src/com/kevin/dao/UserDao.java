package com.kevin.dao;

import com.kevin.pojo.user;

//用户相关的数据处理
public interface UserDao {
    //根据用户名查找用户——用于注册&登录
    public user finduserbyname(String username);
    //用于注册新用户
    public void insertuser(user user);
}
