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
<title>UserListDeleteConfirm</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>UserListDeleteConfirm</p>
		</div>
		<h2>全てのユーザーを削除します。よろしいですか。</h2>
		<table>
			<tr>
				<td><input type="button"
					onclick="location.href='http://localhost:8080/ecsite/admin.jsp'"
					value="キャンセル"></td>
				<td><s:form action="UserListDeleteCompleteAction">
						<s:submit value="ＯＫ" />
					</s:form></td>
			</tr>
		</table>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which provides A to Z about programing.</div>
</body>
</html>