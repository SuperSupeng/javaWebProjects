<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/12
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
</head>
    <body>
      <s:text name="hello"/>
    <hr/>
    <s:textfield name="name" key="name"/>
    <hr/>
    <s:text name="welcome">
        <s:param>小小</s:param>
        <s:param>xxxxxxx</s:param>
    </s:text>
    </body>
</html>
