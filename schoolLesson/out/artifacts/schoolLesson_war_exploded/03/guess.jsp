<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/25
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>guess</title>
</head>
    <body>
      <%
        String guessNum = request.getParameter("guessNum");
        int val = Integer.valueOf(guessNum);
        if(session.getAttribute("randNum") == null){
            int r = new Random().nextInt(101);
            session.setAttribute("randNum", r);
        }
        Integer randNum = (Integer) session.getAttribute("randNum");
        if(val > randNum){
            out.write("大了");
        }else if(val < randNum){
            out.write("小了");
        }else{
            out.write("猜对了");
            int r = new Random().nextInt(101);
            session.setAttribute("randNum", r);
        }
        out.write("<br>");
        out.write("<a href=index.jsp>再来一次</a>");
      %>
    </body>
</html>
