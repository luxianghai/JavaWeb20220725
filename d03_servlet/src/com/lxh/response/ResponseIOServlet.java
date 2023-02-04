package com.lxh.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseIOServlet", value = {"/resp_io"})
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*// 设置服务器字符集为utf-8
        resp.setCharacterEncoding("UTF-8");
        // 通过响应头设置浏览器使用utf-8字符集
        resp.setHeader("Content-Type", "text/html;charset=utf-8");*/
        // setContentType()方法会同时设置浏览器和服务器均使用utf-8编码
        // 此方法一定要在获取流之前调用
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("你好，大海");
    }
}
