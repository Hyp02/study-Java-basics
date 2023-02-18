package DataSourceC3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import utility.jdbcTool;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 使用c3p0数据库连接池 进行数据库的连接
 */
public class c3p0 {
    @Test
    //使用配置文件
    public void connect01() throws IOException, PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysqlDriver.properties"));
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //给连接池赋值信息
        cpds.setUser(user);
        cpds.setPassword(pwd);
        cpds.setJdbcUrl(url);
        cpds.setDriverClass(driver);
        //设置初始连接数
        cpds.setInitialPoolSize(10);
        //设置最大连接数
        cpds.setMaxPoolSize(1000);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = cpds.getConnection();
            jdbcTool.close(connection,null,null);
        }
        long stop = System.currentTimeMillis();
        System.out.println("运行时间为 "+(stop-start));

    }
    @Test
    //使用 c3p0-config-xml 文件进行配置连接
    public void connect02() throws SQLException {
        ComboPooledDataSource jdbc = new ComboPooledDataSource("jdbc");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = jdbc.getConnection();
            connection.close();

        }
        //System.out.println("连接成功"+connection);
        long end = System.currentTimeMillis();
        System.out.println("时间"+(end-start));
    }
}

