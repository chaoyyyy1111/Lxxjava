package com.ann;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ReqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        func(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        func(req,resp);
    }

    public void func(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String method = req.getMethod();
        writer.println(method);
        writer.println(req.getRequestURI());
        writer.println(req.getContextPath());
        writer.println(req.getServletPath());
        writer.println(req.getQueryString());
        Enumeration<String> parameterNames = req.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            writer.println(name);
            writer.println(req.getParameter(name));
        }
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            writer.println(name + "="+ req.getHeader(name));

        }
        writer.println(req.getParameter("username"));
        writer.println(req.getParameter("password"));
    }
}
