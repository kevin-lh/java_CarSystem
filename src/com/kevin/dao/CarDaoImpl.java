package com.kevin.dao;

import com.kevin.pojo.car;
import com.kevin.pojo.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarDaoImpl implements CarDao {

    //查询最新车辆信息
    @Override
    public List<car> getnewCarinfo() {
        //从数据库中，获取最新的10辆二手车的信息
        List<car> cars = CarDB.getInstance();
        if(cars!=null&&cars.size()>0){
            //将二手车数据按照发布时间排序
            cars.sort((t1,t2)-> t2.getReleasetime().compareTo(t1.getReleasetime()));
            return cars;
            //System.out.println(".......");
        }
        return null;
    }

    //获取指定编号的二手车信息
    @Override
    public car getCarinfo(int id) {
        //从数据库中，获取最新的10辆二手车的信息
        List<car> cars = CarDB.getInstance();
        if(cars!=null&&cars.size()>0){
            for (car c:cars) {
                if(c.getCarid()==id){
                    return c;
                }
            }
        }
        return null;
    }

    //获取指定品牌，指定车型的二手车
    @Override
    public List<car> getExactinfo(int brandid, double modelid) {
        //获取车辆信息
        List<car> cars = CarDB.getInstance();
        //保存查询到的二手车
        List<car> resultcars = new ArrayList<car>();
        for (car c:cars) {
            if(c.getBrandid()==brandid&&c.getModelid()==modelid){
                resultcars.add(c);
            }
        }
        return resultcars;
    }

    //获取指定价格范围的二手车
    @Override
    public List<car> getExactPriceinfo(double price,double endprice) {
        //获取车辆信息
        List<car> cars = CarDB.getInstance();
        //保存查询到的二手车
        List<car> resultcars = new ArrayList<car>();
        for (car c:cars) {
            if(c.getPrice()>=price&&c.getPrice()<endprice){
                resultcars.add(c);
            }
        }
        return resultcars;
    }

    //获取指定上牌日期范围的二手车
    @Override
    public List<car> getExactdateinfo(Date begin, Date end) {
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        //获取车辆信息
        List<car> cars = CarDB.getInstance();
        //保存查询到的二手车
        List<car> resultcars = new ArrayList<car>();

        for (car c:cars) {
            try {
                Date begindate = ft.parse(c.getLicensingtime());
                if(begindate.after(begin)&&begindate.before(end)){
                    resultcars.add(c);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return resultcars;
    }

    //将指定编号的二手车加入收藏
    @Override
    public boolean addtolike(int id) {
        //从数据库中，获取收藏的二手车
        List<car> likecars = CarDB.getlikeInstance();
        if(likecars.size()<=10){
            likecars.add(getCarinfo(id));
            System.out.println(likecars.toString());
            return true;
        }else {
            likecars.remove(0);
        }
        return false;
    }

    //获取收藏的二手车列表
    @Override
    public List<car> showlike() {
        //从数据库中，获取收藏的二手车
        List<car> likecars = CarDB.getlikeInstance();
        return likecars;
    }

    //将指定编号的二手车加入对比列表
    @Override
    public boolean addtocontrast(int id) {
        //从数据库中，获取对比的二手车
        List<car> contrastcars = CarDB.getcontrastInstance();
        if(contrastcars.size()<=4){
            contrastcars.add(getCarinfo(id));
            System.out.println(contrastcars.toString());
            return true;
        }else {
            return false;
        }
    }


    //获取对比的二手车列表
    @Override
    public List<car> showcontrast() {
        //从数据库中，获取对比的二手车
        List<car> contrastcars = CarDB.getcontrastInstance();
        return contrastcars;
    }

    //删除对比车辆
    @Override
    public boolean removecontrast(int id) {
        //从数据库中，获取对比的二手车
        List<car> contrastcars = CarDB.getcontrastInstance();
        for (car c:contrastcars) {
            if (c.getCarid()==id){
                contrastcars.remove(c);
                return true;
            }
        }
        return false;
    }
}
