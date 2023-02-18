package com;

public class Person {//父类
    private String Name;
    private int age;

    public Person(String Name, int age) {
        this.Name = Name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return Name;
    }

    public void say() {//父类中的say方法
        System.out.println("Preson中的自我介绍 \n " + "姓名: " + Name + " 年龄：" +
                age);
    }
}
