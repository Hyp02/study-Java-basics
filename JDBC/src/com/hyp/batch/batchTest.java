package com.hyp.batch;

import utility.jdbcTool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class batchTest {
    public static void main(String[] args) {
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        try {
            connection = jdbcTool.getConnection();
            //sql语句不能添加 " ; "   ！！！！
            String sql = "INSERT INTO t_user VALUES (?,?)" ;
            preparedStatement = connection.prepareStatement(sql);
            long timeStart = System.currentTimeMillis();
            for (int i = 1; i <= 5000; i++) {
                preparedStatement.setInt(1,i);
                preparedStatement.setString(2,"hyp");
                preparedStatement.addBatch();
                if (i%1000==0){
                    preparedStatement.executeBatch();
                    //清空，像公交车一样，一批乘客到站，清空一批
                    preparedStatement.clearBatch();
                }
            }
            long timeStop = System.currentTimeMillis();
            System.out.println("运行时间"+(timeStop-timeStart));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcTool.close(connection,preparedStatement,null);
        }
    }
}
