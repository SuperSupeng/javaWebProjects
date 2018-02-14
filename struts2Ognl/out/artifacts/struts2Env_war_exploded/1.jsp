<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/14
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        locale:<s:property value="locale"/><!-- getLocale --><br/>
        request:<s:property value="#request.p"/><br/>
        session:<s:property value="#session.p"/><br/>
        application:<s:property value="#application.p"/><br/>
        p:<s:property value="#attr.p"/><br/>
        <hr/>
        ${locale}<br/>
        ${requestScope.p}<br/>
        ${sessionScope.p}<br/>
        <s:debug/>
    </body>
</html>
