package com.lxh.cookie;

import com.lxh.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "LoginServlet", value = {"/login_servlet"})
public class LoginServlet extends BaseServlet {

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("lxh".equals(username) && "123456".equals(password)) {
            // 登录成功
            Cookie cookie = new Cookie("username", username);
            // 设置存活时间为一星期
            cookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(cookie);
        }
    }
}
