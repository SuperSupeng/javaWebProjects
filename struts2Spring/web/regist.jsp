<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/14
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <s:form action="regist">
        <s:textfield name="name" label="姓名"/>
        <s:submit value="注册"/>
    </s:form>
    </body>
</html>
