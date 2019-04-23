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
<title>BuyItemComplete画面</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>BuyItemComplete</p>
		</div>
		<div>
			<h2>購入手続きが完了致しました。</h2>
			<div>
				<a href='<s:url action="MyPageAction" />'>マイページ</a><span>から購入履歴の確認が可能です。</span>
				<p>
					Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
				</p>
			</div>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>
