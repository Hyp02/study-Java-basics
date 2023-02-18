package outputStream;

import java.io.*;

public class ObjecOutPutStreamMain {
    public static void main(String[] args) throws IOException {
        //准备写入的文件地址
        String path = "E:\\dog.txt";
        //创建对象输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        //写入int值
        objectOutputStream.writeInt(100);
        //写入boolean值
        objectOutputStream.writeBoolean(true);
        //写入字符
        objectOutputStream.writeChar('a');
        //写入字符串
        objectOutputStream.writeUTF("韩永鹏学java");
        //写入对象
        objectOutputStream.writeObject(new Dog("大黄",78));
        objectOutputStream.close();
    }
}
//使用对象处理流处理对象时，传入的对象必须实现Serializable接口，实现可序列化操作
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
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setName(String name) {
//        this.name = name;
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
