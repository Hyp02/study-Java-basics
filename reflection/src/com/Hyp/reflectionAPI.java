package com.Hyp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class reflectionAPI {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("com.Hyp.Person");
//        getName:获取全类名
        System.out.println(aClass.getName());
//        getSimpleName:获取简单类名
        System.out.println(aClass.getSimpleName());
//        getFields:获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println("public修饰的属性 ="+field.getName());
        }
//        getDeclaredFields:获取本类中所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性 :"+declaredField.getName());
        }
//        getMethods:获取所有public修饰的方法,包含本类以及父类的
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的所有public修饰的方法"+method.getName());
        }
        System.out.println();
//        getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法"+declaredMethod.getName());
        }
//        getConstructors:获取所有public修饰的本类构造器，
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("public修饰的本类构造器 :"+constructor);
        }
//        getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器"+declaredConstructor);

        }
//        getPackage: 以Package形式返回包信息
        System.out.println(aClass.getPackage());
//        getSuperClass:以Class形式返回父类信息
        Class<?> superclass = aClass.getSuperclass();
        System.out.println("父类的Class对象"+superclass);
//        getInterfaces: 以Class[]形式返回接口信息
        Class<?>[] interfaces = aClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口"+anInterface);
        }

        System.out.println();
//        getAnnotations:以Annotation[]形式返回注解信息(本类)
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解："+annotation);
        }
//
//        1.getModifiers:以int形式返回修饰符

// [说明:默认修饰符是0，public是1,private是2，protected是4,static是8，final是16]
//              public(1) + static (8) = 9
//        2.getType:以Class形式返回类型
//        3. getName:返回属性名


    }
}
interface IA{}
interface IB{}
@SuppressWarnings("all")
class A {
private String ss;

    public A(String ss) {
        this.ss = ss;
    }
    protected A(){}
    private void a(){}
    public void b(){}
}
@Deprecated
class Person extends A implements IA,IB{
    //属性
    public String name;
    protected int age;
    String job;
    private double sal;

    String hh;

    public Person(String name) {
        this.name = name;
    }

    private Person(int age) {
        this.age = age;
    }

    //方法
    public void m1() {
    }
    protected void m2() {
    }
    void m3() {
    }
    private void m4(){
    }
    public void m5(String name){}
    public void m6(int age){}

}

