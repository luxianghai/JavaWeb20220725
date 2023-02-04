<%--
  Created by IntelliJ IDEA.
  User: luxianghai
  Date: 2022/7/28
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/d05_file_load/upload" enctype="multipart/form-data" method="post">
        用户名：<input type="text" name="username"><br>
        头像：<input type="file" name="photo">
        <input type="submit" value="提交">
    </form>
</body>
</html>
