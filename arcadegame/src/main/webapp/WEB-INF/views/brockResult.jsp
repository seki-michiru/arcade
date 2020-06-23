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

    <a href="menu"><img src="images/homeicon.png" alt=""class="home-icon"></a>
    <div id="form-btn-center" class="flex-contents">
        <div><p class="result-score inline">スコア</p><p class="score inline">${score}点</p></div><br>
        <div><p class="result-score inline">獲得コイン</p><p class="coin inline">${coin}枚</p></div>
    </div>

<div id="form-btn-center"><a href="brockStart"><button class="form-btn" style="width: 200px;">もう一度遊ぶ</button></a></div>
<div id="form-btn-center"><a href="menu"><button class="form-btn" style="width: 200px;">メニューに戻る</button></a></div>

</body>
</html>