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
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>MyCart</title>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}

	function checkValue(check, name) {
		var frm = check.form;
		if (check.checked == true) {
			for (var i = 1; i <= 2; i++) {
				frm.elements[name + i].disabled = false;
			}
		} else {
			for (var i = 1; i <= 2; i++) {
				frm.elements[name + i].disabled = true;
			}
		}
	}
</script>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>MyCart</p>
		</div>
		<s:if test="buyItemDTOList.size() == 0">
			<h2>カートに商品はありません。</h2>
		</s:if>
		<s:else>
			<h2>カート一覧</h2>
			<s:form action="BuyItemAction" theme="simple">
				<table id="table_color" border="1">
					<tr id="table_midashi">
						<td>商品名</td>

						<td>値段</td>

						<td>購入数</td>

						<td>商品チェック</td>
					</tr>
					<s:iterator value="buyItemDTOList">
						<tr>
							<td><s:property value="ItemName" /></td>

							<td><s:property value="ItemPrice" /><span>円</span></td>

							<td><s:property value="TotalCount" /><span>個</span></td>

							<td><s:checkbox name="checkList" fieldValue="%{id}"
									onclick="checkValue(this,'c')" /></td>
						</tr>
					</s:iterator>
				</table>
				<br>
				<table>
					<tr>
						<td><span>支払い方法：</span> <input type="radio" name="pay"
							value="1" checked="checked">現金払い <input type="radio"
							name="pay" value="2">クレジットカード</td>
					</tr>
				</table>
				<br>
				<div>
					<input id="btn" type="button" name="c1" disabled="disabled"
						value="チェックした商品を削除する" onclick="submitAction('ItemDeleteAction')" />
					<input id="btn" type="button" name="c2" disabled="disabled"
						value="チェックした商品を購入する" onclick="submitAction('BuyItemAction')" />
				</div>
			</s:form>
		</s:else>
		<br>
		<div>
			<p>
				マイページは <a href='<s:url action="MyPageAction" />'>こちら</a>
			</p>
			<p>
				商品購入ページは <a href='<s:url action="HomeAction" />'>こちら</a>
			</p>
		</div>
	</div>
	<br>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>