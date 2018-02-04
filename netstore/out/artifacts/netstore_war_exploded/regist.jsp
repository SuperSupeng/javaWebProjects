<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<br/>
<form action="${pageContext.request.contextPath}/ClientServlet?op=registCustomer" method="post">
    <table border="1" width="438">
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="username" />
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>电话：</td>
            <td>
                <input type="text" name="phone"/>
            </td>
        </tr>
        <tr>
            <td>地址：</td>
            <td>
                <input type="text" name="address"/>
            </td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td>
                <input type="text" name="email"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
