package com.hyp.exercise;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
@SuppressWarnings({"all"})
public class resultSet {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlDriver.properties"));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        String url = properties.getProperty("url");
        Class.forName(properties.getProperty("driver"));
        Connection connection = DriverManager.getConnection(url, user, pwd);
        Statement statement = connection.createStatement();
        String sql = "select id,content,time from t_news;";
        //执行查询【execute query】
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String content = resultSet.getString(2);
            Date date = resultSet.getDate(3);
            System.out.println(id+"\t"+content+"\t\t"+date);
        }
        //关闭连接
        connection.close();
        statement.close();
        resultSet.close();

    }
}
