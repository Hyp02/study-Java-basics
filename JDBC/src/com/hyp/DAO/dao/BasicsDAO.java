package com.hyp.DAO.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utility.jdbc_druidTool;


import java.sql.Connection;
import java.util.List;

public class BasicsDAO<T>{
    private static QueryRunner qr = new QueryRunner();

    /**
     *
     * @param sql SQL语句
     * @param obj 修改操作用到的条件 sql语句中的？
     * @return 返回受影响的行数
     */
    public  int update(String sql ,Object... obj){
        Connection connection=null;
        try {
            connection = jdbc_druidTool.getConnection();
            return qr.update(connection,sql, obj);
        } catch ( Exception e) {
            throw new RuntimeException(e);
        } finally {
            jdbc_druidTool.close(connection,null,null);
        }
    }

    /**
     *
     * @param sql
     * @param cls 要查询的表
     * @param obj 传入查询条件
     * @return 返回符合条件的记录集合
     */
    public List<T> Results(String sql,Class<T> cls ){
        Connection connection=null;
        try {
            connection = jdbc_druidTool.getConnection();
            List<T> list =
                    qr.query(connection, sql, new BeanListHandler<T>(cls));
            return list;
        } catch ( Exception e) {
            throw new RuntimeException(e);
        } finally {
            jdbc_druidTool.close(connection,null,null);
        }
    }

    /**
     *
     * @param sql sql 语句
     * @param cls 要访问的数据库表
     * @param obj
     * @return 返回表中的一条记录
     */
    public T aResult(String sql ,Class<T> cls,Object... obj){
        Connection connection=null;
        try {
            connection = jdbc_druidTool.getConnection();
            //返回你要查询的表的对象
            T t =
                    qr.query(connection, sql, new BeanHandler<T>(cls),obj);
            return t;
        } catch ( Exception e) {
            throw new RuntimeException(e);
        } finally {
            jdbc_druidTool.close(connection,null,null);
        }
    }

    /**
     *
     * @param sql  sql语句
     * @param obj 可变参数，传入 ？ 的条件用
     * @return 返回一行或一列的结果
     */
    public Object aRow(String sql ,Object... obj){
        Connection connection=null;
        try {
            connection = jdbc_druidTool.getConnection();
            Object rows =
                    qr.query(connection, sql, new ScalarHandler(),obj);
            return rows;
        } catch ( Exception e) {
            throw new RuntimeException(e);
        } finally {
            jdbc_druidTool.close(connection,null,null);
        }
    }


}
