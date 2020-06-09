package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ArticleDetailAction implements Action {
    @Override
    public void run() {
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
            String articlesql = "select author_id, title ,content ,published_at from articles where id = ?";
            try(PreparedStatement s = c.prepareStatement(articlesql)) {
                s.setInt(1,id);
                try(ResultSet r = s.executeQuery()) {
                    if(r.next()) {
                       author_id = r.getString(1);
                       title = r.getString(2);
                       content = r.getString(3);
                       published_at = r.getString(4);
                    } else {
                        System.out.println("对不起，没有你要查看的文章");
                    }
                }
            }
            String like_relationsql = "select count(*) from like_relations where article_id = ?";
            try(PreparedStatement s = c.prepareStatement(articlesql)) {
                s.setInt(1,id);
                try(ResultSet r = s.executeQuery()) {
                    r.next();
                    likeconnt = r.getInt(1);
                }
            }
            String commentsql = "select user_id,content,published_at from comments where  article_id = ?";
            try(PreparedStatement s = c.prepareStatement(commentsql)) {
                s.setInt(1,id);
                try(ResultSet r = s.executeQuery()) {
                    String[] comment = new String[3];
                    comment[0] = r.getString(1);
                    comment[1] = r.getString(2);
                    comment[2] = r.getString(3);
                    commentList.add(comment);
                }
            }
            Set<String> nickenameset = new HashSet<>();
            nickenameset.add(author_id);
            for(String[] s :commentList) {
                nickenameset.add(s[0]);
            }

            Map<String,String> nicknamemap = new HashMap<>();
            StringBuilder mapsql = new StringBuilder("select id ,nickname from user where id in (");
            for (int i = 1; i < nickenameset.size() ; i++) {
                mapsql.append("?,");
            }
            mapsql.append("?)");
            try(PreparedStatement s = c.prepareStatement(mapsql.toString())) {
                int i = 1;
                for (String st:nickenameset) {
                    s.setString(i++,st);
                }
                try(ResultSet r = s.executeQuery()){
                    while(r.next()) {
                        nicknamemap.put(r.getString(1),r.getString(2));
                    }
                }
            }
            System.out.println(nicknamemap.get(author_id));
            System.out.println(title);
            System.out.println(content);
            System.out.println(published_at);
            System.out.println(likeconnt);
            for (String[] sg:commentList) {
                System.out.println(nicknamemap.get(sg[0]) + "|" + sg[1] + "|" + sg[2]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
