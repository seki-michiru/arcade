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
    <a href="menu"><img src="images/homeicon.png" alt=""class="home-icon"></a>

    <h1 id="sub-title">ゲーム選択</h1>

    <h2><a href="invaderStart" id="menu-btn">インベーダーゲーム</a></h2>
    <h2><a href="brockStart" id="menu-btn">ブロック崩し</a></h2>

</body>
</html>