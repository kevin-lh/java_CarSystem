package com.kevin.service;

import java.util.Scanner;

//主方法
public class Main {
    public static void main(String[] args) {
/*      欢迎使用二手车交易系统
        1.登陆
        2.注册：用户名不能重复
        3.最新二手车信息
        4.搜索车辆
        5.对比车辆
        6.我的收藏
        8.退出系统*/
        System.out.println("欢迎使用二手车交易系统\n" +
                " 1.登陆\n" +
                " 2.注册：用户名不能重复\n" +
                " 3.最新二手车信息\n" +
                " 4.搜索车辆\n" +
                " 5.对比车辆\n" +
                " 6.我的收藏\n" +
                " 8.退出系统\n"+
                "请选择你的操作：\n");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        switch (choose){
            //登录
            case "1":
                if(loginService.login()){
                    System.out.println("恭喜，登录成功！\n"+"=======================");
                    Main.main(null);
                }else {
                    System.out.println("用户名或密码错误，请重新输入\n"+"=======================");
                    Main.main(null);
                }
                break;
            //注册
            case "2":
                loginService.rigister();
                Main.main(null);
                break;
            // 最新二手车信息
            case "3":
                QueryService.querynewcars();
                System.out.println("输入序号查看车辆信息(详细)：");
                int id = scanner.nextInt();
                //循环输入查看车辆信息
                if(QueryService.querycar(id)==null){
                    id = scanner.nextInt();
                    QueryService.querycar(id);
                }
                //如果用户已登录，可以进行以下操作
                if(loginService.getflag()){
                    //查看车辆详细信息后的二级菜单===========
                    QueryService.querycarindex(id);
                }else {//未登录能进行以下操作
                    System.out.println("=====================================\n"+"1.加入对比\n" +"2.返回主菜单\n"+"若收藏与购买，请返回主菜单登录！");
                    QueryService.querycarindex2(id);
                }
                break;

            // 搜索车辆
            case "4":
                QueryService.search();
                break;

            //对比车辆
            case "5":
                if(loginService.getflag()){
                    ContrastService.contrast();
                }else {
                    System.out.println("登录后才可查看，请登录！");
                    Main.main(null);
                }
                break;

            //查看我的收藏
            case "6":
                if(loginService.getflag()){
                    System.out.println("您的收藏为：");
                    LikeService.showlike();
                }else {
                    System.out.println("登录后才可查看，请登录！");
                    Main.main(null);
                }
                break;

            //退出系统
            case "8":
                System.out.println("退出系统！欢迎再次使用！");
                return;
        }

    }
}
