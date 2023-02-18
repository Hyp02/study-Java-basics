package utility;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcTool {
    private static String user;
    private static String pwd;
    private static String url;
    private static String driver;
    //静态代码块，进行加载mysql的相关配置
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysqlDriver.properties"));
            user = properties.getProperty("user");
            pwd =properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
        需要关闭的有：connection statement resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection!=null){
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
