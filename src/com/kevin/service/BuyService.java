package com.kevin.service;

import com.kevin.dao.BrandDaoImpl;
import com.kevin.dao.CarDaoImpl;
import com.kevin.dao.ModelDaoImpl;
import com.kevin.dao.UserDaoImpl;
import com.kevin.pojo.car;
import com.kevin.pojo.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyService {

    private static UserDaoImpl userDao = new UserDaoImpl();
    private static CarDaoImpl carDao = new CarDaoImpl();
    private static BrandDaoImpl brandDao = new BrandDaoImpl();
    private static ModelDaoImpl modelDao = new ModelDaoImpl();


    public static void buycar(int id){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user u = loginService.getsession();//获取当前登录用户
        car c =  QueryService.querycar(id);//获取当前选中的二手车
        if (u.getBalance()>=c.getPrice()){
            double oldbalance = u.getBalance();//购买前余额
            System.out.println("恭喜，购买成功\n"+"======凭证:您于 "+df.format(new Date())+"购买 "+brandDao.getBrandByid(c.getBrandid())+"牌 "+modelDao.getModelByid(c.getModelid())+"一辆======");
            //购买后更新余额
            u.setBalance(oldbalance-c.getPrice());
            double newbalance = u.getBalance();//购买后余额
            if(newbalance>=0){
                System.out.println("账户余额为"+u.getBalance());
            }else {
                System.out.println("账户余额不足！");
            }
        }else {
            System.out.println("很遗憾，您的账户余额不足！");
        }

    }
}
