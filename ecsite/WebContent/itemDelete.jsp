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
<title>ItemDelete</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>ItemDelete</p>
		</div>
		<h2>カートの商品を削除しました。</h2>
		<br>
		<p>
			マイページは <a href='<s:url action="MyPageAction" />'>こちら</a>
		</p>
		<p>
			カートは <a href='<s:url action="MyCartAction" />'>こちら</a>
		</p>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which provides A to Z about programing.</div>
</body>
</html>