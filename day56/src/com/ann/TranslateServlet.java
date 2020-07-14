package com.ann;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TranslateServlet extends HttpServlet {
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("apple","苹果");
        map.put("pear","梨子");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wd = req.getParameter("lm");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(wd);
        writer.println("<h1>lxx的字典</h1>");
        //writer.println("<p>"+s+"的意思是"+map.get(s)+"</p>");
    }

}
