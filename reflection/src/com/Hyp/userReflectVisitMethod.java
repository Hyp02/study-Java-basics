package com.Hyp;

import java.lang.reflect.Method;

public class userReflectVisitMethod {
    public static void main(String[] args) throws Exception{
        Class<?> boosCls = Class.forName("com.Hyp.boos");
        Object o = boosCls.newInstance();
        Method showAge = boosCls.getMethod("showAge", int.class);
        showAge.invoke(o,10);
        //不能使用getMethod（）方法访问showName方法
        //因为showName方法是私有的，所以要使用 getDeclaredMethod
        //Method showName = boosCls.getMethod("showName", String.class);
        Method showName2 = boosCls.getDeclaredMethod("showName", String.class);
        showName2.setAccessible(true);//因为是私有方法将方法爆破
        showName2.invoke(o,"韩永鹏");
        Method hi = boosCls.getDeclaredMethod("hi");
        //因为是私有方法将方法爆破
        hi.setAccessible(true);
        hi.invoke(null);
        hi.invoke(o);
    }
}
class boos{
    private String name;
    private int age;
    public void showAge(int age){
        System.out.println("年龄是:"+age);
    }
    private void showName(String name){
        System.out.println("名字是："+name);
    }
    private static void hi(){
        System.out.println("你好");
    }
}
