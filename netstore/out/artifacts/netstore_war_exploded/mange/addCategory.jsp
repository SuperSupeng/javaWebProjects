<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/28
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<div class="addForm">
<form action="${pageContext.request.contextPath}/ControlServlet?op=addCategory" method="post">
    <div class="form-group">
    <table border="1" width="438" class="table">
        <tr>
            <td>分类名称：</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>分类描述：</td>
            <td>
                <textarea rows="3" name="description"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="btn btn-primary" value="保存"/>
            </td>
        </tr>
    </table>
    </div>
</form>
</div>
</body>
</html>
