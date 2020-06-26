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
<title>Arcade Game</title>
<link rel="stylesheet" href="css/all.css">
<link rel="icon" href="images/invader1.png">
</head>
<body>
	<a href="menu"><img src="images/homeicon.png" alt=""
		class="home-icon"></a>

	<h1 id="sub-title">ガチャ</h1>

	<p class="confirm-msg">${sessionScope.getItem.get(0).itemName}を獲得しました。</p>
	<p class="confirm-msg">コイン残高：${coin}枚</p>

	<div id="form-btn-center">
		<a href="gacha"><button class="form-btn"
				style="width: 200px;">ガチャに戻る</button></a>
	</div>

</body>
</html>