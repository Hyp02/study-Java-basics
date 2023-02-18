package IOHomeWork;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        //创建properties配置文件
        String path = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));
        properties.list(System.out);
        System.out.println("======键值信息======");
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        System.out.println("name is "+name+"\n"+"age is "+age);

        //创建对象处理流，序列化对象
        ObjectOutputStream oups = new ObjectOutputStream(
                new FileOutputStream("E:\\dog.dat"));
        //创建狗 对象，将对象序列化后加入“E:\\dog.dat”文件中，
        // 狗对象需要实现Serializable接口
        oups.writeObject(new Dog("王佳豪",21,"绿色"));
        oups.close();
        UnSerializable();

    }
    public static void UnSerializable(){
        System.out.println("反序列化信息");
        String file = "E:\\dog.dat";
        ObjectInputStream ois=null;
        try {
            ois = new ObjectInputStream(
                    new FileInputStream(file));
            System.out.println(ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
