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
</head>
<body>
	<a href="menu"><img src="images/homeicon.png" alt=""
		class="home-icon"></a>
	<a href="shop"><img src="images/returnbtn.png" alt=""
		class="returnbtn"></a>

	<h1 id="sub-title">ガチャ</h1>
	<h3 id="mycoin">所持コイン:${coin}枚</h3>

	<p class = "confirm-msg">${fn:escapeXml(msg)}</p>

	<h2 id="menu-btn">1回30枚</h2>

	<div id="form-btn-center">
		<a href="gachaPlay"><button class="form-btn">まわす</button></a>
	</div>

</body>
</html>

