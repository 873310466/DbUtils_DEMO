package lemonfish.demo;

import lemonfish.entity.User;
import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 查找单个数据
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils02 {
    public static void main(String[] args) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

        // 2. 查询，
        // Tip：先写handler，再写sql语句，这样有提示
        Long query = queryRunner.query("select count(*) from jdbc_demo.user", new ScalarHandler<>());

        // 3.输出
        System.out.println(query);
        // 得到 3

    }
}
