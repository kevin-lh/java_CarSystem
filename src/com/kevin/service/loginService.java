package com.kevin.service;

import com.kevin.dao.UserDaoImpl;
import com.kevin.pojo.user;

import java.util.Scanner;

//登录&注册业务
public class loginService {
    //判断是否登录
    public static boolean flag = false;

    //保存当前登录用户
    public static user session = null;

    private static  UserDaoImpl userDao = new UserDaoImpl();
//    登录业务
    public static boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录");
        System.out.println("请输入用户名:");
        String username = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();
        user u = userDao.finduserbyname(username);
        if(flag==false&&u.getPassword().equals(password)){
            session=u;
            flag=true;
            return true;
        }else {
            return false;
        }
    }

//    注册业务
    public static void rigister(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("注册\n" + "请输入用户名(用户名不能重复):");
        String username = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();
        System.out.println("请再次输入确认密码:");
        String confirmpassword = scanner.next();
        System.out.println("请输入您的余额:");
        double balance = scanner.nextDouble();

        //判断用户名是否重复
        user u = userDao.finduserbyname(username);
        if(u!=null){
            System.out.println("用户名重复，请重新输入用户名:");
        }else if(password.equals(confirmpassword)){
            //没有重复，添加用户进入数据库
            userDao.insertuser(new user(username,password,balance));
        }
    }


    //获取是否登录变量
    public static boolean getflag(){
        return flag;
    }


    //获取当前登录用户
    public static user getsession(){
        return session;
    }
}
