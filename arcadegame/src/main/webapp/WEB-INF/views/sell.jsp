<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>アーケードゲーム</title>
    <link rel="stylesheet" href="css/all.css">
</head>
<body>
    <a href="menu.html"><img src="images/homeicon.png" alt=""class="home-icon"></a>

    <h1 id="sub-title">売却</h1>
    <h3 id="mycoin">所持コイン：100枚</h3>
    <a href="shop.html"><img src="images/returnbtn.png" alt=""class="returnbtn"></a>

    <table>
        <tr>
            <th></th>
            <th class="checkbox">ゲーム名</th>
            <th class="checkbox">アイテム名</th>
            <th class="checkbox">値段</th>
            <th class="checkbox">個数</th>
        </tr>
        <tr>
            <td><input type="checkbox" name="" style="width: 20px; height: 20px;"></td>
            <td>インベーダー</td>
            <td>アイテム1</td>
            <td>5枚</td>
            <td><input type="number" value="0" min="0" class="form-number"></td>
        </tr>
    </table>

    <div id="form-btn-center"><button class="form-btn">売却する</button></div>

</body>
</html>