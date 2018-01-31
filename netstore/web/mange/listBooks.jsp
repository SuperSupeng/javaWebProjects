<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<br/><br/>
<table border="1" width="638">
    <tr>
        <th nowrap="nowrap">选择</th>
        <th nowrap="nowrap">书名</th>
        <th nowrap="nowrap">作者</th>
        <th nowrap="nowrap">单价</th>
        <th nowrap="nowrap">描述</th>
        <th nowrap="nowrap">所属分类</th>
        <th nowrap="nowrap">图片</th>
        <th nowrap="nowrap">操作</th>
    </tr>
    <c:forEach items="${page.records}" var="b" varStatus="vs">
        <tr class="${vs.index%2==0?'odd':'even' }">
            <td nowrap="nowrap">
                <input type="checkbox" name="ids" value="${b.id}"/>
            </td>
            <td nowrap="nowrap">${b.name}</td>
            <td nowrap="nowrap">${b.author}</td>
            <td nowrap="nowrap">${b.price}</td>
            <td nowrap="nowrap">${b.description}</td>
            <td nowrap="nowrap">${myfn:showCategoryName(b.categoryId)}</td>
            <td nowrap="nowrap">
                <img src="${pageContext.request.contextPath}/images${b.path}/${b.photoFileName}"/>
            </td>
            <td nowrap="nowrap">
                <a href="javascript:alert('略')">修改</a>
                <a href="javascript:alert('略')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="/commons/page.jsp"%>
</div>
</body>
</html>
