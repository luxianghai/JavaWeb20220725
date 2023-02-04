package com.lxh.session;

import com.lxh.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet", value = {"/session_servlet"})
public class SessionServlet extends BaseServlet {

    // 获取或创建session
    public void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        response.getWriter().write("SessionId ===>" + session.getId());
        response.getWriter().write("\n是否是新创建的：" + session.isNew());
    }

    // 保存数据到session域
    public void setSessionData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        request.getSession().setAttribute("nick", "兴之所至");
        response.getWriter().write("session保存了数据~~");
    }

    // 获取session域中的数据
    public void getSessionData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        Object nick = request.getSession().getAttribute("nick");
        response.getWriter().write("session域数据：" + nick);
    }
}
