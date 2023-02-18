package com.Hyp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectionApi02 {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.Hyp.Person");
        //        getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
//        1.getModifiers:以int形式返回修饰符
// [说明:默认修饰符是0，public是1,private是2，protected是4,static是8，final是16]
//              public(1) + static (8) = 9
        //        getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性 :"+declaredField.getName()
                    +"本类方法中修饰符数值：" +declaredField.getModifiers());
        }
        //getReturnType()//返回方法的返回类型
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法"+declaredMethod.getName()
                    +"本类方法中修饰符数值："+declaredMethod.getModifiers()
                    +"该方法返回类型"+declaredMethod.getReturnType());
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {

                System.out.println(declaredMethod+"方法形参列表"+parameterType);
            }
        }
        //getParameterTypes()//返回形参类型
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("public修饰的本类构造器 :"+constructor);
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(constructor+"构造器的形参类型"+parameterType);
            }
        }
    }
}
