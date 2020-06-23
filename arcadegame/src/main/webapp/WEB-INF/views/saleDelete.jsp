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
	<h1 id="sub-title">出品を削除</h1>

	<a href="tradeMenu"><img src="images/returnbtn.png" alt=""
		class="returnbtn"></a>

	<c:choose>
		<c:when test="${empty marketItem}">
			<p>出品しているアイテムはありません</p>
		</c:when>
		<c:otherwise>



			<form:form action="saleDeleteResult" modelAttribute="SaleDeleteForm">
				<table>
					<tr>
						<th></th>
						<th>ゲーム名</th>
						<th>出品アイテム</th>
						<th>ほしいアイテム</th>
					</tr>

					<c:forEach var="market" items="${marketItem}">
						<tr>
							<td><form:checkbox value="${market.saleId}" path="delete"
									style="width: 20px; height: 20px;" /></td>


							<td>${market.gameName}</td>
							<td>${market.takeName}</td>
							<td>${market.giveName}</td>
						</tr>

					</c:forEach>

				</table>

				<div id="form-btn-center">
					<button class="form-btn" style="width: 200px;">削除</button>
				</div>
			</form:form>
		</c:otherwise>
	</c:choose>
</body>
</html>