package com.kevin.pojo;

import java.util.Date;

public class car {
    private int carid;
    private double tt;
    private String licensingtime;
    private double price;
    private double kilometres;
    private String LHQmodel;
    private Date releasetime;
    private int brandid;
    private double modelid;

    public car(int carid, double tt, String licensingtime, double price, double kilometres, String LHQmodel, Date releasetime, int brandid, double modelid) {
        this.carid = carid;
        this.tt = tt;
        this.licensingtime = licensingtime;
        this.price = price;
        this.kilometres = kilometres;
        this.LHQmodel = LHQmodel;
        this.releasetime = releasetime;
        this.brandid = brandid;
        this.modelid = modelid;
    }

    public car() {
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public double getTt() {
        return tt;
    }

    public void setTt(double tt) {
        this.tt = tt;
    }

    public String getLicensingtime() {
        return licensingtime;
    }

    public void setLicensingtime(String licensingtime) {
        this.licensingtime = licensingtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKilometres() {
        return kilometres;
    }

    public void setKilometres(double kilometres) {
        this.kilometres = kilometres;
    }

    public String getLHQmodel() {
        return LHQmodel;
    }

    public void setLHQmodel(String LHQmodel) {
        this.LHQmodel = LHQmodel;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public double getModelid() {
        return modelid;
    }

    public void setModelid(double modelid) {
        this.modelid = modelid;
    }

    @Override
    public String toString() {
        return "car{" +
                "carid=" + carid +
                ", tt=" + tt +
                ", licensingtime='" + licensingtime + '\'' +
                ", price=" + price +
                ", kilometres=" + kilometres +
                ", LHQmodel='" + LHQmodel + '\'' +
                ", releasetime='" + releasetime + '\'' +
                ", brandid=" + brandid +
                ", modelid=" + modelid +
                '}';
    }
}
