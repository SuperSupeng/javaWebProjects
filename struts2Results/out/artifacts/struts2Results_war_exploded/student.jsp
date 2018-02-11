<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/act1" method="post">
    	用户名：<input type="text" name="student.username"/><br/>
    	密码：<input type="text" name="student.password"/><br/>
    	昵称：<input type="text" name="student.nickname"/><br/>
    	<input type="submit" value="注册"/>
    </form>
  </body>
</html>
