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
<link rel="icon" href="images/invader1.png">
</head>
<body>
	<h2 id="sub-title">新規登録</h2>
	<a href="registConfirm"><img src="images/returnbtn.png" alt=""
		class="returnbtn"></a>
	<p class="confirm-msg">登録しました</p>

	<form:form action="regist3" modelAttribute="regist">
		<div id="form-btn-center">
			<div id="form-div">
				<div>
					<p class="form-item inline">ID</p>
					<p class="text-design-id inline">${sessionScope.loginId}</p>
				</div>
				<br>
				<div>
					<p class="form-item inline">名前</p>
					<p class="text-design-name inline">${sessionScope.userName}</p>
				</div>
				<br>
				<div>
					<p class="form-item inline">PASS</p>
					<p class="text-design-pass inline">${sessionScope.password}</p>
				</div>
			</div>
		</div>
		<div id="form-btn-center">
			<a href="login"><button class="form-btn" style="width: 200px;">ログイン画面へ</button></a>
		</div>
	</form:form>
</body>
</html>