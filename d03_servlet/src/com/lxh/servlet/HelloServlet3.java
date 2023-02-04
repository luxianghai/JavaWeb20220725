package com.lxh.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @WebServlet(name = "HelloServlet3", value = {"/hello3"})
 * @WebServlet注解用于配置Servlet程序
 * name属性用于设置Servlet的别名，其作用相当于配置文件中的 servlet-name标签
 * value用于指定Servlet的访问路径，可以指定多个(使用逗号分隔),其中相当于配置文件中的 url-pattern
 */
@WebServlet(name = "HelloServlet3", value = {"/hello3"})
public class HelloServlet3 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get请求...");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
    }
}
