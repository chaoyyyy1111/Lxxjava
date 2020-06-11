package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ArticleDetailAction implements Action {
    @Override
    public void run() {
        String nickname = null;
        String author_id = null;
        String title = null;
        String content = null;
        String published_at = null;
        int likeconnt = 0;
        List<String[]> commentList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入要查看文章的id> ");
        int id = scan.nextInt();
        try(Connection c = DBUtil.getConnection()) {
            String articlesql = "select nickname , title ,content ,published_at from articles,user " +
                    "where user.id = author_id and articles.id = ?";
            try(PreparedStatement s = c.prepareStatement(articlesql)) {
                s.setInt(1,id);
                try(ResultSet r = s.executeQuery()) {
                    if(r.next()) {
                       nickname = r.getString(1);
                       title = r.getString(2);
                       content = r.getString(3);
                       published_at = r.getString(4);
                    } else {
                        System.out.println("对不起，没有你要查看的文章");
                    }
                }
            }
            String like_relationsql = "select count(*) from like_relations where article_id = ?";
            try(PreparedStatement s = c.prepareStatement(like_relationsql)) {
                s.setInt(1,id);
                try(ResultSet r = s.executeQuery()) {
                    r.next();
                    likeconnt = r.getInt(1);
                }
            }
            String commentsql = "select nickname,content,published_at from comments ,user " +
                    "where user.id = user_id and article_id = ? order by published_at desc";
            try(PreparedStatement s = c.prepareStatement(commentsql)) {
                s.setInt(1,id);
                try(ResultSet r = s.executeQuery()) {
                    while(r.next()) {
                        String[] comment = new String[3];
                        comment[0] = r.getString(1);
                        comment[1] = r.getString(2);
                        comment[2] = r.getString(3);
                        commentList.add(comment);
                    }
                }
            }

            System.out.println(nickname);
            System.out.println(title);
            System.out.println(content);
            System.out.println(published_at);
            System.out.println(likeconnt);
            for (String[] sg:commentList) {
                System.out.println(sg[0] + "|" + sg[1] + "|" + sg[2]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
