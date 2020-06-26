    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="date" class="java.util.Date"/>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>インベーダーゲームランキング</title>
    <link rel="stylesheet" href="css/all.css">
    <link rel="icon" href="images/invader1.png">

</head>
<body>

    <a href="ranking"><img src="images/returnbtn.png" alt="" class="returnbtn"></a>
    <a href="menu"><img src="images/homeicon.png" alt="" class="home-icon"></a>

    <h2 id="sub-title">インベーダーゲーム</h2>
	<c:if test="${not empty msg }">
		<p class="confirm-msg">${msg }</p>
	</c:if>
	<c:if test="${empty msg }">
		<c:if test="${not empty myRank.get(0).getRank()}">
			<div id="rank-msg-div">
				<p class="rank-msg">あなたのランキング</p>
				<c:if test="${myRank.get(0).getRank() == 1 }"><p class="rank-msg" style="color: yellow; font-size: 30px;">👑</p></c:if><p class="rank-msg">${myRank.get(0).getRank()}位</p>
				<p class="rank-msg">スコア：${myRank.get(0).getHighScore()}</p>
			</div>
		</c:if>
		<table border="1">
			<caption>BEST3</caption>
			<tr>
				<th>順位</th>
				<th>ユーザー名</th>
				<th>スコア</th>
				<th>日付</th>
				<th>遊んだ回数</th>
			</tr>


			<c:if test="${not empty date1  }">
				<tr>
					<td>${rankingInvader.get(0).getRank()}</td>
					<td>${rankingInvader.get(0).getUserName()}</td>
					<td>${rankingInvader.get(0).getHighScore()}</td>
					<td><fmt:formatDate value="${date1}" pattern="yyyy/MM/dd" /></td>
					<td>${rankingInvader.get(0).getPlayNum()}</td>
				</tr>
			</c:if>

			<c:if test="${not empty date2 }">
				<tr>
					<td>${rankingInvader.get(1).getRank()}</td>
					<td>${rankingInvader.get(1).getUserName()}</td>
					<td>${rankingInvader.get(1).getHighScore()}</td>
					<td><fmt:formatDate value="${date2}" pattern="yyyy/MM/dd" /></td>
					<td>${rankingInvader.get(1).getPlayNum()}</td>
				</tr>
			</c:if>
			<c:if test="${not empty date3 }">
				<tr>
					<td>${rankingInvader.get(2).getRank()}</td>
					<td>${rankingInvader.get(2).getUserName()}</td>
					<td>${rankingInvader.get(2).getHighScore()}</td>
					<td><fmt:formatDate value="${date3}" pattern="yyyy/MM/dd" /></td>
					<td>${rankingInvader.get(2).getPlayNum()}</td>
				</tr>
			</c:if>
		</table>
	</c:if>


</body>
</html>