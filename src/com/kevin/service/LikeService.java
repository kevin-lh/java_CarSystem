package com.kevin.service;

import com.kevin.dao.BrandDaoImpl;
import com.kevin.dao.CarDaoImpl;
import com.kevin.dao.ModelDaoImpl;
import com.kevin.pojo.car;

import java.text.SimpleDateFormat;
import java.util.List;

//收藏业务
public class LikeService {

    private static CarDaoImpl carDao = new CarDaoImpl();
    private static BrandDaoImpl brandDao = new BrandDaoImpl();
    private static ModelDaoImpl modelDao = new ModelDaoImpl();

    //添加收藏
    public static void addtolike(int id){
        if(carDao.addtolike(id)){
            System.out.println("收藏成功！");
        }
    }

    //显示收藏
    public static void showlike(){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        List<car> likes = carDao.showlike();
        if(likes==null){
            Main.main(null);
        }else{
            for (car c:likes) {
                System.out.println("车辆序号  品牌   车型   排量  离合器类型  里程数    价格     发布时间      上牌时间\n"+"==========================================================================");
                System.out.println(c.getCarid()+"   "+brandDao.getBrandByid(c.getBrandid())+"   "+modelDao.getModelByid(c.getModelid())+"  "+c.getTt()+" "+c.getLHQmodel()+"   "+c.getKilometres()+" "+c.getPrice()+" "+ft.format(c.getReleasetime())+"   "+c.getLicensingtime());
            }
        }
    }

}
