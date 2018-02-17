<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
	<meta http-equiv="Content-Language" content="zh-cn">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
	<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
	<!-- 日期插件，使用jquery -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.4.2.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/jquery/jquery.datepick.css" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery.datepick-zh-CN.js"></script>
</HEAD>
<script type="text/javascript">
    $(document).ready(function(){
        //使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
        $('#birthday').datepick({dateFormat: 'yy-mm-dd'});
    });
</script>
<body>
<s:form id="userAction_save_do" name="Form1" action="editUser" namespace="/user" enctype="multipart/form-data">
	<s:hidden name="userID"></s:hidden>
	&nbsp;
	<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26">
				<strong><STRONG>查看用户</STRONG>
				</strong>
			</td>
		</tr>

		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				登录名：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<s:property value="logonName"/>
			</td>

			</td>
			<td align="center" bgColor="#f5fafe" class="ta_01">
				用户姓名：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<s:property value="userName"/>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">
				性别：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<s:property value="sex=='male'?'男':'女'"/>
			</td>
			<td align="center" bgColor="#f5fafe" class="ta_01">
				学历：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<s:property value="education"/>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">
				出生日期：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<s:property value="birthday"/>
			</td>
			<td align="center" bgColor="#f5fafe" class="ta_01">
				电话：
			</td>
			<td class="ta_01" bgColor="#ffffff">
				<s:property value="telephone"/>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">
				兴趣爱好：
			</td>
			<td class="ta_01" bgColor="#ffffff" colSpan="3">
				<s:property value="interest"/>
			</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">
				简历资料：
			</td>
			<td class="ta_01" bgColor="#ffffff" colSpan="3">
				<a href="javascript:void(0)" onclick="openWindow('${pageContext.request.contextPath}/user/download?userID=<s:property value="userID"/>','700','400')" class="cl_01">
					下载
				</a>
			</td>
		</tr>
		<TR>
			<TD class="ta_01" align="center" bgColor="#f5fafe">
				备注：
			</TD>
			<TD class="ta_01" bgColor="#ffffff" colSpan="3">
				<s:property value="remark"/>
			</TD>
		</TR>
		<TR>
			<td align="center" colSpan="4" class="sep1">
				<img src="${pageContext.request.contextPath}/images/shim.gif">
			</td>
		</TR>


		<tr>
			<td class="ta_01" style="WIDTH: 100%" align="center"
				bgColor="#f5fafe" colSpan="4">
				<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
				<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
				<span id="Label1"></span>
			</td>
		</tr>
	</table>
</s:form>
</body>
</HTML>