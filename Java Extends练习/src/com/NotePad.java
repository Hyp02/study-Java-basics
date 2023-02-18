package com;

public class NotePad extends computer {
    public String color;

    public NotePad(String cpuName,int RAm,int HardDisk ,String color) {
        super(cpuName,RAm,HardDisk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void showNotePad(){
        System.out.println("====NotePad=====");
        System.out.println("颜色是"+color+getDetals());
    }
}

