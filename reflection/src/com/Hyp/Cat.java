package com.Hyp;

public class Cat {
    public String name ="小花猫";
    public int age = 10;

    public Cat(){}//无参构造器
    public Cat(String name) {
        this.name = name;
    }

    public Cat(int age) {
        this.age = age;
    }

    public void Name(){
        System.out.println("小猫");
    }
    public void cry(){
        System.out.println("喵喵~");
    }
}
