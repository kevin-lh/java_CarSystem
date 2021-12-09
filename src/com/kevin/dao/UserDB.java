package com.kevin.dao;

import java.util.ArrayList;
import java.util.List;
import com.kevin.pojo.user;
public class UserDB {
    private UserDB() {};

    //存储所有用户的信息
    private static final List<user> users = new ArrayList<user>();

    //静态代码快，初始化操作。存储示例用户信息
    static {
        users.add(new user("admin","1111",10000000,null,null));
        users.add(new user("kevin","2222",10000,null,null));
        users.add(new user("tom","3333",5000,null,null));
    }

    public static List<user> getInstance(){
        return users;
    }

}
