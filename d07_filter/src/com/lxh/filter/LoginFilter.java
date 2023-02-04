package com.lxh.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object username = request.getSession().getAttribute("username");

        // 获取请求资源路径
        String url = request.getServletPath();
        System.out.println("url = " + url);

        // 允许为登录也能访问的资源 - 共享资源
        ArrayList<String> allowList = new ArrayList<>(10);
        allowList.add("/login.html");
        allowList.add("/login.do");
        allowList.add(".css");
        allowList.add(".js");

        if (allowList.contains(url)) {
            // 访问共享资源
            // 放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (null != username) {
            // 已登录
            // 发行
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            // 未登录
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
