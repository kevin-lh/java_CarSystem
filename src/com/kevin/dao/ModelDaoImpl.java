package com.kevin.dao;

import com.kevin.pojo.model;

import java.util.List;

public class ModelDaoImpl implements ModelDao{
    @Override
    public String getModelByid(double id) {
        //获取二手车车型数据
        List<model> models = ModelDB.getInstance();
        String modelname = null;
        if(models!=null&&models.size()>0){
            for (model m:models) {
                if(m.getModelid()==id){
                    modelname=m.getModelname();
                }
            }
        }
        return modelname;
    }
}
