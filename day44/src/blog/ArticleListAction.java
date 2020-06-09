package blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ArticleListAction implements Action {
    @Override
    public void run() {
        List<String[]> articlelist = new ArrayList<>();
        Map<String,String> authornicknamemap = new HashMap<>();
        try(Connection c = DBUtil.getConnection()) {
            String sql = "select id,author_id,title,published_at from articles order by published_at desc";
            try(PreparedStatement s = c.prepareStatement(sql)) {
                try(ResultSet r = s.executeQuery()) {
                    while(r.next()) {
                        String[] article = new String[4];
                        article[0] = r.getString(1);//id
                        article[1] = r.getString(2);//author_id
                        article[2] = r.getString(3);//title
                        article[3] = r.getString(4);//published_at
                        articlelist.add(article);
                    }
                }
            }
            Set<String> authoridSet = new HashSet<>();
            for(String[] s : articlelist) {
                authoridSet.add(s[1]);
            }
            StringBuilder querysql = new StringBuilder("select id , nickname from user where id in (");
            for (int i = 1; i < authoridSet.size(); i++) {
                querysql.append("?,");
            }
            querysql.append("?)");
            try(PreparedStatement s = c.prepareStatement(querysql.toString())) {
                  int i = 1;
                for (String id :authoridSet) {
                    s.setString(i++,id);
                }

                try(ResultSet r = s.executeQuery()) {
                    while(r.next()) {
                        authornicknamemap.put(r.getString(1),r.getString(2));
                    }
                }
            }
            for(String[] s : articlelist) {
                System.out.printf("%-4s | %-40s | %-10s | %s%n",s[0],s[2],authornicknamemap.get(s[1]),s[3]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
