package com.lxh.filter;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            System.out.println("TransactionFilter...");
            // 事务处理
            // 如果没有发生异常信息则放行然后提交事务
            filterChain.doFilter(servletRequest, servletResponse);
            // 提交事务操作
        } catch(Exception e) {
            // 如果有异常则将异常抛出去给Tomcat处理
            e.printStackTrace();
            throw new RuntimeException(e);
            // 事务回滚
        }
    }

    @Override
    public void destroy() {

    }
}
