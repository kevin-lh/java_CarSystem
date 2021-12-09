package com.kevin.dao;

import com.kevin.pojo.brand;
import com.kevin.pojo.car;

import java.util.List;

public class BrandDaoImpl implements BrandDao{
    @Override
    public  String getBrandByid(int id) {
        //从数据库中，获取所有二手车品牌的信息
        List<brand> brands = BrandDB.getInstance();
        String Brandname = null;
        if(brands!=null&&brands.size()>0)
        for (brand b:brands) {
            if(b.getBrandid()==id){
                Brandname=b.getBrandname();
            }
        }
        return Brandname;
    }
}
