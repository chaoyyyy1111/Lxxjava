package com.lxx;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DUtil {
    private static  DataSource dataSource = null;
    static {
        initDataSource();
    }
    public static void initDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("bnn19961006");
        mysqlDataSource.setDatabaseName("hjb_boke");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");
        dataSource = mysqlDataSource;
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();

    }
}

