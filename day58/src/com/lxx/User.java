package com.lxx;

import java.sql.*;

public class User {
    public int id;
    public String username;
    public String password;

    public static User register(String username,String password ) {
           try(Connection connection = DUtil.getConnection()) {
               String sql = "insert into users(username,password) values(?,?)";
               try(PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
                   ps.setString(1,username);
                   ps.setString(2,password);
                   ps.executeUpdate();
                   try(ResultSet r = ps.getGeneratedKeys()) {
                       if(r.next()) {
                           User user = new User();
                           user.id = r.getInt(1);
                           user.username = username;
                           user.password = password;
                           return user;
                       }
                   }
               }
           }catch(SQLException e) {
               e.printStackTrace();
           }
           return null;
    }
    public static User login(String username,String password) {
        try(Connection connection = DUtil.getConnection()) {
            String sql = "select id from users where username = ? and password = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1,username);
                ps.setString(2,password);
                try(ResultSet r = ps.executeQuery()) {
                    if(r.next()) {
                        User user = new User();
                        user.id = r.getInt(1);
                        user.username = username;
                        user.password = password;
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
