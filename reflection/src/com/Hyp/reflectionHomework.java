package com.Hyp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectionHomework {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //创建PrivateTest的类，利用Class类得到私有的name属性，
        // 修改私有的name属性值，并调用getName()的方法打印name属性值
        Class<?> test = Class.forName("com.Hyp.privateTest");
        //得到对象
        Object o = test.newInstance();
        //取出私有属性
        Field name = test.getDeclaredField("name");
        //爆破
        name.setAccessible(true);
        //修改
        name.set(o,"hyp");
        //得到方法
        Method getName = test.getMethod("getName");
        //输出
        System.out.println(getName.invoke(o));
//        System.out.println(getName);
    }
}
class privateTest{
    private String name ="hahah";
    public String getName(){
        return name;
    }
}
