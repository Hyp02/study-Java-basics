package com.Hyp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class reflection {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        //将配置文件读取
        properties.load(new FileInputStream("src\\file.properties"));
        //取出配置文件中的类的路径
        String classPath = properties.get("classPath").toString();
        //取出配置文件中的方法名
        String method = properties.get("method").toString();

        //反射
        //根据类的路径，取出class的一个对象（重要）
        Class<?> aClass = Class.forName(classPath);
        //（instance）实例  取出类的实例
        Object o = aClass.newInstance();
        //取出配置文件中的方法
        Method method1 = aClass.getMethod(method);
        method1.setAccessible(false);//取消反射在调用方法时的访问安全检查
        //用方法invoke取出的实例（对象）
        //配置文件中method存储的是【cry】方法。所以这里输出cry方法中的内容
        method1.invoke(o);
        //使用反射取出类对象中的字段对象
        //getField不可以访问私有属性。因此name在Cat类中不可以设置成private
        Field nameField = aClass.getField("name");
        //传统方式访问是   对象.属性（方法、字段……）
        //反射访问方式     属性（方法、字段、）.get(类的实例对象)
        String name = (String)nameField.get(o);
        System.out.println(name);
        //访问构造器[无参构造器]
        Constructor<?> constructor = aClass.getConstructor();
        //【有参构造器】
        Constructor<?> nameConstructor = aClass.getConstructor(String.class);
        Constructor<?> ageConstructor= aClass.getConstructor(int.class);
        System.out.println("无参构造器"+constructor);
        System.out.println("有参构造器（名字）"+nameConstructor);
        System.out.println("有参构造器（年龄）"+ageConstructor);
    }
}
