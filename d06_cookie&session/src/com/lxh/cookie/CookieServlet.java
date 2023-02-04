package com.lxh.cookie;

import com.lxh.BaseServlet;
import com.lxh.util.CookieUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieServlet", value = {"/cookie_servlet"})
public class CookieServlet extends BaseServlet {

    // 测试path属性
    public void path(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("path", "test_path");
        // 设置cookie的path属性  -  /工程路径/abc
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
    }

    // 创建cookie
    public void createCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("username", "lxh");
        resp.addCookie(cookie);
    }

    // 获取cookie
    public void getCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtils.getCookie("username", cookies);
        if (null == cookie) {
            System.out.println("cookie不存在");
        } else {
            System.out.println(cookie.getName() + " - " + cookie.getValue());
        }
    }

    // 修改cookie值
    public void updateCookie(HttpServletRequest req, HttpServletResponse resp) {
        // 方案一修改cookie值
        /*Cookie cookie = new Cookie("username", "zs");
        resp.addCookie(cookie);*/

        // 方案二修改cookie值
        Cookie cookie = CookieUtils.getCookie("username", req.getCookies());
        cookie.setValue("lisi");
        resp.addCookie(cookie);
    }

    // 创建一个指定存活时间的cookie
    public void cookieLife3600(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("password", "123456");
        // 指定cookie存活时间为3600S
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
    }

    // 创建一个默认存活时间的cookie
    public void cookieLifeDefault(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("nick", "一直沉默的猪");
        resp.addCookie(cookie);
    }

    // 立即删除一个指定的cookie
    public void deleteNow(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = CookieUtils.getCookie("password", req.getCookies());
        if (null != cookie) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            System.out.println("成功删除cookie！");
        }
    }
}