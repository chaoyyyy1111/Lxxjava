
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DUtil {
     private static DataSource dataSource;
     static {
         MysqlDataSource mysqlDataSource = new MysqlDataSource();
         mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/account?useSSL=false&characterEncoding=utf8");
         mysqlDataSource.setUser("root");
         mysqlDataSource.setPassword("bnn19961006");
         dataSource = mysqlDataSource;
     }
     public static Connection getConnection() throws SQLException {
         return dataSource.getConnection();
     }
}
