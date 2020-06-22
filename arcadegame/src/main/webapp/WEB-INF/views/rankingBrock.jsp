    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>インベーダーゲームランキング</title>
    <link rel="stylesheet" href="css/all.css">
    <link rel="icon" href="images/invader1.png">

</head>
<body>

    <a href="ranking"><img src="images/returnbtn.png" alt="" class="returnbtn"></a>
    <a href="menu"><img src="images/homeicon.png" alt="" class="home-icon"></a>

    <h2 id="sub-title">ブロック崩し</h2>

    <div id="rank-msg-div"><p class="rank-msg">あなたのランキング</p>
    <p class="rank-msg">${requestScope.myRank.get(0).rank}</p>
    <p class="rank-msg">${requestScope.myRank.get(0).highScore}</p></div>

    <table border="1">
        <caption>BEST3</caption>
        <tr>
            <th>順位</th>
            <th>ユーザー名</th>
            <th>スコア</th>
            <th>日付</th>
            <th>遊んだ回数</th>
        </tr>

        <tr>
            <td>${requestScope.rankingBrock.get(0).rank}</td>
            <td>${requestScope.rankingBrock.get(0).userName}</td>
            <td>${requestScope.rankingBrock.get(0).highScore}</td>
            <td>${requestScope.higtScoreDateFirst(0).highScoreDate}</td>
            <td>${requestScope.rankingBrock.get(0).playNum}</td>
        </tr>
        <tr>
            <td>${requestScope.rankingBrock.get(1).rank}</td>
            <td>${requestScope.rankingBrock.get(1).userName}</td>
            <td>${requestScope.rankingBrock.get(1).highScore}</td>
            <td>${requestScope.higtScoreDateSecond(0).highScoreDate}</td>
            <td>${requestScope.rankingBrock.get(1).playNum}</td>
        </tr>
        <tr>
            <td>${requestScope.rankingBrock.get(2).rank}</td>
            <td>${requestScope.rankingBrock.get(2).userName}</td>
            <td>${requestScope.rankingBrock.get(2).highScore}</td>
            <td>${requestScope.higtScoreDateThird(0).highScoreDate}</td>
            <td>${requestScope.rankingBrock.get(2).playNum}</td>
        </tr>


    </table>

</body>
</html>