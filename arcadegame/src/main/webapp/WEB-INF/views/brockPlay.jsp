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
<link rel="stylesheet" href="css/game.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body onload="main()">
	<canvas id="sample" width="1355" height="630"></canvas>
	<div id="box">
		<p class="msg-white">アイテム：</p>
		<p class="msg-white item-name1">ライフアップ</p>
		<div class="boxs box1">z</div>
		<p class="msg-white item-name2">スコアアップ</p>
		<div class="boxs box2">x</div>
		<p class="msg-white item-name3">球速度アップ</p>
		<div class="boxs box3">c</div>
	</div>

	<form:form action="Result" modelAttribute="test" name="sampleform"
		cssStyle="visibility: hidden; float: left;">
		<form:input path="score" value="" />
		<button onclick="sample2()">送信</button>
	</form:form>

	<script src="main.js"></script>
</body>
</html>