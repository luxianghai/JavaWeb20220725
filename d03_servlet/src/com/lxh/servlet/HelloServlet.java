package com.lxh.servlet;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet程序的别名 ==>> " + servletConfig.getServletName());
        System.out.println("username参数值为：" + servletConfig.getInitParameter("username"));
        System.out.println("password参数值为：" + servletConfig.getInitParameter("password"));

        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了！！！");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
