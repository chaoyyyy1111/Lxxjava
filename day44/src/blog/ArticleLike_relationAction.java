package blog;


import java.sql.*;
import java.util.Scanner;

public class ArticleLike_relationAction implements Action {
    @Override
    public void run()  {
        if(User.isLoginned()) {
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入要评论文章的id> ");
            int article_id = scan.nextInt();
            int user_id = User.getCurrentUser().id;
            try(Connection c = DBUtil.getConnection()) {
                String sql = "insert into like_relations (user_id,article_id) values (?,?) ";
                try(PreparedStatement s = c.prepareStatement(sql)) {
                    s.setInt(1,user_id);
                    s.setInt(2,article_id);
                    s.executeUpdate();
                    System.out.println("点赞成功");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("对不起,你还没有登录");
        }
    }
}
