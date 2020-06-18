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

	<form:form action="top" modelAttribute="top">
		<h1 id="game-title">アーケードゲーム</h1>
		<a href="login" id="menu-btn">ログイン</a>
		<a href="regist" id="menu-btn">新規登録</a>
	</form:form>
</body>
</html>