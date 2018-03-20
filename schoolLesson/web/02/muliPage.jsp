<%@ page import="util.CounterReaderUtil" %><%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/25
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
    <body>
      <h1>JSP实验：九九乘法表</h1>
      <hr>
      <%
        for(int i = 1; i<10; i++){
            for(int j = 1; j<=i; j++){
                out.write(i + "*" + j + "=" + (i*j) + "\t");
            }
            out.write("<br>");
        }
      %>
      <h1>网站计数器</h1>
      <hr/>

      <h3>您好、您是本站第
          <%
              String path = "count.txt";
              String s = CounterReaderUtil.readCount(path);
              for(int i = 0; i<s.length(); i++){
                  char a = s.charAt(i);
                  out.write("<img src='../img/"+a+".png' height=\"50\" width=\"50\">");
              }
              int v = Integer.valueOf(s);
              v++;
              CounterReaderUtil.saveCount(v+"", path);
          %>
          个访问者</h3>
    </body>
</html>
