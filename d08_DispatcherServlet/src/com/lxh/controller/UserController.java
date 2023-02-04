package com.lxh.controller;

import com.lxh.pojo.User;
import com.lxh.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@WebServlet("/user.do")
public class UserController {

    private UserService userService;

    public void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.login(username, password);
            if (null == user) {
                // 登录失败
                System.out.println("登录失败");
                return;
            }
            request.getSession().setAttribute("loginUser", user);
            response.sendRedirect( request.getServletContext().getContextPath() + "/user.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void queryList(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<User> users = userService.queryList();
            request.setAttribute("userList", users);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
