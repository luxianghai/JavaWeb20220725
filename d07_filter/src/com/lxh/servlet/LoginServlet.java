package com.lxh.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/login.do"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // 获取用户名和密码
            String username = req.getParameter("username").toString();
            String password = req.getParameter("password").toString();
            // 判断用户名密码是否正确
            if ("lxh".equals(username) && "123456".equals(password)) {
                // 登录成功
                System.out.println("登录成功！！！");
                // 将用户名保存到session中
                req.getSession().setAttribute("username", username);
                // 重定向到 index.html
                resp.sendRedirect(req.getContextPath() + "/index.html");
            } else {
                // 登录失败
                System.out.println("登录失败！！！");
                resp.sendRedirect(req.getContextPath() + "/login.html");
            }
            int i = 5/0;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
