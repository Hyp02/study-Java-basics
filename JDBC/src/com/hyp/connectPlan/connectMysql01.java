package com.hyp.connectPlan;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectMysql01 {
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        //2．得到连接//老师解读
        //(1) jdbc:mysql:// 规定好表示协议，通过jdbc的方式连接mysql
        //(2) localhost 主机，可以是ip地址
        //(3）3306表示mysql监听的端口
        //(4) hsp_db02连接到mysql dbms的哪个数据库
        //(5) mysql的连接本质就是前面学过的socket连接
        String url = "jdbc:mysql://localhost:3306/jdbc_use";
        //将用户名和密码放入properties对象中
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hyp");
        //建立连接
        Connection connect = driver.connect(url, properties);
        System.out.println("方式1得到连接"+connect);
        connect.close();
    }
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
       //利用反射取出Driver对象
        //反射是动态加载的，更加的灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver =(Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/jdbc_use";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hyp");
        Connection connect = driver.connect(url, properties);
        System.out.println("方式2 得到连接"+connect);
        connect.close();
    }
    //利用DriverManage替代Driver进行统一管理
    @Test
    public void connect3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        //利用反射得到driver对象
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String user = "root";
        String pwd = "hyp";
        String url = "jdbc:mysql://localhost:3306/jdbc_use";
        DriverManager.registerDriver(driver);//注册驱动
        Connection connection = DriverManager.getConnection(url, user, pwd);
        System.out.println("第三中方式得到连接"+connection);
        connection.close();

    }
    //第四种方式可以进行驱动注册
    @Test
    public void connect4() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String user = "root";
        String pwd = "hyp";
        String url = "jdbc:mysql://localhost:3306/jdbc_use";
        Connection connection = DriverManager.getConnection(url, user, pwd);
        System.out.println("第三中方式得到连接"+connection);
        connection.close();
    }
    //因为第四种的 user password URL 都是写死的，不利于程序控制
    //第五种方式加入了配置文件，切换数据库的时候可以在配置文件中修改不用修改源程序
    @Test
    public void connect5() throws IOException, SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlDriver.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        Class.forName(driver);//注册驱动可以不用写，但是建议写上
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}