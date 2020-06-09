package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ArticlePublishAction implements Action{
    @Override
    public void run() {
        if(User.isLoginned()) {
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入文章标题> ");
            String title = scan.nextLine();
            System.out.print("请输入文章内容> ");
            String content = scan.nextLine();
            int author_id = User.getCurrentUser().id;
            Date  published_at = new Date();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String publishedatstr = format.format(published_at);
            try(Connection c = DBUtil.getConnection()) {
                String sql = "insert into articles (author_id,title,content,published_at) values (?,?,?,?)";
                try(PreparedStatement s = c.prepareStatement(sql)) {
                    s.setInt(1,author_id);
                    s.setString(2,title);
                    s.setString(3,content);
                    s.setString(4,publishedatstr);
                    s.executeUpdate();
                    System.out.println("发表成功");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("您还没有登录");
        }
    }
}
