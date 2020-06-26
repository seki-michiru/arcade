<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1 id="user-name">${sessionScope.userName}さん、こんにちは</h1>

	<h1 id="sub-title">メニュー</h1>
	<a href="logout"><button type = "button" class="form-btn home-icon">ログアウト</button></a>

	<h2>
		<a href="game" id="menu-btn">ゲーム選択</a>
	</h2>
	<h2>
		<a href="ranking" id="menu-btn">ランキング</a>
	</h2>
	<h2>
		<a href="shop" id="menu-btn">ショップ</a>
	</h2>
	<h2>
		<a href="item" id="menu-btn">所持アイテム一覧</a>
	</h2>
	<h2>
		<a href="userInfo" id="menu-btn">ユーザー情報</a>
	</h2>
	<!-- <h2><a href="logout.jsp" id="menu-btn">ログアウト</a></h2> -->
</body>
</html>