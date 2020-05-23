package lemonfish.demo;

import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.Arrays;

/**
 * 批量插入
 *
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils08 {
    public static void main(String[] args) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());

        // 2. 操作
        // 使用batch方法，
        // 参数1：批量操作的sql
        // 参数2：二位数组，行数 -> 执行次数 ，列 -> 替换占位符
        Object[][] params = new Object[10][];
        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[]{"lemonfish" + i, i};
        }

        // batch代表每行语句执行的结果
        int[] batch = queryRunner.batch(
                "insert into jdbc_demo.user values (null,?,?)",
                params
        );

        // 3.输出
        System.out.println(Arrays.toString(batch));
        // 得到 1 说明成功(●'◡'●)
    }
}
