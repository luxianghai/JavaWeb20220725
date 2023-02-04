package com.lxh.file;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(name = "DownloadServlet", value = {"/download"})
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 要下载的目标文件, targetFile中的第一个"/"表示 http://ip:port/工程路径/
        // "/file/" 表示地址为 http://ip:port/工程路径/file/
        String fileName = "无标题.jpg";
        String targetFile = "/file/" + fileName;
        // 获取目标文件的 MimeType 类型
        String mimeType = getServletContext().getMimeType(targetFile);
        //System.out.println("mimeType = " + mimeType);
        // 设置响应给客户端的文件是什么样的格式
        resp.setContentType(mimeType);
        // Content-Disposition 响应头表示客户端接收到的数据要怎么处理
        // attachment表示附件，表示下载使用
        String str = "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8");
        resp.setHeader("Content-Disposition", str);

        // 获取输入流
        InputStream resourceAsStream = getServletContext().getResourceAsStream(targetFile);
        // 获取响应输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        // 将输入流的数据复制到响应输出流中，完成将数据传递到客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
