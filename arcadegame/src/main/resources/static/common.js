// $(function() {
//     var img;
//     var left = 60;
//     var leftFlag = false;

//     for(let i = 0; i < 30; i++) {
//         img = document.createElement('img');
//         img.src = 'images/invader1.png';
//         img.className = 'invader-img';
//         document.getElementById('enemy').appendChild(img);
//     }
//     function leftplus() {
//         if(left > 380){
//             leftFlag = true;
//         }else if(left < 60) {
//             leftFlag = false;
//         }
//         if(leftFlag == false) {
//             left += 20;
//         }else if(leftFlag == true) {
//             left -= 20;
//         }
//         $("#enemy").css('left',left + 'px');
//     }

//     setInterval(leftplus,400);

//     $('.myself-img').click(function() {
//         $('.invader-img').remove();
//     })

//     var stalker = document.getElementById('stalker');

//     document.addEventListener('mousemove', function (e) {
//         var sss = e.clientX - 50;

//         stalker.style.transform = 'translate(' + sss  + 'px)';
//         if(e.clientX > 1240) {
//             stalker.style.transform = 'translate(' + 1240 + 'px)';
//         }
//     });

//     var ballFlag = true;
//     var ballremoveFlag = true;
//     function remove() {
//         $('.ball').remove();
//     }

//     if(ballFlag){
//     document.addEventListener('mousemove', function (e) {
//         ballFlag = false;
//         ballremoveFlag = false;
//         $(this).click(function() {
//             var ball = document.createElement('img');
//             ball.src = 'images/ball.jpg';
//             ball.className = 'ball';
//             document.getElementById('max-width').appendChild(ball);
//             var mause = e.clientX + 'px';
//             $('.ball').css('left', mause);
//             console.log(mause);
//             });
//         });
//     }
//     if(ballremoveFlag){
//         setTimeout(remove,5000);
//         ballFlag = true;
//     }

// });



var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
console.log(ctx);
// ボールの大きさ
var ballRadius = 10;
var myMisileX = canvas.width/2;
var myMisileY = canvas.height-30;
var enemyMisileX = -10;
var enemyMisileY = 0;
// 敵のミサイルの速度
var enemyMisileDy = 10;
var enemyMisileExist = false;
var startFlag = true;
var hitStatus = true;
// 自分のミサイルの速度
var myMisileDy = -10;
// パドルの高さ
var paddleHeight = 20;
// パドルの横幅
var paddleWidth = 150;
var paddleX = (canvas.width-paddleWidth)/2;
var mouseClicked = false;
// 敵の一列ごとの数
var brickRowCount = 10;
// 敵の列の数
var brickColumnCount = 3;
// 敵の横幅
var brickWidth = 85;
// 敵の高さ
var brickHeight = 50;
// 敵のパディング
var brickPadding = 30;

var brickOffsetTop = 40;
var brickOffsetLeft = 40;
var score = 0;

var lives = 3;

var item1Flag = true;
var item2Flag = true;
var item3Flag = true;

// var img = document.createElement('img');
// img.src = 'images/invader1.png';
// img.className = 'invader-img';
// document.getElementById('myCanvas').appendChild(img);

document.body.addEventListener('keydown',
    event => {
      if (event.key === 'z' && item1Flag) {
        lives = 10;
        item1Flag = false;
        $('.box1').remove();
        $('.item-name1').remove();
      }
    });
document.body.addEventListener('keydown',
    event => {
      if (event.key === 'x' && item2Flag) {
        score = score * 2;
        item2Flag = false;
        $('.box2').remove();
        $('.item-name2').remove();
      }
    });
document.body.addEventListener('keydown',
    event => {
      if (event.key === 'c' && item3Flag) {
        myMisileDy = -40;
        item3Flag = false;
        $('.box3').remove();
        $('.item-name3').remove();
      }
    });


// $('.box1').click(function() {
//   ballRadius = 30;
//   $('.box1').remove();
// })
// $('.box2').click(function() {
  //   myMisileDy = -40;
  //   $('.box2').remove();
  // })
  // $('.box3').click(function() {
    //   lives = 100;
    //   $('.box3').remove();
    // })
var score = 0;
function sample1() {
	document.getElementById("score").value=score;
    document.sampleform.submit();
}


    /* ブロック初期化 */
    var bricks = [];
    for(var c=0; c<brickColumnCount; c++) {
      bricks[c] = [];
      for(var r=0; r<brickRowCount; r++) {
        bricks[c][r] = { x: 0, y: 0, status: 1, misile: 0};
      }
    }

    document.addEventListener("mousemove", mouseMoveHandler, false);
    document.addEventListener("click", mouseClickHandler, false);

    /* 敵ミサイルの状態 */
var enemyMisileStatus = setInterval(function(){
  if(!enemyMisileExist){
        for(var c=0; c<brickColumnCount; c++) {
            for(var r=0; r<brickRowCount; r++) {
                bricks[c][r].misile = 0;
                }
            }
        var randomC = Math.floor( Math.random() * brickColumnCount );
        var randomR = Math.floor( Math.random() * brickRowCount );
        if(bricks[randomC][randomR].status == 1){
            bricks[randomC][randomR].misile = 1;
        }
    }
}, 3000-moveCount*100);

/* 発射ミサイル位置設定 */
var enemyMisilePosition = setInterval(function(){
    if(!enemyMisileExist){
        for(var c=0; c<brickColumnCount; c++) {
            for(var r=0; r<brickRowCount; r++) {
                if(bricks[c][r].misile == 1) {
                    enemyMisileX = bricks[c][r].x+brickWidth/2;
                    enemyMisileY = bricks[c][r].y;
                }
            }
        }
    }
}, 3000-moveCount*100);

