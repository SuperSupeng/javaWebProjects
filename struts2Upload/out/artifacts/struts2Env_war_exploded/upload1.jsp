<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/2/12
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:actionerror/>
<s:form action="upload1" enctype="multipart/form-data">
    <s:textfield name="name" label="姓名"></s:textfield>
    <s:file name="photo" label="靓照"></s:file>
    <s:submit value="保存"></s:submit>
</s:form>
</body>
</html>
