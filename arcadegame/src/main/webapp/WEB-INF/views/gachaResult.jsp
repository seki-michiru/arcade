<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>アーケードゲーム</title>
<link rel="stylesheet" href="css/all.css">
</head>
<body>
	<a href="menu"><img src="images/homeicon.png" alt=""
		class="home-icon"></a>

	<h1 id="sub-title">ガチャ</h1>

	<p class="confirm-msg">アイテム1を獲得しました。</p>
	<p class="confirm-msg">コイン：100枚 → 70枚</p>

	<div id="form-btn-center">
		<a href="gacha"><button class="form-btn"
				style="width: 200px;">ガチャに戻る</button></a>
	</div>

</body>
</html>