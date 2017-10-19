<%--
  Created by IntelliJ IDEA.
  User: Jerry
  Date: 2017/10/19
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<%=request.getParameter("error_info")%>
</body>
</html>
