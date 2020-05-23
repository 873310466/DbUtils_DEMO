package lemonfish.demo;

import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * 删除
 *
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils07 {
    public static void main(String[] args) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

        // 2. 操作，
        // Tip：先写handler，再写sql语句，这样有提示
        // 也可以使用where，这边只是举个例子
        // 增删改 都是 update
        int res = queryRunner.update(
                "delete from jdbc_demo.user where username = ? ",
                "user4");

        // 3.输出
        System.out.println(res);
        // 得到 1 说明成功(●'◡'●)
    }
}
