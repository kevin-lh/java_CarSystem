package com.kevin.dao;

import com.kevin.pojo.user;
import com.sun.deploy.util.StringUtils;

import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public user finduserbyname(String username) {
        //从数据库中，获取所有用户的信息
        List<user> users = UserDB.getInstance();
        if(users!=null&&users.size()>0){
            for (user u:users){
                if(u.getUsername().equals(username)){
                    //表示用户是重复的，可以根据用户名匹配到一个用户信息
                    return u;
                }
            }
        }
        return  null;
    }

    @Override
    public void insertuser(user user) {
        //从数据库中，获取所有用户的信息
        List<user> users = UserDB.getInstance();
        users.add(user);
        System.out.println("恭喜，注册成功！");
        System.out.println(users.toString());
    }
}
