package com.lxx;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article {
    public int user_id;
    public String username;
    public String title;
    public String published_at;
    public int article_id;
    public static void publish(int id,String title,String content) {
         DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         String publish_at = format.format(date);

         try(Connection connection = DUtil.getConnection()) {
            String sql = "insert into articles(author_id,title,content,published_at) values (?,?,?,?)";
            try(PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,id);
                ps.setString(2,title);
                ps.setString(3,content);
                ps.setString(4,publish_at);
                ps.executeUpdate();
            }
         } catch(SQLException e) {
             e.printStackTrace();
         }
     }
     public static List<Article> list() {
         List<Article> articleList = new ArrayList<>();
         try(Connection connection = DUtil.getConnection()) {
              String sql = "select users.id as user_id,username,title, published_at,articles.id as article_id from users join articles on users.id = author_id order by published_at desc";
              try(PreparedStatement ps = connection.prepareStatement(sql)) {
                  try(ResultSet r = ps.executeQuery()) {
                      while(r.next()) {
                          Article article = new Article();
                          article.user_id = r.getInt("user_id");
                          article.username = r.getString("username");
                          article.title = r.getString("title");
                          article.published_at = r.getString("published_at");
                          article.article_id = r.getInt("article_id");
                          articleList.add(article);
                      }
                  }
              }
         }catch(SQLException e) {
             e.printStackTrace();
         }
         return articleList;
     }
}