var moveCount = 0;
var rightFlag = 1;
/* 敵位置の変更 */
var enemyPosition = setInterval(function(){
    startFlag = false;
    var moveX = 5;
    var moveY = 0;
    if(moveCount>75){
        //敵が迫ってきたので，ゲームオーバー
        alert("GAME OVER");
        sample1();

    }
    if(moveCount % 10 == 8){
        moveX = 0;
        moveY = 20;
        rightFlag = -rightFlag;
    } else {
        moveX = rightFlag*5;
    }
    for(var c=0; c<brickColumnCount; c++) {
        for(var r=0; r<brickRowCount; r++) {
            bricks[c][r].x += moveX;
            bricks[c][r].y += moveY;
        }
    }
    moveCount++;
}, 1000);

/* パドル位置の取得 */
function mouseMoveHandler(e) {
  var relativeX = e.clientX - canvas.offsetLeft;
  if(relativeX > 0 && relativeX < canvas.width) {
    paddleX = relativeX - paddleWidth/2;
  }
}

/* クリック位置の取得 */
function mouseClickHandler(e) {
  var relativeX = e.clientX - canvas.offsetLeft;
    if(!mouseClicked){
        myMisileX = relativeX;
        mouseClicked = true;
    }
}
var brocknum = 0;
/* ミサイルヒット判定 */
function collisionDetection() {
  for(var c=0; c<brickColumnCount; c++) {
    for(var r=0; r<brickRowCount; r++) {
      var b = bricks[c][r];
      if(b.status == 1) {
        if(myMisileX > b.x && myMisileX < b.x+brickWidth && myMisileY > b.y && myMisileY < b.y+brickHeight) {
          mouseClicked = false;
                    myMisileY = canvas.height-30;
          b.status = 0;
          score += 5 ;
                    console.log("敵にhit");
          brocknum++;
          if(brocknum == brickRowCount*brickColumnCount) {
            alert("You win, congratulations!");

            $('.score').html(score);
            sample1();
          }
        }
      }
    }
  }
}

/* ミサイルの生成 */
function drawMyMisile() {
  ctx.beginPath();
  ctx.arc(myMisileX, myMisileY, ballRadius, 0, Math.PI*2);
  ctx.fillStyle = "#ff69b4";
  ctx.fill();
  ctx.closePath();
}

/* 敵ミサイルの生成 */
function drawEnemyMisile() {
  ctx.beginPath();
  ctx.arc(enemyMisileX, enemyMisileY, ballRadius, 0, Math.PI*2);
  ctx.fillStyle = "#0095DD";
  ctx.fill();
  ctx.closePath();
}

/* パドルの生成 */
function drawPaddle() {
  ctx.beginPath();
  ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
  ctx.fillStyle = "#fff";
  ctx.fill();
  ctx.closePath();
}

/* ブロックの生成 */
function drawBricks() {
  for(var c=0; c<brickColumnCount; c++) {
    for(var r=0; r<brickRowCount; r++) {
      if(bricks[c][r].status == 1) {
                if(startFlag){
                    bricks[c][r].x = (r*(brickWidth+brickPadding))+brickOffsetLeft;
            bricks[c][r].y = (c*(brickHeight+brickPadding))+brickOffsetTop;
                }
        ctx.beginPath();
        ctx.rect(bricks[c][r].x, bricks[c][r].y, brickWidth, brickHeight);
        ctx.fillStyle = "#0095DD";
        ctx.fill();
        ctx.closePath();
      }
    }
  }
}

/* スコア表示 */
function drawScore() {
  ctx.font = "30px Arial";
  ctx.fillStyle = "#fff";
  ctx.fillText("Score: "+score, 8, 30);
}

/* HP表示 */
function drawLives() {
  ctx.font = "30px Arial";
  ctx.fillStyle = "#fff";
  ctx.fillText("Lives: "+lives, canvas.width-155, 30);
}

/* 描画 */
function draw() {
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  drawBricks();
  drawEnemyMisile();
  drawPaddle();
  drawScore();
  drawLives();
  collisionDetection();

    enemyMisileY += enemyMisileDy + 0.1*moveCount;
    if(enemyMisileY>canvas.height){
        enemyMisileExist = false;
        hitStatus = true;
    } else {
        enemyMisileExist = true;
    }
    if(hitStatus){
        if(canvas.height >= enemyMisileY && enemyMisileY >= canvas.height-ballRadius) {
            if(enemyMisileX > paddleX && enemyMisileX < paddleX + paddleWidth) {
                lives--;
                hitStatus = false;
                if(!lives) {
                     alert("GAME OVER");

                	sample1();

                }
            }
        }
    }

    if(mouseClicked){
        drawMyMisile();
        myMisileY += myMisileDy;
        if(myMisileY<=0){
            mouseClicked = false;
            myMisileY = canvas.height-30;
        }
    }
    if(myMisileY > enemyMisileY-ballRadius && enemyMisileY+ballRadius > myMisileY){
        if(myMisileX > enemyMisileX-ballRadius*2 && enemyMisileX+ballRadius*2 > myMisileX){
            console.log("MISILE同士がhit");
            enemyMisileExist = false;
            mouseClicked = false;
            myMisileY = canvas.height-30;
        }
    }
  requestAnimationFrame(draw);
}


draw();
