package com.hyp.exercise;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class exercise {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlDriver.properties"));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        String url = properties.getProperty("url");
        Class.forName(properties.getProperty("driver"));
//        String sql = "create table t_news(" +
//                "id int primary key auto_increment," +
//                "content varchar(255) not null default '新闻'," +
//                "time date);";
        String sql = "insert into t_news(id,content,time)" +
                        "values (6,'今天世界杯','2022-10-1')," +
                               // "(2,'安倍被杀','2022-8-2')," +
                                "(3,'二十大开始','2022-10-2')" ;
                                //"(4,'裁员','2001-12-12')," +
                        //"(5,'新冠','2019-12-31');";
//        String sql = //"update t_news set content='新冠开始' where id = 5;" ;
//                    "delete from t_news where id = 3;";
        Connection connection = DriverManager.getConnection(url, user, pwd);
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows>=0?"成功"+rows+"行记录受影响":"失败");
    }
}
