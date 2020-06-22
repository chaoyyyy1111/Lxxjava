import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
private static final DataSource dataSource;
static {
    MysqlDataSource mysqlDataSource = new MysqlDataSource();
    mysqlDataSource.setServerName("127.0.0.1");
    mysqlDataSource.setPort(3306);
    mysqlDataSource.setUser("root");
    mysqlDataSource.setPassword("bnn19961006");
    mysqlDataSource.setUseSSL(false);
    mysqlDataSource.setCharacterEncoding("utf8");
    dataSource = mysqlDataSource;
}
    public Connection getConnection() throws SQLException {
    return dataSource.getConnection();
    }
}
