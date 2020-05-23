package lemonfish.demo;

import lemonfish.entity.User;
import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 查找多条数据
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils04 {
    public static void main(String[] args) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

        // 2. 查询，
        // Tip：先写handler，再写sql语句，这样有提示
        // 也可以使用where，这边只是举个例子
        List<User> users = queryRunner.query(
                "select * from jdbc_demo.user",
                new BeanListHandler<>(User.class));

        // 3.输出
        System.out.println(users);
        // 得到
        // [User{id=1, username='user1', password='123'},
        // User{id=2, username='user2', password='456'},
        // User{id=3, username='user3', password='123456'}]

    }
}
