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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>BuyItemConfirm画面</title>
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
			<p>BuyItemConfirm</p>
		</div>
		<h2>下記の商品でよろしいでしょうか。</h2>
		<div>
			<s:form theme="simple" >
				<table id="table_color" border="1">
					<tr id="table_midashi">
						<td>商品名</td>
						<td>値段</td>
						<td>購入数</td>
					</tr>
					<s:iterator value="buyItemDTOList">
						<tr>
							<td><s:property value="ItemName" /></td>

							<td><s:property value="ItemPrice" /><span>円</span></td>

							<td><s:property value="TotalCount" /><span>個</span></td>
						</tr>
						<div id="checkbox_hidden">
							<s:checkbox name="checkList" value="true" fieldValue="%{id}" />
						</div>
					</s:iterator>
				</table>
				<br>
				<div>
					合計金額：
					<s:property value="total_Count" />
					<span>円</span>
				</div>
				<br>
				<div>
					支払い方法：
					<s:property value="session.pay" />
				</div>
				<br>
				<div>
					<input type="button" value="前の画面に戻る"
						onclick="submitAction('MyCartAction')" /> <input type="button"
						value="購入する" onclick="submitAction('BuyItemConfirmAction')" />
				</div>
			</s:form>
		</div>
	</div>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>
