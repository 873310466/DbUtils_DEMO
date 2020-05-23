package lemonfish.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    /**
     * 连接池
     */
    static DataSource dataSource = null;

    /**
     * 静态代码块，用来初始化连接池
     */
    static {
        try {
            //1.通过类加载器(任意一个即可，因为运行期间获取的类加载器都是Application ClassLoader)将properties文件变成输入流
            // name需要改成自己的，或者按找我这个目录 src->config->druid.properties
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("config/druid.properties");
            Properties properties = new Properties();
            // 加载输入流
            properties.load(is);
            //2.创建指定参数的数据库连接池
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前连接池
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取Connection
     * @return Connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            // 建立Connection
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


    /**
     * 获取Connection，并开启事务
     * @return Connection
     */
    public static Connection getConnectionWithTransaction(){
        Connection connection = null;
        try {
            // 建立Connection
            connection = dataSource.getConnection();
            // 关闭自动提交，即开启事务。
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
