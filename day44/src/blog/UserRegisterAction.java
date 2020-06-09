package blog;

import java.sql.*;
import java.util.Scanner;

public class UserRegisterAction implements Action {
    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入用户名> ");
        String username = scan.nextLine();
        System.out.print("请输入用户昵称> ");
        String nickname = scan.nextLine();
        System.out.print("请输入密码> ");
        String password = scan.nextLine();
        try(Connection c = DBUtil.getConnection()) {
            String sql = "insert into user (username,nickname,password) values (?,?,?)";
            try(PreparedStatement s = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                s.setString(1,username);
                s.setString (2,nickname);
                s.setString (3,password);
                s.executeUpdate();
                System.out.println("注册成功");
                User user = new User();
                int id;
                try(ResultSet r = s.getGeneratedKeys()) {
                    r.next();
                    id = r.getInt(1);
                }
                user.id = id;
                user.username = username;
                user.nickname = nickname;
                User.login(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
