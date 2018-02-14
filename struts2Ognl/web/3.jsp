<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/14
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>OGNL构建List和Map</title>
    <style type="text/css">
        .odd{
            background-color: #c3f3c3;
        }
        .even{
            background-color: #f3c3f3;
        }
    </style>
</head>
    <body>
    <br/>---------OGNL创建List-----------<br/>
    <%
        List list = new ArrayList();
        list.add("男性");
        list.add("女性");
        list.add("未知");
        request.setAttribute("gs", list);
    %>
    <s:radio list="#request.gs" name="gender"/>
    <hr/>
    <s:radio list="{'男','女'}" name="gender"/>
    <br/>---------OGNL创建Map-----------<br/>
    <s:radio list="#{'male':'男男','female':'女女'}" name="gender"/>
    <hr/>
    <s:checkboxlist list="#{'eat':'吃','sleep':'睡'}" name="hobby"/>
    <s:debug/>
    </body>
</html>
