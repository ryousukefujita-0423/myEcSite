<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
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
<title>ItemList</title>
<script type="text/javascript">
	function submitAction(url) {
		$('form').attr('action', url);
		$('form').submit();
	}

	function checkValue(check, name) {
		var frm = check.form;
		if (check.checked == true) {
			for (var i = 1; i <= 1; i++) {
				frm.elements[name + i].disabled = false;
			}
		} else {
			for (var i = 1; i <= 1; i++) {
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
			<p>ItemList</p>
		</div>
		<s:if test="msg == 1">
			<h3>商品情報はありません。</h3>
		</s:if>
		<s:elseif test="itemList != null">
			<s:form value="ItemListDeleteConfirmAction" theme="simple">
				<h3>商品情報は以下になります。</h3>
				<table id="table_color" border="1">
					<tr id="table_midashi">
						<th>商品名</th>
						<th>値段</th>
						<th>在庫数</th>
						<th>チェック</th>
					</tr>
					<s:iterator value="itemList">
						<tr>
							<td><s:property value="item_name" /></td>
							<td><s:property value="item_price" /><span>円</span></td>
							<td><s:property value="item_stock" /><span>個</span></td>
							<td><s:checkbox name="checkList" fieldValue="%{id}"
									onclick="checkValue(this,'c')" /></td>
						</tr>
					</s:iterator>
				</table>
				<br>
				<div>
					<input id="btn" type="button" name="c1" disabled="disabled"
						value="チェックした商品を削除する"
						onclick="submitAction('ItemListDeleteConfirmAction')" />
				</div>
			</s:form>
		</s:elseif>
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