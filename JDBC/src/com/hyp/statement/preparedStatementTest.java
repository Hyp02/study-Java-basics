package com.hyp.statement;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * 事先准备好声明中测试
 *
 * @author Han
 * @date 2023/01/11
 */
public class preparedStatementTest {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入用户名： ");
        String userName = scan.nextLine();
        System.out.print("请输入登录密码： ");
        String userPwd = scan.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlDriver.properties"));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        String url = properties.getProperty("url");
        Class.forName(properties.getProperty("driver"));
        Connection connection = DriverManager.getConnection(url, user, pwd);
        //一个？是一个占位符，表示要输入的值
        String sql = "select user_id,passward from t_user where user_id =? and passward =? ;";
        //使用preparedStatement(可防止SQL注入)
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //给SQL中得？ 赋值
        //1表示第一个？ ？的起始位置是从1 开始的，将要查询的条件输入SQL中
        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,userPwd);
        //执行查询【execute query】
        //使用DML【update insert delete】语句时，要调用executeUpdate()方法
        //注意这里的executeQuery()括号中不能加入SQL语句了
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("登录成功~");
        }else {
            System.out.println("登录失败~");
        }
        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
