import java.sql.*;

public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String password = "bnn19961006";
        String user = "root";
        String defaultDatabase = "sos";
        String url = "jdbc:mysql://127.0.0.1:3306/" + defaultDatabase + "?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(url,user,password);
        Query(connection);
        Update(connection);
        Query(connection);

    }

    private static void Update(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "insert into students values ( 103,10101,'妲己','daji.con')";
        int r = statement.executeUpdate(sql);
        System.out.format("%d row is affacted %n",r);
    }

    private static void Query(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select * from students";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("+------+-------+-----------+------------------+");
        System.out.println("| id   | sn    | name      | qq_mail          |");
        System.out.println("+------+-------+-----------+------------------+");
        while(resultSet.next()) {
            String id = resultSet.getString(1);
            String sn = resultSet.getString(2);
            String name = resultSet.getString(3);
            String qq_mail = resultSet.getString(4);
            System.out.format("| %4s | %5s | %9s | %16s |%n",id,sn,name,qq_mail);
        }
        System.out.println("+------+-------+-----------+------------------+");
        resultSet.close();
        statement.close();
    }
}
