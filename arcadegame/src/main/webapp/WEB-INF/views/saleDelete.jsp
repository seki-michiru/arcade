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
    <a href="menu.html"><img src="images/homeicon.png" alt=""class="home-icon"></a>
    <h1 id="sub-title">出品を削除</h1>

    <a href="tradeMenu.html"><img src="images/returnbtn.png" alt=""class="returnbtn"></a>

    <form action="">
        <table>
            <tr>
                <th></th>
                <th>ゲーム名</th>
                <th>所持アイテム</th>
                <th>ほしいアイテム</th>
            </tr>
            <tr>
                <td><input type="checkbox" style="width: 20px; height: 20px;"></td>
                <td>インベーダー</td>
                <td>アイテム1</td>
                <td>アイテム2</td>
            </tr>
        </table>

        <div id="form-btn-center"><button class="form-btn" style="width: 200px;">削除</button></div>
    </form>

</body>
</html>