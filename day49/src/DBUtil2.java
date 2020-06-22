import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil2 {
    private static volatile DataSource dataSource = null;
    public Connection getConnection() throws SQLException {
        if(dataSource == null) {
            synchronized (DBUtil2.class) {
                if(dataSource == null) {
                    MysqlDataSource mysqlDataSource = new MysqlDataSource();
                    mysqlDataSource.setServerName("127.0.0.1");
                    mysqlDataSource.setPort(3306);
                    mysqlDataSource.setUser("root");
                    mysqlDataSource.setPassword("bnn19961006");
                    mysqlDataSource.setUseSSL(false);
                    mysqlDataSource.setCharacterEncoding("utf8");
                    dataSource = mysqlDataSource;
                }
            }
        }
        return dataSource.getConnection();
    }
}
