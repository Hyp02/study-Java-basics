package com.Hyp;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 获取 Class对象的方法
 */
public class getClassMethod {
    public static void main(String[] args) throws Exception{
        //一 根据全类名使用 Class类的静态方法forName()获取
        Properties properties = new Properties();
        //将配置文件读取
        properties.load(new FileInputStream("src\\file.properties"));
        //先取出配置文件中的类的路径
        String classPath = properties.get("classPath").toString();
        Class<?> cls1 = Class.forName(classPath);
        System.out.println("cls1 "+cls1);
        //根据 类名.class获取
        Class<Cat> cls2 = Cat.class;
        System.out.println("cls2 "+cls2);
        //根据 对象.getClass获取
        Cat cat = new Cat();
        Class cls3 = cat.getClass();
        System.out.println("cls3 "+cls3);
        //根据类加载器获取
        //先得到cat的类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        //在根据类加载器获取Class对象
        Class<?> cls4 = classLoader.loadClass(classPath);
        System.out.println("cls4 "+cls4);
        //"cls1"+"cls2"+"cls3"+"cls4" 是同一个对象

        //基本数据类型获取Class对象方法
        //(int float shot long byte char double boolean）
        // 方法：【基本数据类型.class】
        System.out.println(int.class);
        System.out.println(boolean.class);
        //…………
        //包装类获取Class对象方法
        //【包装类.TYPE】
        Class<Integer> cls5 = Integer.TYPE;
        System.out.println(cls5);


    }
}
