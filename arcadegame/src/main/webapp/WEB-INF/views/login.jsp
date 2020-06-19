<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<h2 id="sub-title">ログイン</h2>
	<a href="top"><img src="images/returnbtn.png" alt=""
		class="returnbtn"></a>
		<c:if test="${not empty msg}">
        <span class="error" style="color: red">${msg}</span>
        </c:if>

	<form:form action="login1" modelAttribute="login">

		<div id="form-btn-center">
			<div id="form-div">
				<div>
					<label for="" class="form-item">ID</label><input type="text"
						name="loginId" class="text-design-id text-box">
					<form:errors path="loginId" cssStyle="color: red" />
				</div>
				<br>
				<div>
					<label for="" class="form-item">PASS</label><input type="password"
						name="password" class="text-design-pass text-box">
					<form:errors path="password" cssStyle="color: red" />
				</div>
			</div>
		</div>
		<div id="form-btn-center">
			<button class="form-btn">ログイン</button>
		</div>
	</form:form>
</body>
</html>