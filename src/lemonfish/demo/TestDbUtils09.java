package lemonfish.demo;

import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务
 *
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils09 {
    public static void main(String[] args) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        // 2. 获取开启事务的connection
        Connection connection = JDBCUtil.getConnectionWithTransaction();

        // 3. 业务
        // 3.1 删除、添加

        try {
            int delete = queryRunner.update(connection,
                    "delete from jdbc_demo.user where username = ? ",
                    "user3");
            int insert = queryRunner.update(connection,
                    "insert into jdbc_demo.user values (null,'user4','user4')");
            // 3.2 手动制造错误，查看回滚效果
            int error = 1 / 0;
            // 3.3 手动提交
            connection.commit();
        } catch (SQLException throwables) {
            // 3.4 进行回滚
            connection.rollback();
            throwables.printStackTrace();
        } finally {
            // 记住关闭
            connection.close();
        }
    }
}
