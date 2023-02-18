package com.hyp.transaction;

import utility.jdbcTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 事务
 * 转账案例
 *
 */
public class transactionTest {
    public static void main(String[] args) {
        Scanner san = new Scanner(System.in);
        System.out.println("转账者：");
        String sender = san.nextLine();
        System.out.println("接受者");
        String getter = san.nextLine();
        System.out.println("转账金额");
        int sum = san.nextInt();
        Connection connection = jdbcTool.getConnection();
        PreparedStatement preparedStatement=null;
        try {
            connection.setAutoCommit(false);//将事务自动提交关闭，打开事务
            String sql1 = "update  t_account set balance =balance- ? where name = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1,sum);
            preparedStatement.setString(2,sender);
            int rows1 = preparedStatement.executeUpdate();
            String sql2 ="update  t_account set balance =balance+? where name = ?";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1,sum);
            preparedStatement.setString(2,getter);
            int rows2 = preparedStatement.executeUpdate();

            connection.commit();//执行完进行事务提交
            if(rows1>0&&rows2>0){
                System.out.println("执行成功");
            }else {
                System.out.println("执行失败");
            }

        } catch (SQLException e) {
            System.out.println("遇到异常，将回滚执行过的SQL");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        }finally {
            jdbcTool.close(connection,preparedStatement,null);
        }
    }
}
