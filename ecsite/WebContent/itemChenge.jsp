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
<title>ItemChenge</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>ItemChenge</p>
		</div>
		<h2>変更したい商品名と個数を入力してください。</h2>
		<s:form action="ItemChengeConfirmAction" theme="simple">
			<table>
				<tr>
					<td>商品名</td>
					<td><s:textfield name="item_name" /></td>
				</tr>
				<tr>
					<td>商品変更数</td>
					<td><s:textfield name="item_stock" /></td>
				</tr>
			</table>
			<br>
			<div>
				<s:submit value="変更" />
			</div>
		</s:form>
		<br>
		<h2>商品リスト一覧</h2>
		<table border="1" id="table_color">
			<tr id="table_midashi">
				<td>商品名</td>

				<td>値段</td>

				<td>在庫個数</td>
			</tr>
			<s:iterator value="buyItemDTOList">
				<tr>
					<td><s:property value="ItemName" /></td>

					<td><s:property value="ItemPrice" /><span>円</span></td>

					<td><s:property value="ItemStock" /><span>個</span></td>
				</tr>
			</s:iterator>
		</table>
		<br>
		<div>
			管理者画面に戻る場合は<a href="http://localhost:8080/ecsite/admin.jsp" />こちら</a>
		</div>
	</div>
	<br>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>