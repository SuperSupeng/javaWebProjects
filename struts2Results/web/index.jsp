<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/8
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
    <body>
      <a href="${pageContext.request.contextPath}/sayHello.action">第一个struts2案例</a>
      <form action="">
        验证码：<input type="text"/><img src="${pageContext.request.contextPath}/captcha.action"/>
      </form>
    </body>
</html>
