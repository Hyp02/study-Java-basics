package com.Hyp;

import com.sun.org.apache.bcel.internal.classfile.Field;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 1.利用Class类的forName方法得到File类的class对象2.在控制台打印File类的所有构造器
 * 3．通过newlnstance的方法创建File对象，并创建E:\mynew.txt文件
 */
public class reflectionHomework02 {

    public static void main(String[] args) throws Exception{
        //得到File的Class对象
        Class<?> fileClass = Class.forName("java.io.File");
        //得到所有构造器
        Constructor<?>[] allFileConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> allFileConstructor : allFileConstructors) {
            System.out.println("所有构造器"+allFileConstructor);
        }
        //得到File(String path)这个构造器
        Constructor<?> declaredConstructor = fileClass.getDeclaredConstructor(String.class);
        //创建file对象
        Object o = declaredConstructor.newInstance("E:\\useReflectionCreat.txt");
       //得到creatNewFile方法，这个方法是public的 不需要爆破
        Method createNewFile = fileClass.getMethod("createNewFile");
        //通过反射调用方法
        createNewFile.invoke(o);
        System.out.println("创建成功");


    }
}

