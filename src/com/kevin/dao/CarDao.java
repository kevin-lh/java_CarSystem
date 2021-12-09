package com.kevin.dao;

import com.kevin.pojo.car;

import java.util.Date;
import java.util.List;

//二手车相关的数据处理
public interface CarDao {

    //获取最新的二手车信息
    public List<car> getnewCarinfo();

    //获取指定编号的二手车信息
    public car getCarinfo(int id);


    //获取指定品牌，指定车型的二手车
    public List<car> getExactinfo(int brandid,double modelid);

    //获取指定价格范围的二手车
    public List<car> getExactPriceinfo(double price,double endprice);

    //获取指定上牌日期范围的二手车
    public List<car> getExactdateinfo(Date begin , Date end);

    //将指定编号的二手车加入收藏
    public boolean addtolike(int id);

    //获取收藏的二手车列表
    public List<car> showlike();

    //将指定编号的二手车加入对比列表
    public boolean addtocontrast(int id);

    //获取对比的二手车列表
    public List<car> showcontrast();

    //删除对比车辆
    public  boolean removecontrast(int id);
}
