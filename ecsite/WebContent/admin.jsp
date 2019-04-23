<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>管理者画面</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div id="left">
			<h3>商品</h3>
			<s:form action="ItemCreateAction">
				<s:submit value="新規登録" />
			</s:form>
			<br>
			<s:form action="ItemListAction">
				<s:submit value="一覧" />
			</s:form>
			<br>
			<s:form action="ItemChengeAction">
				<s:submit value="在庫数変更" />
			</s:form>
			<br>
		</div>
		<div id="right">
			<h3>ユーザー</h3>
			<s:form action="UserCreateAction">
				<s:submit value="新規登録" />
			</s:form>
			<br>
			<s:form action="UserListAction">
				<s:submit value="一覧" />
			</s:form>
			<br>
		</div>
		<div id="kanri">
			<p>
				ログアウトをする場合は<a href='<s:url action="LogoutAction" />'>こちら</a>
			</p>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>