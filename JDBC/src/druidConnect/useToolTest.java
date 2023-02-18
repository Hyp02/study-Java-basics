package druidConnect;

import utility.jdbc_druidTool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class useToolTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int j= 0;
        try {
            connection = jdbc_druidTool.getConnection();
            connection.setAutoCommit(false);//打开事务
            String sql = "insert into t_user values(?,'2323')";
            //添加数据
            for (int i = 1; i <=50000; i++) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,i);
                j= preparedStatement.executeUpdate();
            }
            connection.commit();//事务提交
        } catch (Exception e) {
            //未完成回滚
            connection.rollback();
            e.printStackTrace();
        }finally {
            //关闭连接
            jdbc_druidTool.close(connection,null,preparedStatement);
        }
        System.out.println(j>0? "成功":"失败");

    }
}
