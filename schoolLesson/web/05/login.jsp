<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/25
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
    <body>
      <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
          String rememberUsernam = request.getParameter("rememberUsername");
          String rememberPassword = request.getParameter("rememberPassword");
          if (rememberUsernam != null) {
              Cookie c = new Cookie("rememberUsernam", username);
              c.setPath(request.getContextPath());
              c.setMaxAge(Integer.MAX_VALUE);
              response.addCookie(c);
          }else{
              Cookie c = new Cookie("rememberUsernam", username);
              c.setPath(request.getContextPath());
              c.setMaxAge(0);
              response.addCookie(c);
          }
          if (rememberPassword != null) {
              Cookie c = new Cookie("rememberPassword", password);
              c.setPath(request.getContextPath());
              c.setMaxAge(Integer.MAX_VALUE);
              response.addCookie(c);
          }else{
              Cookie c = new Cookie("rememberPassword", password);
              c.setPath(request.getContextPath());
              c.setMaxAge(0);
              response.addCookie(c);
          }
          if ("abc".equals(username) && "123".equals(password)) {
              out.write("登陆成功<br>");
              out.write("<a href=index.jsp>重新登陆....</a>");
          }else{
              out.write("登陆失败<br>");
              out.write("<a href=index.jsp>重新登陆....</a>");
          }
      %>
    </body>
</html>
