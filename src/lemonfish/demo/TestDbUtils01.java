package lemonfish.demo;

import lemonfish.entity.User;
import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 快速上手
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils01 {
    public static void main(String[] args) throws SQLException {
        // 1.获取连接池
        DataSource dataSource = JDBCUtil.getDataSource();

        // 2.建立QueryRunner，将连接池当成参数传进构造器中
        QueryRunner queryRunner = new QueryRunner(dataSource);

        // 3.创建相关的ResultSetHandle，形成结果映射
        BeanHandler<User> userBeanHandler = new BeanHandler<>(User.class);

        // 4.编写sql语句
        // （建议在qr的execute里面写，因为会有输入提示，这里只是为了分步更详细，方便大家理解）
        // 或者先写 String sql = "" ,然后放入execute占位，这样也会有输入提示
        String sql = "select * from jdbc_demo.user where id = ?";

        // 5.执行qr的query方法
        // 参数1：sql语句
        // 参数2：ResultSetHandler
        // 参数3：类似preparedStatement，完成对sql语句占位符的替换
        // 这个query底层就是使用preparedStatement
        User user = queryRunner.query(sql, userBeanHandler, 1);

        // 6.查看结果
        System.out.println(user);
        // Perfect (●'◡'●)
        // User{id=1, username='user1', password='123'}
    }
}
