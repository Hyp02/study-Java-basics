package com.hyp.first;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        //注册驱动
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
        properties.setProperty("user","root");
        properties.setProperty("password","hyp");
        //建立连接
        Connection connect = driver.connect(url, properties);
        //sql语句
        String sql = "insert into actor(name,sex,borndate,phone)" +
                                "values ('刘德华','男','2002-1-2',112),"
                                +"('杨紫','女','2005-5-5',111);";
        //用于执行静态SQL语句，并且返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int ros = statement.executeUpdate(sql);
        System.out.println(ros>0 ? "成功":"失败");
        //最终一定要关闭连接
        statement.close();
        connect.close();

    }
    public static void main(int a){
        System.out.println("main被重载");
    }
}
class A extends jdbc01{
    public static void main(String[] args) {
        System.out.println("niaho");
    }
}
