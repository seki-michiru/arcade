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

    <h2 id="sub-title">インベーダーゲーム</h2>

    <div id="rank-msg-div"><p class="rank-msg">あなたのランキング</p>
    <p class="rank-msg">${requestScope.myRank.get(0).getRank()}</p>
    <p class="rank-msg">${requestScope.myRank.get(0).getHighScore()}</p></div>

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
            <td>${requestScope.rankingInvader.get(0).getRank()}</td>
            <td>${requestScope.rankingInvader.get(0).getUserName()}</td>
            <td>${requestScope.rankingInvader.get(0).getHighScore()}</td>
            <td>${requestScope.higtScoreDateFirst.getHighScoreDate()}</td>
            <td>${requestScope.rankingInvader.get(0).getPlayNum()}</td>
        </tr>
        <tr>
            <td>${requestScope.rankingInvader.get(1).getRank()}</td>
            <td>${requestScope.rankingInvader.get(1).getUserName()}</td>
            <td>${requestScope.rankingInvader.get(1).getHighScore()}</td>
            <td>${requestScope.higtScoreDateSecond.getHighScoreDate()}</td>
            <td>${requestScope.rankingInvader.get(1).getPlayNum()}</td>
        </tr>
        <tr>
            <td>${requestScope.rankingInvader.get(2).getRank()}</td>
            <td>${requestScope.rankingInvader.get(2).getUserName()}</td>
            <td>${requestScope.rankingInvader.get(2).getHighScore()}</td>
            <td>${requestScope.higtScoreDateThird.getHighScoreDate()}</td>
            <td>${requestScope.rankingInvader.get(2).getPlayNum()}</td>
        </tr>
    </table>

</body>
</html>