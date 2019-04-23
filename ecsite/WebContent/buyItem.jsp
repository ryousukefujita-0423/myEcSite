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
<title>BuyItem画面</title>
<script type="text/javascript">
	function submitForm(id) {
		var idElem = document.getElementById(id);

		var nameVal = idElem.getElementsByClassName("ItemName_td")[0].innerHTML;
		var priceVal = idElem.getElementsByClassName("ItemStock_td")[0].innerHTML;
		var stockVal = idElem.getElementsByClassName("ItemPrice_td")[0].innerHTML;

		document.getElementById("id_to_submit").value = id;
		document.getElementById("name_to_submit").value = nameVal;
		document.getElementById("price_to_submit").value = priceVal;
		document.getElementById("stock_to_submit").value = stockVal;

		$('form').submit();
	}
</script>
</head>
<body>
	<div id="header">ecsite</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<s:if test="buyItemDTOList.size() <= 0">
			<h2>
				<s:property value="errorMsg" />
			</h2>
		</s:if>
		<s:else>
			<div>
				<s:form action="ItemKakuninAction" theme="simple">
					<s:hidden name="id" id='id_to_submit' />
					<s:hidden name="name" id='name_to_submit' />
					<s:hidden name="price" id='price_to_submit' />
					<s:hidden name="stock" id='stock_to_submit' />
					<table id="table_color" border="1">
						<tr id="table_midashi">
							<td>商品名</td>

							<td>値段</td>

							<td>在庫個数</td>

							<td>商品詳細</td>
						</tr>
						<s:iterator value="buyItemDTOList">
							<tr id="<s:property value="id" />">
								<td class='ItemName_td'><s:property value="ItemName" /></td>

								<td class='ItemPrice_td'><s:property value="ItemPrice" /><span>円</span></td>

								<s:if test="ItemStock <= 0">
									<td id="sold_color">sold out</td>
								</s:if>
								<s:else>
									<td class='ItemStock_td'><s:property value="ItemStock" /><span>個</span></td>
								</s:else>

								<td><input type="button" value="商品詳細へ"
									onclick="submitForm('<s:property value="id" />')"></td>
							</tr>
						</s:iterator>
					</table>
				</s:form>
			</div>
		</s:else>
		<br>
		<div>
			<p>
				メニューに戻る場合は <a href='<s:url action="HomeAction" />'>こちら</a>
			</p>
			<p>
				マイページは <a href='<s:url action="MyPageAction" />'>こちら</a>
			</p>
			<p>
				カートは <a href='<s:url action="MyCartAction" />'>こちら</a>
			</p>
		</div>
	</div>
	<br>
	<div id="footer">copyright fujita | ecsite is the one which
		provides A to Z about programing.</div>
</body>
</html>
