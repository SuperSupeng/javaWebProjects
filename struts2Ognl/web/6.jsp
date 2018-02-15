<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/15
  Time: 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
      <!-- 包含一个动作的执行结果 -->
      你好：<s:action name="a5" executeResult="true"/>
      <s:if test="false">
          真
      </s:if>
      <s:else>
          假
      </s:else>
      <s:url var="u" action="a5">
          <s:param name="username" value="'你好'"/>
      </s:url>
    <a href="${u}">点我</a>
    </body>
</html>
