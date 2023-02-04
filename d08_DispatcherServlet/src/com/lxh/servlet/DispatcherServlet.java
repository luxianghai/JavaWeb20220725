package com.lxh.servlet;

import com.lxh.util.ClassPathXmlApplication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    private ClassPathXmlApplication xmlApplication = new ClassPathXmlApplication();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        this.action(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * 根据请求参数的action值来确定要执行的方法是哪一个
     * 输入地址：http://localhost:8080/d08/user?action=login
     *         根据地址获取用户请求的资源路径：/user
     *         /user --> user --> UserController
     * @param request
     * @param response
     */
    private void action(HttpServletRequest request, HttpServletResponse response){
        try {
            
            // 获取请求资源路径
            String resourcePath = request.getServletPath();
            // 根据请求资源路径从bean容器中获取controller实例对象
            Object methodObject = getObjectByResourcePath(resourcePath);

            String methodStr = request.getParameter("action");
            if (null == methodStr || "".equals(methodStr)) {
                methodStr = "queryList";
            }
            Method declaredMethod = methodObject.getClass().getDeclaredMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.invoke(methodObject, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据请求资源路径获取要执行的controller对象
     * @param resourcePath
     * @return
     */
    private Object getObjectByResourcePath(String resourcePath) {
        // "/user.do" --> "user"
        String id = resourcePath.substring(1);
        id = id.substring(0,id.lastIndexOf(".do"));
        return xmlApplication.getBean(id);
    }

}
