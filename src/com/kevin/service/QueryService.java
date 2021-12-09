package com.kevin.service;

import com.kevin.dao.*;
import com.kevin.pojo.car;
import javafx.scene.shape.SVGPath;

import javax.annotation.processing.SupportedSourceVersion;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//查询业务
public class QueryService {

    private static CarDaoImpl carDao = new CarDaoImpl();
    private static BrandDaoImpl brandDao = new BrandDaoImpl();
    private static ModelDaoImpl modelDao = new ModelDaoImpl();

    //查询最新发布的10辆车
    public static void querynewcars() {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("最新发布的10辆二手车信息如下（略）:");
        List<car> cars = carDao.getnewCarinfo();
        if (cars != null) {
            System.out.println("     车辆序号  品牌   车型    里程数    价格     发布时间\n" + "   ==========================================");
            for (int i = 0; i < 10; i++) {
                System.out.println("(" + (i + 1) + ")" + "  " + cars.get(i).getCarid() + "   " + brandDao.getBrandByid(cars.get(i).getBrandid()) + "     " + modelDao.getModelByid(cars.get(i).getModelid()) + "  " + cars.get(i).getKilometres() + " " + cars.get(i).getPrice() + " " + ft.format(cars.get(i).getReleasetime()));
            }
            System.out.println(".......");
        }
    }

    //查询指定车辆的信息
    public static car querycar(int id) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(id + "号二手车详细信息如下:");
        car c = carDao.getCarinfo(id);
        System.out.println("车辆序号  品牌   车型   排量  离合器类型  里程数    价格     发布时间      上牌时间\n" + "==========================================================================");
        if (c == null) {
            System.out.println("没有找到该二手车信息，请重新输入");
            return null;
        } else {
            System.out.println(c.getCarid() + "   " + brandDao.getBrandByid(c.getBrandid()) + "   " + modelDao.getModelByid(c.getModelid()) + "  " + c.getTt() + " " + c.getLHQmodel() + "   " + c.getKilometres() + " " + c.getPrice() + " " + ft.format(c.getReleasetime()) + "   " + c.getLicensingtime());
            return c;
        }
    }


    //查看车辆详细信息后的二级菜单
    public static void querycarindex(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=====================================\n" + "1.收藏\n" +
                "2.加入对比\n" +
                "3.购买\n" +
                "4.返回主菜单");
        while (scanner.hasNext()) {
            String choose1 = scanner.next();
            switch (choose1) {
                case "1":
                    LikeService.addtolike(id);
                    break;
                case "2":
                    ContrastService.addtocontrast(id);
                    break;
                case "3":
                    BuyService.buycar(id);
                    break;
                case "4":
                    Main.main(null);
                    break;
            }
        }
    }

    //未登录情况下，选择二手车跳转至的二级菜单
    public static void querycarindex2(int id) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String choose1 = scanner.next();
            switch (choose1) {
                case "1":
                    ContrastService.addtocontrast(id);
                    break;
                case "2":
                    Main.main(null);
                    break;
            }
        }
    }

    //根据品牌搜索
    public static void serchBybrand() {
        System.out.println("1.大众\n" + "2.福特\n" + "3.雪佛兰");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择品牌:");
        int brand = scanner.nextInt();
        switch (brand) {
            case 1:
                System.out.println("1.1 桑塔纳\n" + "1.2 朗逸\n" + "1.3 速腾");
                System.out.println("请选择车型:");
                double model = scanner.nextDouble();
                List<car> exactinfo = carDao.getExactinfo(brand, model);
                for (car c : exactinfo) {
                    querycar(c.getCarid());
                }
                System.out.println("输入车辆序号进行对比、购买、收藏:");
                int id = scanner.nextInt();
                querycarindex(id);
                break;
            case 2:
                System.out.println("2.1 撼路者\n" + "2.2 探险者\n" + "2.3 领界");
                System.out.println("请选择车型:");
                model = scanner.nextDouble();
                exactinfo = carDao.getExactinfo(brand, model);
                for (car c : exactinfo) {
                    querycar(c.getCarid());
                }
                System.out.println("输入车辆序号进行对比、购买、收藏:");
                id = scanner.nextInt();
                querycarindex(id);
                break;
            case 3:
                System.out.println("3.1 雪铁龙\n" + "3.2 科鲁泽\n" + "3.3 科沃兹");
                System.out.println("请选择车型:");
                model = scanner.nextDouble();
                exactinfo = carDao.getExactinfo(brand, model);
                for (car c : exactinfo) {
                    querycar(c.getCarid());
                }
                System.out.println("输入车辆序号进行对比、购买、收藏:");
                id = scanner.nextInt();
                querycarindex(id);
                break;
        }
    }

    //根据价格搜索
    public static void serchByprice(){
        System.out.println("1. 5万以下\n" + "2. 5-10万\n" + "3. 10-15万\n" + "4. 15万以上");
        Scanner scanner = new Scanner(System.in);
        System.out.println("选择任意项");
        switch (scanner.nextInt()){
            case 1:
                List<car> exactinfo = carDao.getExactPriceinfo(0,50000);
                for (car c : exactinfo) {
                    querycar(c.getCarid());
                }
                System.out.println("输入序号查看车辆信息(详细)：");
                int id = scanner.nextInt();
                querycarindex(id);
                break;
            case 2:
                exactinfo = carDao.getExactPriceinfo(50000,100000);
                for (car c : exactinfo) {
                    querycar(c.getCarid());
                }
                System.out.println("输入序号查看车辆信息(详细)：");
                id = scanner.nextInt();
                querycarindex(id);
                break;
            case 3:
                exactinfo = carDao.getExactPriceinfo(100000,150000);
                for (car c : exactinfo) {
                    querycar(c.getCarid());
                }
                System.out.println("输入序号查看车辆信息(详细)：");
                id = scanner.nextInt();
                querycarindex(id);
                break;
            case 4:
                exactinfo = carDao.getExactPriceinfo(150000,100000000);
                for (car c : exactinfo) {
                    querycar(c.getCarid());
                }
                System.out.println("输入序号查看车辆信息(详细)：");
                id = scanner.nextInt();
                querycarindex(id);
                break;
        }

    }

    //根据上牌日期搜索
    public static void serchBydate(){
        Scanner scanner = new Scanner(System.in);
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println("输入起始年月份:格式 yyyy-MM-dd ");
            Date begin = ft.parse(scanner.next());
            System.out.println("输入截止年月份:格式 yyyy-MM-dd ");
            Date end = ft.parse(scanner.next());
            List<car> exactinfo = carDao.getExactdateinfo(begin,end);
            for (car c : exactinfo) {
                querycar(c.getCarid());
            }
            System.out.println("输入序号查看车辆信息(详细)：");
            int id = scanner.nextInt();
            querycarindex(id);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //搜索车辆目录
    public static void search(){
        System.out.println("1.根据品牌搜索\n" + "2.根据价格搜索\n" + "3.根据上牌日期搜索");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.next()) {
            case "1":
                serchBybrand();
                break;
            case "2":
                serchByprice();
                break;
            case "3":
                serchBydate();
                break;
        }
    }
    }


