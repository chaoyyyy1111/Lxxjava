package com.lxx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/list.html")
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String nav = "";
        if(user == null) {
            nav = "<li><a href = login.html>登录</a></li>\n" +
                    "            <li><a href = register.html>注册</a></li>";
        } else {
            nav = "<li>"+user.username+"</li>\n" +
                    "            <li><a href = publish.html>发表文章</a></li>";
        }

        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>博客系统</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class = \"navigate\">\n" +
                "        <ol>\n" +
                           nav+
                "        </ol>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "没有发表任何文章"+
                "</body>\n" +
                "</html>");
    }
}
