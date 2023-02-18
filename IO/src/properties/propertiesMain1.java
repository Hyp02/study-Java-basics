package properties;

import java.io.*;
import java.util.Properties;

public class propertiesMain1 {
    public static void main(String[] args) throws IOException {
        //创建properties对象
        Properties properties = new Properties();
        //load方法是加载配置文件的键值对信息到properties对象
        properties.load(new FileReader("src\\information2.properties"));
        //标准输出
        properties.list(System.out);
        //按照键输出
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("======信息=====");
        System.out.println("名字是"+user);
        System.out.println("密码是"+pwd);


    }

}
