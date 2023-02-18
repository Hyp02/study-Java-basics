package com.Hyp;

import java.lang.reflect.Constructor;

public class uesReflectVisit {
    public static void main(String[] args) throws Exception{
        Class<?> userClass = Class.forName("com.Hyp.user");
        Object o = userClass.newInstance();
        Constructor<?> constructor = userClass.getConstructor(String.class,int.class);
        Object hyp = constructor.newInstance("hyp", 100);
        System.out.println(hyp);
        //访问私有构造器
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(String.class);
        //将类加载时安全检查关闭  【爆破】，这样就可以访问私有构造器
        //不关闭就会抛出 IllegalAccessException 【非法访问异常】
        declaredConstructor.setAccessible(true);
        Object hyp1 = declaredConstructor.newInstance("韩永鹏");
        System.out.println(hyp1);
    }
}
class user{
    private String name;
    private int age = 10;
    public user(){
        System.out.println("我是公共的无参构造器~");
    }
    public user(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private user(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
