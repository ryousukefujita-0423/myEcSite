<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserList</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<s:if test="msg == 1">
			<h3>ユーザー情報はありません。</h3>
		</s:if>
		<s:elseif test="userList != null">
			<h3>ユーザー情報は以下になります。</h3>
			<table id="table_color" border="1">
				<tr>
					<th>ログインID</th>
					<th>ログインPASS</th>
					<th>ユーザー名</th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="login_id" /></td>
						<td><s:property value="login_pass" /></td>
						<td><s:property value="user_name" /></td>
					</tr>
				</s:iterator>
			</table>
			<br>
			<s:form action="UserListDeleteConfirmAction">
				<s:submit value="削除"></s:submit>
			</s:form>
		</s:elseif>
		<br>
		<div>
			管理者画面に戻る場合は<a href="http://localhost:8080/ecsite/admin.jsp" />こちら</a>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which provides A to Z about programing.</div>
</body>
</html>