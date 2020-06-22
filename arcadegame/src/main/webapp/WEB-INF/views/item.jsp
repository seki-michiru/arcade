    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


    <a href="menu"><img src="images/homeicon.png" alt=""class="home-icon"></a>

    <h1 id="sub-title">所持アイテム</h1>

    <table>
        <tr>
            <th>ゲーム名</th>
            <th>アイテム名</th>
            <th>所持数</th>
            <th>説明</th>
        </tr>
        <c:forEach var="allItem" items="${requestScope.allItem}">
        <tr>
            <td><c:out value ="${allItem.gameName}"/></td>
            <td><c:out value = "${allItem.itemName}"/></td>
            <td><c:out value = "${allItem.itemHave}"/></td>
            <td><c:out value = "${allItem.itemExplan}"/></td>
        </tr>
		</c:forEach>

    </table>

</body>
</html>