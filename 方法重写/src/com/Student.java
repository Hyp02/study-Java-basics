package com;

public class Student extends Person {
    private String id;
    private int score;

    public Student(String Name, int age, String id, int score) {
        super(Name, age);
        this.id = id;
        this.score = score;
    }

    @Override
    public void say() {//重写Person中的say方法
        System.out.println("Student中的自我介绍\n姓名：" + getName() + " 年龄：" +
                getAge() + " 成绩：" + score + " 个人ID：" + id);
    }

}
