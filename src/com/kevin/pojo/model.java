package com.kevin.pojo;

public class model {

    private double modelid;
    private String modelname;
    private int brandid;

    public model(double modelid, String modelname, int brandid) {
        this.modelid = modelid;
        this.modelname = modelname;
        this.brandid = brandid;
    }

    public model() {
    }

    public double getModelid() {
        return modelid;
    }

    public void setModelid(double modelid) {
        this.modelid = modelid;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    @Override
    public String toString() {
        return "model{" +
                "modelid=" + modelid +
                ", modelname='" + modelname + '\'' +
                ", brandid=" + brandid +
                '}';
    }
}
