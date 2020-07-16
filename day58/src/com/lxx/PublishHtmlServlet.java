package com.lxx;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/publish.html")
public class PublishHtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null) {
            resp.sendRedirect("login.html");
            return;
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>发表文章</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <form action = \"publish\" method=\"post\">\n" +
                "        <div>\n" +
                "            <label for = \"title\" >文章标题</label>\n" +
                "            <input type = \"text\"  name = \"title\" id = \"title\"/>\n" +
                "        </div>\n" +
                "\n" +
                "        <div>\n" +
                "            <label for = \"content\" >正文内容</label>\n" +
                "            <textarea id = \"content\" name = \"content\"></textarea>\n" +
                "        </div>\n" +
                "\n" +
                "        <div>\n" +
                "            <button type = \"submit\">发表</button>\n" +
                "        </div>\n" +
                "\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }
}
