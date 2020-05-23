package lemonfish.dao;

import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 封装基本的 增删改查，复用代码
 */
public class BaseDAO<T> {
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

    /**
     * 增删改
     *
     * @param sql    sql语句
     * @param params 占位符
     * @return
     */
    public boolean update(String sql, Object... params) {
        int result = 0;
        try {
            result = qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }

    /**
     * 查询 单个值
     *
     * @param sql
     * @param params
     * @return
     */
    public Object selectScalar(String sql, Object... params) {
        try {
            return qr.query(sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 查询 单行
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public T selectOne(String sql, Class<T> clazz, Object... params) {
        try {
            return qr.query(sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询 多行
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public List<T> selectList(String sql, Class<T> clazz, Object... params) {
        try {
            return qr.query(sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
