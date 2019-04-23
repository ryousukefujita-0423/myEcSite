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
<title>ItemCreate画面</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>ItemCreate</p>
		</div>
		<s:if test="errormsg !=''">
			<s:property value="errormsg" />
		</s:if>
		<s:form action="ItemCreateConfirmAction" theme="simple">
			<table>
				<tr>
					<td>商品名</td>
					<td><s:textfield name="item_name" /></td>
				</tr>
				<tr>
					<td>商品価格</td>
					<td><s:textfield name="item_price" /></td>
				</tr>
				<tr>
					<td>商品在庫数</td>
					<td><s:textfield name="item_stock" /></td>
				</tr>
				<tr>
					<td>商品種類</td>
					<td><select name="item_type">
							<option>商品の種類を選択してください</option>
							<option value="1">文房具</option>
							<option value="2">書籍</option>
							<option value="3">電化製品</option>
							<option value="4">食品</option>
							<option value="5">家具</option>
							<option value="6">日用雑貨</option>
					</select></td>
				</tr>
			</table>
			<br>
			<s:submit value="登録" />
		</s:form>
		<br>
		<div>
			管理者画面に戻る場合は<a href="http://localhost:8080/ecsite/admin.jsp" />こちら</a>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>