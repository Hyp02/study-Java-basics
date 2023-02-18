package com.Hyp;

import java.lang.reflect.Field;

public class reflection02 {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("com.Hyp.Dog");
        System.out.println("包名"+aClass.getPackage().getName());
        System.out.println("全类名"+aClass.getName());

        Object o = aClass.newInstance();
        Field[] fields = aClass.getFields();
        System.out.println("====所有字段名===");
        for (Field field:fields) {
            System.out.println(field.getName()+"--"+field.get(o));
        }
        Field name = aClass.getField("name");
        System.out.println(name.getName());//得到指定字段名
        name.set(o,"小花狗");//修改字段的内容
        System.out.println(name.get(o));
    }
}