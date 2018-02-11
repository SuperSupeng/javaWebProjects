<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/11
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <s:actionerror/>
    <s:form action="regist" namespace="/person">
        <s:textfield name="username" label="用户名"/>
        <s:textfield name="password" label="密码"/>
        <s:textfield name="repassword" label="重复密码"/>
        <s:textfield name="email" label="邮箱"/>
        <s:textfield name="birthday" label="出生日期"/>
        <s:textfield name="netaddress" label="日记地址"/>
        <s:submit value="保存"/>
    </s:form>
    </body>
</html>
