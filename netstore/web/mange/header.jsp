<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>后台业务管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <%@include file="../template/bootstrapTemplate.html"%>
</head>

<body>
<br/><br/>
<h1>后台管理</h1>
<br/>
<a href="${pageContext.request.contextPath}">添加分类</a>
<a href="${pageContext.request.contextPath}">查询分类</a>
<a href="${pageContext.request.contextPath}">添加图书</a>
<a href="${pageContext.request.contextPath}">查询图书</a>
<a href="">待处理订单</a>
<a href="">已处理订单</a>
<br/>
