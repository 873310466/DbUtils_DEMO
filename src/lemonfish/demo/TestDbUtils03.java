package lemonfish.demo;

import lemonfish.entity.User;
import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * 查找单条数据
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils03 {
    public static void main(String[] args) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

        // 2. 查询，
        // Tip：先写handler，再写sql语句，这样有提示
        User user = queryRunner.query(
                "select * from jdbc_demo.user where username = ?",
                new BeanHandler<>(User.class),
                "user2");

        // 3.输出
        System.out.println(user);
        // 得到 User{id=2, username='user2', password='456'}

    }
}
