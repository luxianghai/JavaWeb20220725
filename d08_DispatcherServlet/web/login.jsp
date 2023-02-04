<%--
  Created by IntelliJ IDEA.
  User: luxianghai
  Date: 2022/8/7
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/d08/">
</head>
<body>
    <form action="user.do" method="post">
        <input type="hidden" name="action" value="login">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit">
    </form>
</body>
</html>
