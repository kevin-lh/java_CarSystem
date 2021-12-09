package com.kevin.pojo;

import java.util.List;

public class user {
    private String username;
    private String password;
    private double balance;
    private List<car> LikeCarlist =null;//收藏车辆的默认值为null
    private List<car> ContrastCarlist =null;//对比车辆的默认值为null
    public user(String username, String password, double balance, List<car> likeCarlist, List<car> contrastCarlist) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        LikeCarlist = likeCarlist;
        ContrastCarlist = contrastCarlist;
    }
    public user(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    public user() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<car> getLikeCarlist() {
        return LikeCarlist;
    }

    public void setLikeCarlist(List<car> likeCarlist) {
        LikeCarlist = likeCarlist;
    }

    public List<car> getContrastCarlist() {
        return ContrastCarlist;
    }

    public void setContrastCarlist(List<car> contrastCarlist) {
        ContrastCarlist = contrastCarlist;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
