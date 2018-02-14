<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/14
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Struts2的常用标签</title>
</head>
    <body>
    <!--
    value:默认值是取栈顶对象
     -->
    <s:property value="name1" default="木有"/>
    <hr/>
    <!--
    不指定var，把当前元素压到栈顶
     -->
    <s:iterator value="students">
        <s:property value="name"/>:<s:property value="age"/>:<s:property value="gender"/><br/>
    </s:iterator>
    <!-- scope如果不指定会放到contextMap和request范围中 -->
    <s:set var="p" value="'ppppp'"/>
    <hr/>
    <s:property value="#p"/><br/>
    <s:property value="#request.p"/><br/>

    <hr/>
    <s:push value="'ppp'"/>

    <s:debug/>
    </body>
</html>
