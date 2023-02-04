package com.lxh.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "RequestAPIServlet", value = "/request_api")
public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取URI和URL
        System.out.println("URI ==>>> " + req.getRequestURI()); // /d03_servlet/request_api
        System.out.println("URL ==>>> " + req.getRequestURL()); // http://localhost:8080/d03_servlet/request_api
        // 获取访问服务器的客户端IP地址
        System.out.println("客户端IP地址 ==>>> " + req.getRemoteHost()); // 0:0:0:0:0:0:0:1
        // 获取指定的请求头
        System.out.println("请求头User-Agent ==>>> " + req.getHeader("User-Agent"));
        // 获取请求方式
        System.out.println("请求方式 ==>>> " + req.getMethod()); // GET
        System.out.println("test push");
    }
}
