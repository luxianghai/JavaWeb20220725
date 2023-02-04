package com.lxh.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "ResponseServlet1", value = {"/resp1"})
public class ResponseServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*// 设置状态码，302表示重定向
        resp.setStatus(302);
        // 设置响应头，说明新的地址在哪里
        resp.setHeader("location", "http://localhost:8080/d03_servlet");*/
        resp.sendRedirect("/d03_servlet");
    }
}
