package com.kevin.service;

import com.kevin.dao.BrandDaoImpl;
import com.kevin.dao.CarDaoImpl;
import com.kevin.dao.ModelDaoImpl;
import com.kevin.pojo.car;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ContrastService {

    private static CarDaoImpl carDao = new CarDaoImpl();
    private static BrandDaoImpl brandDao = new BrandDaoImpl();
    private static ModelDaoImpl modelDao = new ModelDaoImpl();

    public static int ID;
    //添加对比二手车
    public static void addtocontrast(int id){
        ID = id;
        if(carDao.addtocontrast(id)){
            System.out.println("添加至对比库成功！是否要将页面跳转至对比车辆菜单项?Y or N");
            Scanner scanner = new Scanner(System.in);
            String flag = scanner.next();
            if(flag.equals("Y")){
                ContrastService.contrast();
            }else {
                //return;
                QueryService.querycarindex(ID);
            }
        }else {
            System.out.println("对比库车辆已满！");
        }
    }
    //显示对比库
    public static void showcontrast(){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        List<car> contrasts = carDao.showcontrast();
        System.out.println("=========对比库==========\n"+"车辆序号  品牌   车型   排量  离合器类型  里程数    价格     发布时间      上牌时间");
        for (car c:contrasts) {
            System.out.println(c.getCarid()+"   "+brandDao.getBrandByid(c.getBrandid())+"   "+modelDao.getModelByid(c.getModelid())+"  "+c.getTt()+" "+c.getLHQmodel()+"   "+c.getKilometres()+" "+c.getPrice()+" "+ft.format(c.getReleasetime())+"   "+c.getLicensingtime());
        }
    }

    //删除对比车辆
    public static void removecontrastcar(){
        showcontrast();
        System.out.println("选择要移除的二手车序号");
        Scanner scanner = new Scanner(System.in);
        ID = scanner.nextInt();
        if(carDao.removecontrast(ID)){
            System.out.println("移除"+ID+"号二手车成功！");
            showcontrast();
        }else {System.out.println("移除失败");}

    }


    //对比车辆菜单选项
    public static void contrast(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.查看对比信息\n" + "2.删除对比车辆\n" + "3.返回上一级菜单");
        while (scanner.hasNext()){
            switch (scanner.next()){
                case "1":
                    showcontrast();
                    break;
                case "2":
                    removecontrastcar();
                    break;
                case "3":
                    QueryService.querycarindex(ID);
            }
        }
    }
}
