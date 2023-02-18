package com.Hyp;
import java.util.Scanner;
public class classLoad  {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        switch (key){
            case 1:
                Persons person = new Persons();//传统方法创建对象，
                // 没有这个对象时会报错，  静态加载，在类加载时加载
                //而类加载是在编译时加载   所以会编译不通过
                break;
            case 2:
                Class<?> person1 = Class.forName("person");//虽然也没有这个类，
                // 但是使用了反射，动态加载  程序只有运行到这里时，类才会加载，所以不报做
                //运行到这里时，发现没有这个类时才会报错
                break;
        }
    }
}
