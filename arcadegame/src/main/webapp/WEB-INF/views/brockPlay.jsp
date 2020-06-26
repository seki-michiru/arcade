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
<link rel="stylesheet" href="css/game.css">
<link rel="icon" href="images/invader1.png">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<canvas id="myCanvas" width="1350" height="610"></canvas>
    <div id="box">
        <p class="msg-white">アイテム：</p>
        <c:if test="${empty one.itemName && empty tow.itemName && empty three.itemName}"><p class="msg-white item-name1">アイテムなし</p></c:if>
        <p id="itemName1" class="msg-white item-name1">${one.itemName}</p><c:if test="${not empty one.itemName}"><div class="boxs box1">z</div></c:if>
        <p id="itemName2" class="msg-white item-name2">${tow.itemName}</p><c:if test="${not empty tow.itemName}"><div class="boxs box2">x</div></c:if>
        <p id="itemName3" class="msg-white item-name3">${three.itemName}</p><c:if test="${not empty three.itemName}"><div class="boxs box3">c</div></c:if>
    </div>

    <p id="item1-effect" style="display: none;">${one.itemEffects }</p>
    <p id="item2-effect" style="display: none;">${tow.itemEffects }</p>
    <p id="item3-effect" style="display: none;">${three.itemEffects }</p>

	<form:form action="Result" modelAttribute="test" name="sampleform"
		cssStyle="visibility: hidden; float: left;">
		<form:input path="score" value="" />
		<button onclick="sample2()">送信</button>
	</form:form>

	<script src="main.js"></script>
</body>
</html>