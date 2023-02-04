<%--
  Created by IntelliJ IDEA.
  User: luxianghai
  Date: 2022/7/28
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("pageContext", "PageContextImpl");
        request.setAttribute("request", "HttpServletRequest");
        session.setAttribute("session", "HttpSession");
        application.setAttribute("application", "ServletContext");
    %>
    pageContext: <%=pageContext.getAttribute("pageContext") %>
    request: <%=request.getAttribute("request") %>
    session: <%=session.getAttribute("session") %>
    application: <%=application.getAttribute("application") %>

</body>
</html>
