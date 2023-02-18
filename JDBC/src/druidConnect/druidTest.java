package druidConnect;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;
import utility.jdbc_druidTool;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class druidTest {
    @Test
    public void druidConnect() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties" ));
        //创建数据库和连接池的连接
        DataSource dataSource =
                DruidDataSourceFactory.createDataSource(properties);
        long s = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long e = System.currentTimeMillis();
        System.out.println("连接时间+"+(e-s));
    }
    @Test
    public void connect02() throws Exception {
        Connection connection = jdbc_druidTool.getConnection();
        jdbc_druidTool.close(connection,null,null);
        System.out.println("连接成功"+connection);
    }
}
