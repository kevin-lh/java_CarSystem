package com.kevin.pojo;

public class brand {
    private int brandid;
    private String brandname;
    private String remarks;

    public brand(int brandid, String brandname, String remarks) {
        this.brandid = brandid;
        this.brandname = brandname;
        this.remarks = remarks;
    }

    public brand() {
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "brand{" +
                "brandid=" + brandid +
                ", brandname='" + brandname + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
