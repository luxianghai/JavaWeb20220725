package com.lxh.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadServlet", value = {"/upload"})
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        // 1.判断是否是多段数据上传的表单（多段数据才可能是文件上传）
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建 FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类 ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                // 将上传的数据解析到 List 集合中
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem item: list) {
                    if (item.isFormField()) {
                        // 普通表单项
                        // 获取表单项的name值
                        String fieldName = item.getFieldName();
                        // 获取表单项的value值,指定编码为utf-8
                        String value = item.getString("UTF-8");
                        System.out.println(fieldName + " = " + value);
                    } else {
                        // 文件
                        System.out.println("表单项的name值：" + item.getFieldName());
                        System.out.println("上传的文件名：" + item.getName());
                        // 获取工程部署路径 "/"映射到 http://ip:port/工程路径/
                        String realPath = getServletContext().getRealPath("/");
//                        System.out.println("realPath = " + realPath);
//                        long size = item.getSize();
//                        System.out.println("size = " + size);
//                        String contentType = item.getContentType();
//                        System.out.println("contentType = " + contentType);
                        // 限制文件类型只能为 .jpg 和 .jpeg
                        if (!item.getName().endsWith(".jpg") && !item.getName().endsWith(".jpeg")) {
                            throw new RuntimeException("文件类型不符");
                        }
                        // 限制文件大小最大为200KB：102400Byte = 1024Byte*100 = 100KB   --》 *2=200KB
                        if (item.getSize() > 102400*2) {
                            throw new RuntimeException("文件太大，超过200KB了");
                        }
                        item.write(new File(realPath + "\\file\\" + item.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
