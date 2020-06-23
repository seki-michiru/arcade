<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>アーケードゲーム</title>
<link rel="stylesheet" href="css/all.css">
<link rel="icon" href="images/invader1.png">
</head>
<body>
	<a href="menu"><img src="images/homeicon.png" alt=""
		class="home-icon"></a>
	<h1 id="sub-title">出品</h1>

	<a href="tradeMenu"><img src="images/returnbtn.png" alt=""
		class="returnbtn"></a>


	<c:choose>
		<c:when test="${empty userStockItem}">
			<p>アイテムを持っていません</p>
		</c:when>
		<c:otherwise>
			<form:form action="saleResult" modelAttribute="SaleForm">
				<table>
					<tr>
						<th></th>
						<th>ゲーム名</th>
						<th>出品アイテム</th>
						<th>ほしいアイテム選択</th>
					</tr>
					<c:forEach var="userItem" items="${userStockItem}">
						<tr>
							<td><form:checkbox value="${userItem.itemId}" path="takeId"
									style="width: 20px; height: 20px;" /></td>
							<td>${userItem.gameName}</td>
							<td>${userItem.itemName}</td>

							<td><form:select path="giveId" class="form-select"
									multiple="false">
									<form:option value="0">何欲しい？</form:option>
									<c:forEach var="item" items="${itemlist}">
										<form:option value="${item.itemId}" label="${item.itemName}" />
									</c:forEach>
								</form:select></td>

						</tr>
					</c:forEach>

				</table>

				<div id="form-btn-center">
					<button class="form-btn" style="width: 200px;">トレードに出す</button>
				</div>
			</form:form>
		</c:otherwise>
	</c:choose>
</body>
</html>