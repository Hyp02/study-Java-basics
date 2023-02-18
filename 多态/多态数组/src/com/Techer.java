package com;

public class Techer extends Person {
    private int salary;

    public Techer(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() + " 薪水是 " + salary;
    }

    public void teach(String object) {
        System.out.println(getName() + "正在教授" + object);
    }
}
