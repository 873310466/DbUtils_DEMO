package lemonfish.demo;

import lemonfish.entity.User;
import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 增加
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils05 {
    public static void main(String[] args) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

        // 2. 操作，
        // Tip：先写handler，再写sql语句，这样有提示
        // 也可以使用where，这边只是举个例子
        // 虽然是增加，但是API就是叫update - -
        int res = queryRunner.update("insert into jdbc_demo.user values (null,'user4','user4')");

        // 3.输出
        System.out.println(res);
        // 得到 1 说明成功(●'◡'●)

    }
}
