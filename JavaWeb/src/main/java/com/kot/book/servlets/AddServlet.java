package com.kot.book.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yf
 * @create 2022-12-09 17:13
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        System.out.println("书籍的名称是： " + req.getParameter("bname"));
        System.out.println("书籍的价格是： " + req.getParameter("price"));
        System.out.println("书籍的作者是： " + req.getParameter("auther"));
        System.out.println("书籍的出版日期是： " + req.getParameter("datetime"));
    }
}
