package com.lxh.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RequestServlet1", value = "/request1")
public class RequestServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是 RequestServlet1 ...");
        /**
         * 请求转发
         * 必须以"/"打头，"/"表示地址为 http://ip:port/工程名/，映射到web目录下
         */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/request2");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/param.html");
        requestDispatcher.forward(req, resp);
    }
}
