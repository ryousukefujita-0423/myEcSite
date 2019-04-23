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
<title>Menu</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>Menu</p>
		</div>
		<div>
			<h3>検索</h3>
			<s:form action="SearchAction" theme="simple" border="1">
				<s:textfield name="search" />
				<s:submit value="検索" />
			</s:form>
		</div>
		<br>
		<div>
			<h3>ジャンル</h3>
			<table id="item_type">
				<tr>
					<td><a
						href='<s:url action="MenuAction"><s:param name="item_type" value="1" /></s:url>'>文房具</a></td>
					<td><a
						href='<s:url action="MenuAction"><s:param name="item_type" value="2" /></s:url>'>書籍</a></td>
				</tr>
				<tr>
					<td><a
						href='<s:url action="MenuAction"><s:param name="item_type" value="3" /></s:url>'>電化製品</a></td>
					<td><a
						href='<s:url action="MenuAction"><s:param name="item_type" value="4" /></s:url>'>食品</a></td>
				</tr>
				<tr>
					<td><a
						href='<s:url action="MenuAction"><s:param name="item_type" value="5" /></s:url>'>家具</a></td>
					<td><a
						href='<s:url action="MenuAction"><s:param name="item_type" value="6" /></s:url>'>日用雑貨</a></td>
				</tr>
			</table>
		</div>
		<p>
			マイページは <a href='<s:url action="MyPageAction" />'>こちら</a>
		</p>
		<p>
			カートは <a href='<s:url action="MyCartAction" />'>こちら</a>
		</p>
		<br>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>