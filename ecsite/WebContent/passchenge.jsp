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
<title>PassChenge画面</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>PassChenge</p>
		</div>
		<div>
			<s:if test="errormsg !=''">
				<s:property value="errormsg" escape="false" />
			</s:if>
		</div>
		<div>
			<s:form action="PassChegeCompleteAction">
				<s:password name="oldpass" label="現パスワード" />
				<s:password name="newpass" label="新パスワード" />
				<s:password name="newkakuninpass" label="新パスワード(確認)" />
				<s:submit value="変更" />
			</s:form>
		</div>
		<br>
		<div>
			マイページへ戻る場合は<a href='<s:url action="MyPageAction" />'>こちら</a>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>