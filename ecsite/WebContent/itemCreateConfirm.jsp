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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemCreateConfirm画面</title>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}
</script>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>ItemCreateConfirm</p>
		</div>
		<h2>以下の内容でよろしいでしょうか</h2>
		<s:form>
			<table>
				<tr>
					<td>商品名</td>
					<td><s:property value="session.new_item_name" /></td>
				</tr>
				<tr>
					<td>商品価格</td>
					<td><s:property value="session.new_item_price" /> <span>円</span>
					</td>
				</tr>
				<tr>
					<td>商品在庫数</td>
					<td><s:property value="session.new_item_stock" /><span>個</span>
					</td>
				</tr>
				<tr>
					<td>商品種類</td>
					<td><s:if test="session.new_item_type == 1">
				文房具
				</s:if> <s:elseif test="session.new_item_type == 2">
				書籍
				</s:elseif> <s:elseif test="session.new_item_type == 3">
				電化製品
				</s:elseif> <s:elseif test="session.new_item_type == 4">
				食品
				</s:elseif> <s:elseif test="session.new_item_type == 5">
				家具
				</s:elseif> <s:elseif test="session.new_item_type == 6">
				日用雑貨
				</s:elseif></td>
				</tr>
			</table>
			<br>
			<div>
				<input type="button" value="修正"
					onclick="submitAction('ItemCreateAction')" /> <input type="button"
					value="完了" onclick="submitAction('ItemCreateCompleteAction')" />
			</div>
		</s:form>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>