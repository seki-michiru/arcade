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
    <link rel="icon" href="images/invader1.png">
</head>
<body>
    <a href="menu"><img src="images/homeicon.png" alt=""class="home-icon"></a>
    <h1 id="sub-title">交換</h1>

    <a href="tradeMenu"><img src="images/returnbtn.png" alt=""class="returnbtn"></a>

    <form method="" action="">
    <table>
        <tr>
            <th></th>
            <th>出品者名</th>
            <th>ゲーム名</th>
            <th>出品アイテム</th>
            <th>対象アイテム</th>
        </tr>
        <tr>
            <td><input type="checkbox" name="1" style="width: 20px; height: 20px;"></td>
            <td>ああああ</td>
            <td>インベーダー</td>
            <td>アイテム1</td>
            <td>アイテム2</td>
        </tr>
    </table>
    </form>

    <div id="form-btn-center"><button class="form-btn" style="width: 200px;">交換する</button></div>

</body>
</html>