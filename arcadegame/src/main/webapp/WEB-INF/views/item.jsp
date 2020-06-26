
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Arcade Game</title>
<link rel="stylesheet" href="css/all.css">
<link rel="icon" href="images/invader1.png">

</head>
<body>


	<a href="menu"><img src="images/homeicon.png" alt=""
		class="home-icon"></a>

	<h1 id="sub-title">所持アイテム</h1>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>
	<c:if test="${empty msg}">
		<table>
			<tr>
				<th>ゲーム名</th>
				<th>アイテム名</th>
				<th>所持数</th>
				<th>説明</th>
			</tr>
			<c:forEach var="Item" items="${allItem}">
				<tr>
					<td><c:out value="${Item.gameName}" /></td>
					<td><c:out value="${Item.itemName}" /></td>
					<td><c:out value="${Item.itemHave}" /></td>
					<td><c:out value="${Item.itemExplan}" /></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>