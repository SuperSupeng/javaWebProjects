<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/24
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:if test="${sessionScope.user==null}">
    <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
  </c:if>
  <c:if test="${sessionScope.user!=null}">
    欢迎您： ${sessionScope.user.nickname}
    <a href="#">注销</a>
  </c:if>
  </body>
</html>
