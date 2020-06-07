import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) throws SQLException {
        initDataSource();
        Scanner scan = new Scanner(System.in);
        try(Connection connection = dataSource.getConnection()) {
            int input1 = scan.nextInt();
            int input2 = scan.nextInt();
            String sql = "select * from exam_result where english > ? and chinese > ? ";
            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1,input1);
                preparedStatement.setInt(2,input2);
                try( ResultSet resultSet = preparedStatement.executeQuery()) {
                    int k = resultSet.getMetaData().getColumnCount();
                    for (int i = 0; i < k ; i++) {
                        String s = resultSet.getMetaData().getColumnLabel(i+1);
                        System.out.print(s+" ");
                    }
                    System.out.println();
                    while(resultSet.next()) {
                        for (int i = 0; i < k ; i++) {
                            String s = resultSet.getString(i+1);
                            System.out.print(s + ",");
                        }
                        System.out.println();
                    }
                }
            }

        }
    }
    private static DataSource dataSource = null;
    private static void initDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("bnn19961006");
        mysqlDataSource.setDatabaseName("sos");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
        dataSource = mysqlDataSource;
    }


}
