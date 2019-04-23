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
<title>ItemKakunin</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>ItemKakunin</p>
		</div>
		<s:form action="BuyItemCartAction">
			<table id="table_color" id="color">
				<tr>
					<td>商品名</td>
					<td><s:property value="session.item_name" /></td>
				</tr>
				<tr>
					<td>商品価格</td>
					<td><s:property value="session.item_price" /><span>円</span></td>
				</tr>
				<tr>
					<td>在庫数</td>
					<td><s:property value="session.item_stock" /><span>個</span></td>
				</tr>
				<tr>
					<td>購入数</td>
					<td><select name="count">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
					</select></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<s:submit value="カートへ入れる"></s:submit>
				</tr>
			</table>
		</s:form>
		<br>
		<div>
			<p>
				メニューに戻る場合は <a href='<s:url action="HomeAction" />'>こちら</a>
			</p>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>