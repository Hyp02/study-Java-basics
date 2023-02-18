package properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class propertiesMain2 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("user", "汤姆");
        properties.setProperty("CodeSet", "UTF8");
        //这里使用的是字符流输入，如果使用的是字节流输入，遇到中文就会换成相应的unicode码
        properties.store(new FileWriter("src\\information2.properties"), null);
        System.out.println("配置文件修改成功");
    }
}
