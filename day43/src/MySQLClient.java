import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class MySQLClient {
    private static String host = "127.0.0.1";
    private static int port = 3306;
    private static String user = null;
    private static String password = "";
    private static String defaultDatabaseName = "";

    public static void main(String[] args) throws ClassNotFoundException {
        if(args.length == 0) {
            printUsageAndExit();
            return;
        }
        parseArguments(args);
        Class.forName("com.mysql.jdbc.Driver");
        String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&charsetEncoding=utf8",
                host, port, defaultDatabaseName);
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Scanner scan = new Scanner(System.in);
            System.out.print("mysql>");
            while(true) {
                String str = scan.nextLine();
                if(str.equalsIgnoreCase("quit")) {
                    break;
                }
                if(str.startsWith("select") || str.startsWith("show")) {
                    executeQuery(connection,str);
                } else {
                    executeUpdate(connection,str);
                }

                System.out.print("mysql>");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void executeUpdate(Connection connection, String str) throws SQLException {
        Statement statement = connection.createStatement();
        int r = statement.executeUpdate(str);
        System.out.format("%d rows is affacted",r);
        statement.close();
    }

    private static void executeQuery(Connection connection, String str) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(str);
        int k = resultSet.getMetaData().getColumnCount();
        while(resultSet.next()) {
            for (int i = 0; i < k ; i++) {
                String s = resultSet.getString(i+1);
                System.out.print(s+",");
            }
            System.out.println();
        }
        resultSet.close();
        statement.close();
    }

    private static void parseArguments(String[] args) {
        defaultDatabaseName = args[args.length-1];
        args = Arrays.copyOf(args,args.length-1);
        for (int i = 0; i < args.length ; i++) {
            String arg = args[i];
            switch (arg) {
                case "--help":
                    printUsageAndExit();
                    break;
                case "-h":
                case "--host":
                    host = args[++i];
                    break;
                case "-P":
                case "--port":
                    port = Integer.parseInt(args[++i]);
                    break;
                case "-u":
                case "--user":
                    user = args[++i];
                    break;
                case "-p":
                case "--password":
                    password = args[++i];
                    break;
                default:
                    System.out.println("不能识别"+arg);
                    break;
            }
        }
    }

    private static void printUsageAndExit() {
        System.out.println("使用帮助: mysql [选项] 默认数据库");
        System.out.println(" --help         打印帮助信息");
        System.out.println(" -h, --host     连接主机，默认是 127.0.0.1");
        System.out.println(" -P, --port     连接端口，默认是 3306");
        System.out.println(" -u, --user     mysql 用户名，必须设置");
        System.out.println(" -p, --password mysql 密码");
        System.exit(1);
    }
}
