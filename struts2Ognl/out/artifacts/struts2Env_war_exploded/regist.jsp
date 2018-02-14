<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/14
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <s:form action="regist1">
        <s:token/>
        <!-- 产生一个唯一的令牌。存到：input hidden；HttpSession中 -->
        <s:textfield name="username" label="用户名"/>
        <s:submit value="保存"/>
    </s:form>
    </body>
</html>
