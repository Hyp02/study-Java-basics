package com.hyp.dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import utility.jdbc_druidTool;

import java.sql.Connection;
import java.util.List;

/**
 * dbutils测试
 * 使用德鲁伊和dbutils
 *
 * @author Han
 * @date 2023/01/11
 */
public class dbutilsTest {
    /**
     * 德鲁伊使用db跑龙套
     *
     * @throws Exception 异常
     */
    @Test
    /**
     * 查询多个对象,将对象结果集（ResultSet）放在一个集合中
     */
    public void use_druid_dbUtils() throws Exception {
        Connection connection = jdbc_druidTool.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select *from actor where id>=?";
        //将返回的多个对象，存放到list集合中，所以使用的是，new BeanListHandler<>()对象
        List<Actor> list =
                qr.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        for (Actor actor:list) {
            System.out.println(actor);
        }
        jdbc_druidTool.close(connection,null,null);
    }

    /**
     * 查询单个对象
     */
    @Test
    public void use_druid_dbUtils2() throws Exception {
        Connection connection = jdbc_druidTool.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select *from actor where id>=?";
        //因为返回的是单个对象，所以将使用 BanHandler <> (XX.Class)对象
        Actor actor =
                qr.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(actor);
        jdbc_druidTool.close(connection,null,null);

    }

    /**
     * 查询单行单列
     */
    @Test
    public void use_druid_dbUtils3() throws Exception {
        Connection connection = jdbc_druidTool.getConnection();
        QueryRunner qr = new QueryRunner();
        String sql = "select name from actor where id>=?";
        //因为查询的是单行的名字，所以将使用对象 new ScalarHandler()
        Object query = qr.query(connection, sql, new ScalarHandler(), 2);
        System.out.println(query);
        jdbc_druidTool.close(connection,null,null);
    }
    @Test
    public void use_druid_dbUtils4() throws Exception {
        Connection connection = jdbc_druidTool.getConnection();
        QueryRunner qr = new QueryRunner();
        //修改
        //String sql ="update actor set name = ?where id = ?";
        //int rows = qr.update(connection, sql, "成龙", 1);
        //删除
//       String sql = "delete from actor where id = ? ";
//       int rows = qr.update(connection, sql,  3);
        String sql = "insert into actor values(null,?,?,?,?)";
        int rows = qr.update(connection, sql,"杨紫 "
                            , "女",  "2002-01-02" ," 110");


        System.out.println(rows>0 ? "执行成功":"未影响到表");
        jdbc_druidTool.close(connection,null,null);
    }
}
