package com.lxh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "ContextServlet1", value = {"/context1"})
public class ContextServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ContextServlet1.doGet()");
        // 获取web.xml中通过 context-param 配置的全局参数
        String author = getServletContext().getInitParameter("author");
        System.out.println("author = " + author);
        // 获取当前工程的工程路径
        // "/"被服务器解析为 http://ip:port/工程路径/，映射到web目录下
        System.out.println("工程部署的路径为： " + getServletContext().getRealPath("/"));
        System.out.println("工程中web目录下的css目录的全路径： " + getServletContext().getRealPath("/css"));
        // 设置域数据，作用域为整个工程
        getServletContext().setAttribute("id", "1001");
        getServletContext().setAttribute("name", "zs");
    }
}
