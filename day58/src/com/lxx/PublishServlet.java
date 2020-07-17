package com.lxx;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@MultipartConfig
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
        Part imagePart = req.getPart("image");
        InputStream is = imagePart.getInputStream();
        try(OutputStream os = new FileOutputStream("D:\\照片\\hello.doc")) {
            byte[] buf = new byte[1024];
            while(true) {
                int len = is.read(buf);
                if(len == -1) {
                    break;
                }
                os.write(buf ,0,len);
                os.flush();
            }

        }

        int id = user.id;
        Article.publish(id,title,content);
        resp.sendRedirect("/list.html");
    }
}
