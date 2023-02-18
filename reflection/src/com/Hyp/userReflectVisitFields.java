package com.Hyp;

import java.lang.reflect.Field;

/**
 * 通过反射操作属性
 */
public class userReflectVisitFields {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<?> sClass = Class.forName("com.Hyp.student");
        Object o = sClass.newInstance();
        Field age = sClass.getField("age");
        age.set(o,10);
        System.out.println(o);
        //将字段是name的字取出来
        Field name = sClass.getDeclaredField("name");
        //因为name是private的，所以要使用反射爆破将安全检查关闭才可以访问
        name.setAccessible(true);
        //因为name是static的，在类加载是加载，所以对象可以是Null
        name.set(null,"你好");
        System.out.println(o);
        System.out.println(name.get(null));
        System.out.println(name.get(o));

    }
}
class student{
    public int age;
    private static String name;

    @Override
    public String toString() {
        return "student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}