package com.kevin.dao;

import com.kevin.pojo.brand;
import com.kevin.pojo.model;

import java.util.ArrayList;
import java.util.List;

public class ModelDB {

    private ModelDB(){ };

    //存储所有的二手车车型信息
    private static  final List<model> models = new ArrayList<model>();
    //静态代码快，初始化操作。存储车型信息

    static {
        //大众车型
        models.add(new model(1.1,"桑塔纳",1));
        models.add(new model(1.2,"朗逸",1));
        models.add(new model(1.3,"速腾",1));
        //福特车型
        models.add(new model(2.1,"撼路者",2));
        models.add(new model(2.2,"探险者",2));
        models.add(new model(2.3,"领界",2));
        //雪佛兰车型
        models.add(new model(3.1,"雪铁龙",3));
        models.add(new model(3.2,"科鲁泽",3));
        models.add(new model(3.3,"科沃兹",3));

    }
    public static List<model> getInstance(){
        return models;
    }

}
