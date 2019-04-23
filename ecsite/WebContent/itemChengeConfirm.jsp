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
<title>ItemChengeConfirm</title>
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
			<p>ItemChengeConfirm</p>
		</div>
		<h2>変更内容は以下でよろしいでしょうか。</h2>
		<s:form>
			<table id="table_color">
				<tr>
					<td>商品名</td>
					<td><s:property value="session.item_name" /></td>
				</tr>
				<tr>
					<td>変更数</td>
					<td><s:property value="session.item_stock" /></td>
				</tr>
			</table>
			<br>
			<div>
				<input type="button" value="修正"
					onclick="submitAction('ItemChengeAction')" /> <input type="button"
					value="変更" onclick="submitAction('ItemChengeConpleteAction')" />
			</div>
		</s:form>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>