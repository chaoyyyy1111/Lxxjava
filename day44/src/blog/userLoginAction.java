package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class userLoginAction implements Action {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入用户名> ");
        String username = scan.nextLine();
        System.out.print("请输入密码> ");
        String password = scan.nextLine();
        try(Connection c = DBUtil.getConnection()) {
            String sql = "select id , nickname from user where username = ? and password = ?";
            try(PreparedStatement s = c.prepareStatement(sql)) {
                s.setString(1,username);
                s.setString(2,password);
                try(ResultSet r = s.executeQuery()) {
                    if(r.next()) {
                        User user = new User();
                        user.id = r.getInt(1);
                        user.username = username;
                        user.nickname = r.getString(2);
                        User.login(user);
                    } else {
                        System.out.println("您的用户名或密码输入错误");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
