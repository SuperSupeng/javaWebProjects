<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<br/>
<c:if test="${empty sessionScope.cart.items}">
    <h2>对不起！您还没有购买任何商品</h2>
</c:if>
<c:if test="${!empty sessionScope.cart.items}">
    <table border="1" width="438">
        <tr>
            <th>选择</th>
            <th>商品名称</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs">
            <tr class="${vs.index%2==0?'odd':'even' }">
                <td>
                    <input type="checkbox" name="bookIds" value="${me.key}"/>
                </td>
                <td>${me.value.book.name}</td>
                <td>${me.value.book.price}</td>
                <td>
                    <input type="text" size="3" id="quantity" name="quantity" value="${me.value.quantity}" onchange="changeNum(this,'${me.key}',${me.value.quantity})"/>
                </td>
                <td>${me.value.totalPrice}</td>
                <td>
                    <a href="javascript:delOneItem('${me.key}')">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6">
                共${sessionScope.cart.totalQuantity}件商品,付款金额：${sessionScope.cart.amount}
                <a href="">去收银台</a>
            </td>
        </tr>
    </table>
    <script type="text/javascript">
        function changeNum(inputObj,bookId,oldNum){
            //验证用户的输入
            var num = inputObj.value;

            if(!/^[1-9][0-9]*$/.test(num)){
                alert("请输入正确的数量");
                return;
            }


            var sure = window.confirm("确定要修改数量吗?");
            if(sure){
                window.location.href="${pageContext.request.contextPath}/ClientServlet?op=changeNum&bookId="+bookId+"&num="+num;
            }else{
                //把input的值改为原来的
                inputObj.value=oldNum;
            }
        }
        function delOneItem(bookId){
            var sure = window.confirm("确定要删除该项吗?");
            if(sure){
                window.location.href="${pageContext.request.contextPath}/ClientServlet?op=delOneItem&bookId="+bookId;
            }
        }
    </script>
</c:if>
</body>
</html>
