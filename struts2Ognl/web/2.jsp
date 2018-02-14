<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/14
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
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
    <%
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        request.setAttribute("list", list);
    %>
    <s:iterator value="#request.list" var="s">
        <s:property value="#s"/>${s}<br/>
    </s:iterator>
    <hr/>
    <%
        Map map = new HashMap();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        request.setAttribute("map", map);
    %>
    <s:iterator value="#request.map" var="me">
        <s:property value="#me.key"/>=<s:property value="#me.value"/>:::${me.key}=${me.value}<br/>
    </s:iterator>
    <hr/>
    <%
        List list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        list1.add("f");
        request.setAttribute("list1", list1);
    %>
    <s:iterator value="#request.list1" var="s" begin="1" end="6" step="2">
        <s:property value="#s"/>${s}<br/>
    </s:iterator>
    <hr/>
    <table broder="1">
        <tr>
            <th>key</th>
            <th>value</th>
        </tr>
        <s:iterator value="#application" var="me" status="status">
            <%--
            <tr class="${status.odd?'odd':'even'}">
             --%>
            <tr class="<s:property value='#status.odd?"even":"odd"'/>">
                <td>${me.key}</td>
                <td>${me.value}</td>
            </tr>
        </s:iterator>
    </table>
    <s:debug/>
    </body>
</html>
