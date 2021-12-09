package com.kevin.dao;

import com.kevin.pojo.car;
import com.kevin.pojo.brand;
import com.kevin.pojo.user;

import java.util.ArrayList;
import java.util.List;

public class BrandDB {
    private BrandDB(){ };

    //存储所有的二手车品牌信息
    private static  final List<brand> brands = new ArrayList<brand>();
    //静态代码快，初始化操作。存储品牌信息
    static {
        brands.add(new brand(1,"大众","暂无"));
        brands.add(new brand(2,"福特","暂无"));
        brands.add(new brand(3,"雪佛兰","暂无"));
    }
    public static List<brand> getInstance(){
        return brands;
    }
}
