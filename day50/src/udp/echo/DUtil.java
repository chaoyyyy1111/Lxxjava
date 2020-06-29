package udp.echo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DUtil {
private static final DataSource dataSource;
static {
    MysqlDataSource mysqlDataSource = new MysqlDataSource();
    mysqlDataSource.setDatabaseName("dic");
    mysqlDataSource.setCharacterEncoding("utf8");
    mysqlDataSource.setUseSSL(false);
    mysqlDataSource.setPassword("bnn19961006");
    mysqlDataSource.setServerName("127.0.0.1");
    mysqlDataSource.setUser("root");
    mysqlDataSource.setPort(3306);
    dataSource = mysqlDataSource;
}
public static Connection getConnection() throws SQLException {
    return dataSource.getConnection();
}
}
