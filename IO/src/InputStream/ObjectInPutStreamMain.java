package InputStream;


import outputStream.Dog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectInPutStreamMain {
    public static void main(String[] args) throws Exception{

        String path = "E:\\dog.txt";
        ObjectInputStream OTS = new ObjectInputStream(new FileInputStream(path));
        //反序列化时，调用的相关方法一定要和序列化时的顺序一致，否则出现异常
        System.out.println(OTS.readInt());;
        System.out.println(OTS.readBoolean());;
        System.out.println( OTS.readChar());
        System.out.println(OTS.readUTF());
        Object dog = OTS.readObject();
        //想调用Dog类中的方法时，需要将反序列化得到的对象进行向下转型
        //这里编译能通过是因为，从outputStream包中引入了公共类Dog
        Dog dog1 = (Dog) dog;

        System.out.println("小狗名字是"+dog1.getName());
        System.out.println(dog);


    }
}
//class Dog implements Serializable {
//    private String name;
//    private int age;
//
//    public Dog(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Dog{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
//}
