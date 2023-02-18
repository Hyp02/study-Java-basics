package com;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "成绩" + score;
    }

    //创建子类特有方法
    //课程
    public void studay(String subject) {
        System.out.println(getName() + " 正在上 " + subject);
    }

}
