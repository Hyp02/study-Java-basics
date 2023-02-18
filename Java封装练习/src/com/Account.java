package com;

public class Account {
    private String name ;
    private int salary;
    private String password;

    public Account(String name, int salary, String password) {
//        this.name = name;
//        this.salary = salary;
//        this.password = password;
        //封装
        this.setName(name);
        this.setSalary(salary);
        this.setPassword(password);
    }
    public void cal (){
        System.out.println("我是a类中的cal");
    }

    public void setName(String name) {
        if (name.length() <= 4 && name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("您输入的姓名长度有误，将给出默认姓名");
            this.name = "用户123";
        }
    }

    public String getName() {
        return name;
    }

    public void setSalary(int salary) {
        if (salary > 20) {
            this.salary = salary;
        } else {
            System.out.println("您输入余额格式不正确，将给出默认余额");
            this.salary = 0;
        }
    }

    public int getSalary() {
        return salary;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("输入的密码不正确");
        }
    }

    public String getPassword() {

        return password;

    }

    public void show() {
        if (getPassword() == "123456") {//如果密码正确则显示信息
            System.out.println("====信息如下=====");
            System.out.println("姓名 :" + name + "余额:" + salary +
                    "密码是：" + password);
        } else {
            System.out.println("密码错误");
        }
    }
}