<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/25
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
    <body>
      <%
        Cookie cs[] = request.getCookies();
        String username = null;
        String password = null;
        for(Cookie c : cs){
            if(c.getName().equals("rememberUsernam")){
                username = c.getValue();
            }
            if(c.getName().equals("rememberPassword")){
                password = c.getValue();
            }
        }
        if(username == null){
            username = "";
        }
        if(password == null){
            password = "";
        }
          out.write("<form action='login.jsp' method='post'>");
          out.write("用户名:<input type='text' name='username' value='"+username+"'/><br/>");
          out.write("密码:<input type='password' name='password' value='"+password+"'/><br/>");
          out.write("记住用户名:<input type='checkbox' name='rememberUsername'/><br/>");
          out.write("记住密码:<input type='checkbox' name='rememberPassword'/><br/>");
          out.write("<input type='submit' value='登录'/>");
          out.write("<input type='reset' value='重置'/>");
          out.write("</form>");
      %>
    </body>
</html>
