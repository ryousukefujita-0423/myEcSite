<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Login画面</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>
		<div>
			<s:if test="errormsg !=''">
				<s:property value="errormsg" escape="false" />
			</s:if>
			<h3>商品を購入する際にはログインをお願いします。</h3>
			<s:form action="LoginAction">
				<s:textfield name="loginUserId" label="ログインID" />
				<s:password name="loginPassword" label="パスワード" />
				<s:submit value="ログイン" />
			</s:form>
			<br>
			<div id="text-link">
				<p>
					新規ユーザ登録は <a href='<s:url action="UserCreateAction" />'>こちら</a>
				</p>
				<p>
					Homeへ戻る場合は <a href='<s:url action="GoHomeAction" />'>こちら</a>
				</p>
			</div>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which provides A to Z about programing.</div>
</body>
</html>
