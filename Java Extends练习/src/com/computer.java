package com;


import java.util.Scanner;

public class computer {//父类
    private String cpuName = " 英特尔";
    private int RAM;
    private int HardDisk;


    public computer(String cpuName, int RAM, int hardDisk) {
//      this.cpuName = cpuName;
//        this.RAM = RAM;
//        this.HardDisk = hardDisk;
        setCpuName(cpuName);
        setRAM(RAM);
        setHardDisk(HardDisk);
    }

    public String getDetals() {
        return " cpu = " + cpuName + " RAM = " + RAM + " 硬盘大小 = " + HardDisk;
    }

    public String getCpuName() {//查看（返回）cpu信息的方法，封装里面的
        //这里可以加入业务逻辑判断户是否有权限查看
        return cpuName;
    }

    public void setCpuName(String cpuName) {//cpu信息不可修改

        System.out.println("cpu信息不可以更改");
        this.cpuName = cpuName;
    }

    public int getRAM() {//内存信息修改

        return RAM;
    }

    public void setRAM(int RAM) {//修改信息的方法。加入了业务逻辑（访问密码）
        System.out.println("请输入管理员密码以用来修改商品RAM大小");
        int RAMpasw;
        Scanner scanner = new Scanner(System.in);
        RAMpasw = scanner.nextInt();
        if (RAMpasw == 232323) {
            int change;
            System.out.println("请输入修改后的RAM的大小");
            change = scanner.nextInt();
            this.RAM = change;
        } else {
            System.out.println("您输入的管理员密码不正确");
        }

    }

    public int getHardDisk() {
        return HardDisk;
    }

    public void setHardDisk(int hardDisk) {//修改信息的方法‘
        System.out.println("请输入管理员密码以用来修改商品以硬盘大小");
        int diskpasw;
        Scanner scanner = new Scanner(System.in);
        diskpasw = scanner.nextInt();
        if (diskpasw == 232323) {
            int change;
            System.out.println("输入新的硬盘大小");
            change = scanner.nextInt();
            HardDisk = change;
        } else {
            System.out.println("您输入的管理员密码不正确");
        }

    }

}
