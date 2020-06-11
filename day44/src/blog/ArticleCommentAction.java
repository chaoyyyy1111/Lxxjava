package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ArticleCommentAction implements Action{
    @Override
    public void run() {
        if(User.isLoginned()) {
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入要评论文章的id> ");
            int article_id = scan.nextInt();
            System.out.print("请输入要评论的内容> ");
            String content = scan.next();
            int user_id = User.getCurrentUser().id;
            Date pub = new Date();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String  published_at = format.format(pub);
            try(Connection c = DBUtil.getConnection()) {
                String sql = "insert into comments (user_id,article_id,content,published_at) values (?,?,?,?)";
                try(PreparedStatement s = c.prepareStatement(sql)) {
                    s.setInt(1,user_id);
                    s.setInt(2,article_id);
                    s.setString(3,content);
                    s.setString(4,published_at);
                    s.executeUpdate();
                    System.out.println("评论成功");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("对不起,你还没有登录");
        }
    }
}
