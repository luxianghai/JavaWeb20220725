package com.lxh.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ParamServlet", value = {"/req_param"})
public class ParamServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求体的字符集为utf-8，从而解决中文乱码问题
        req.setCharacterEncoding("utf-8");
        // 获取参数值是根据表单中的 name 值来获取的
        // getParameter() - 获取指定key的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        // 获取复选框的值
        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println("hobbies = " + Arrays.asList(hobbies));
    }
}
