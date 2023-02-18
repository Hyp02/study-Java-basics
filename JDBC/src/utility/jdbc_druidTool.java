package utility;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 基于特鲁伊连接池的工具类
 */
public class jdbc_druidTool {
    static Properties properties;
    static DataSource ds;
    static {
         properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\druid.properties"));
             ds = DruidDataSourceFactory.
                    createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }
    public static void close(Connection con , ResultSet rs, Statement st){
        try {
            if (con!=null){
                con.close();
            }
            if (rs!=null){
                rs.close();
            }
            if (st!=null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
