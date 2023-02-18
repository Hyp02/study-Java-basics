package com;

public class PC extends computer {

    private String brand;

    public PC(String cpuName, int RAM, int hardDisk, String brand) {
        super(cpuName, RAM, hardDisk);//调用父类含三个参数的构造器
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void showPC() {
        System.out.println("=====Pc=====");
        System.out.println("PC品牌是" + brand + " " + getDetals());
    }
}

