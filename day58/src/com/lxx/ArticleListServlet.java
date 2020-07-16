package com.lxx;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/articleList.json")
public class ArticleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articleList = Article.list();
        String transText = transToJson(articleList);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        resp.getWriter().println(transText);
    }

    private String transToJson(List<Article> articleList) {
        JSONArray array = new JSONArray();
        for(Article article:articleList) {
            JSONObject articleObject = new JSONObject();
            JSONObject authorObject  = new JSONObject();
            authorObject.put("author_id",article.user_id);
            authorObject.put("username",article.username);
            articleObject.put("article_id",article.article_id);
            articleObject.put("title",article.title);
            articleObject.put("published_at",article.published_at);
            articleObject.put("author",authorObject);
            array.add(articleObject);
        }
        return array.toJSONString();
    }
}
