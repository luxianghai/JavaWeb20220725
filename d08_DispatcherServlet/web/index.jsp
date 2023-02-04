<%--
  Created by IntelliJ IDEA.
  User: luxianghai
  Date: 2022/8/7
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>年龄</th>
                <th>密码</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.age}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
