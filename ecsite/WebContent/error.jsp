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
<title>Error画面</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>Error</p>
		</div>
		<div>
			<h2>
				<s:property value="errormsg" />
			</h2>
		</div>
		<s:if test="errormsg == '商品にチェックが入っていません。'">
			<p>
				カート画面へ <a href='<s:url action="MyCartAction" />'>戻る</a>
			</p>
		</s:if>
		<s:if test="errormsg == '商品に在庫が無いため購入できません。'">
			<p>
				商品購入ページへ <a href='<s:url action="HomeAction" />'>戻る</a>
			</p>
		</s:if>
		<s:if test="errormsg == '購入希望数が在庫数を超えているため購入できません。'">
			<p>
				商品購入ページへ <a href='<s:url action="HomeAction" />'>戻る</a>
			</p>
		</s:if>
		<s:if test="errormsg == 'すでにカートに商品が存在しています。'">
			<p>
				商品購入ページへ <a href='<s:url action="HomeAction" />'>戻る</a>
			</p>
		</s:if>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>