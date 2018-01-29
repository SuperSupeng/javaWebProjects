<%--
  Created by IntelliJ IDEA.
  User: super
  Date: 2018/1/29
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<br/><br/>
<table border="1" width="438" class="table">
    <tr>
        <th>选择</th>
        <th>分类名称</th>
        <th>分类描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="vs">
        <tr class="${vs.index%2==0?'odd':'even' }">
            <td>
                <input type="checkbox" name="ids" value="${c.id}"/>
            </td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td>
                <a href="javascript:alert('略')">修改</a>
                <a href="javascript:alert('略')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
