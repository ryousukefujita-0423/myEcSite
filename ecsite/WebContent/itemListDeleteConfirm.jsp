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
<title>ItemListDeleteConfirm</title>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>ItemListDeleteConfirm</p>
		</div>
		<h2>下記の商品を削除します。よろしいですか。</h2>
		<s:form theme="simple">
			<table>
				<tr id="table_midashi">
					<th>商品名</th>
					<th>値段</th>
					<th>在庫数</th>
				</tr>
				<s:iterator value="List">
					<tr>
						<td><s:property value="item_name" /></td>
						<td><s:property value="item_price" /><span>円</span></td>
						<td><s:property value="item_stock" /><span>個</span></td>
					</tr>
					<div id="checkbox_hidden">
						<s:checkbox name="checkList" value="true" fieldValue="%{id}" />
					</div>
				</s:iterator>
			</table>
			<br>
			<div>
				<input type="button"
					onclick="location.href='http://localhost:8080/ecsite/admin.jsp'"
					value="キャンセル">
				<s:form action="ItemListDeleteCompleteAction">
					<s:submit value="ＯＫ" />
				</s:form>
			</div>
		</s:form>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>