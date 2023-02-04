package com.lxh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextServlet2", value = {"/context2"})
public class ContextServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取域数据
        Object id = getServletContext().getAttribute("id");
        Object name = getServletContext().getAttribute("name");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }
}
