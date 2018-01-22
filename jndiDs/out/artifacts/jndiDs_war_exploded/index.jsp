<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="util.JndiDsUtil" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/22
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Context initContext = new InitialContext();
    //Context envContext  = (Context)initContext.lookup("java:/comp/env");//目录
    //DataSource ds = (DataSource)envContext.lookup("jdbc/test");

    DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/test");
    Connection conn = ds.getConnection();
    out.write(conn.toString());
  %>
  <hr/>
  <%out.write(JndiDsUtil.getConnection().toString()); %>
  </body>
</html>
