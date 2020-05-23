package lemonfish.demo;

import lemonfish.dao.UserDAO;
import lemonfish.entity.User;
import lemonfish.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 测试BaseDAO
 *
 * @author Chao Zhang
 * @version V1.0
 * @Package java.test
 */
public class TestDbUtils10 {
    public static void main(String[] args) throws SQLException {
        // 1. 获取UserDAO
        UserDAO userDAO = new UserDAO();
        // 2. 使用
        User user = userDAO.selectOne("select * from user where username= ?", User.class, "user1");
        // 3. 操作结果
        System.out.println(user);
        // 输出结果：User{id=1, username='user1', password='123'}
    }
}
