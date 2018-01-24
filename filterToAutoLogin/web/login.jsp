<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/24
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
    用户名：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="checkbox" name="auto"/>记住我<br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
