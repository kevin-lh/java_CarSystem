package com.kevin.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.kevin.pojo.car;
public class CarDB {

    private CarDB(){ };

    //存储所有的二手车信息
    private static  final List<car> cars = new ArrayList<car>();

    //存储所有的二手车信息
    private static final List<car> likecars = new ArrayList<car>();

    //存储对比的二手车信息
    private static final List<car> contrastcars = new ArrayList<car>();

    //静态代码快，初始化操作。存储二手车信息
    /*    1 大众
            1.1"桑塔纳"
            1.2"朗逸",
            1.3"速腾",
        2 福特
            2.1"撼路者"
            2.2"探险者"
            2.3"领界",
        3 雪佛兰
            3.1"雪铁龙"
            3.2"科鲁泽"
            3.3"科沃兹"*/
    static {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        //大众
        try {
            cars.add(new car(1,2.0,"2020-01-01",200000,50000,"手自一体",ft.parse("2018-05-02"),1,1.1));
            cars.add(new car(2,1.5,"2019-02-02",105000,15000,"自动挡",ft.parse("2016-02-03"),1,1.2));
            cars.add(new car(3,1.2,"2018-04-04",40000,52000,"手动挡",ft.parse("2015-06-04"),1,1.3));
            cars.add(new car(4,1.2,"2018-04-04",70000,92000,"手自一体",ft.parse("2017-06-04"),1,1.3));
            cars.add(new car(5,1.2,"2018-04-10",80000,32000,"手动挡",ft.parse("2018-06-04"),1,1.3));
            //福特
            cars.add(new car(6,2.3,"2015-01-11",70000,45000,"自动挡",ft.parse("2019-01-12"),2,2.1));
            cars.add(new car(7,2.0,"2014-11-23",60000,105000,"自动挡",ft.parse("2017-11-23"),2,2.1));
            cars.add(new car(9,3.0,"2016-09-10",130500,32000,"手自一体",ft.parse("2017-01-12"),2,2.1));
            //雪佛兰
            cars.add(new car(10,3.3,"2016-01-12",30000,145000,"自动挡",ft.parse("2018-01-21"),3,3.1));
            cars.add(new car(11,3.0,"2019-11-23",160000,205000,"手动挡",ft.parse("2016-11-22"),3,3.1));
            cars.add(new car(12,2.8,"2015-09-12",42500,35000,"手动挡",ft.parse("2020-01-21"),3,3.1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static List<car> getInstance(){
        return cars;
    }
    public static List<car> getlikeInstance(){return likecars;}
    public static List<car> getcontrastInstance(){return contrastcars;}
}
