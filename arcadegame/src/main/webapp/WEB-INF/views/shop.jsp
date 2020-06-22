<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

    <a href="menu.html"><img src="images/homeicon.png" alt=""class="home-icon"></a>

    <h1 id="sub-title">ショップ</h1>

    <h3 id="mycoin">所持コイン：100枚</h3>

    <h2><a href="buy" id="menu-btn">購入</a></h2>
    <h2><a href="sell" id="menu-btn">売却</a></h2>
    <h2><a href="tradeMenu.html" id="menu-btn">トレード</a></h2>
    <h2><a href="gacha.html" id="menu-btn">ガチャ</a></h2>

</body>
</html>