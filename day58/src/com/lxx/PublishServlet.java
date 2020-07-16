package com.lxx;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/publish")
public class PublishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null) {
            resp.sendRedirect("login.html");
            return;
        }
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int id = user.id;
        Article.publish(id,title,content);
        resp.sendRedirect("/list.html");
    }
}
