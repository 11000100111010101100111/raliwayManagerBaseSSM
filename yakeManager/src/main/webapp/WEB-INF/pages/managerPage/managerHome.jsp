<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <META http-equiv=Content-Type content="text/html;charset=utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="shortcut icon" href="http://localhost:8080/raliway12307/img/train_ico.ico" type="image/x-icon">
    <!--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
    <meta name="referrer" content="never">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/unifiStyle.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/managerHome.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/clientCss/clock.css">
    <title>管理员首页</title>
</head>

<body>
<<div class="navigation">
    <ul>
        <li id="logo">
            <img src="http://localhost:8080/raliway12307/img/100years.gif">
        </li>
        <li><a href="http://localhost:8080/raliway12307/managerHome">首页</a></li>
        <li><a id="nav-buts1" href="http://localhost:8080/raliway12307/manager/station" onclick="getUser()">列车管控</a></li>
        <!-- <li><a id="nav-buts2" href="./station.html" onclick="getUser()">铁路运维</a></li> -->
        <li><a id="nav-buts3" href="http://localhost:8080/raliway12307/manager/Railways" onclick="getUser()">列车大屏</a></li>
        <li><a id="nav-buts4" href="http://localhost:8080/raliway12307/raliway/mine" onclick="getUser()">个人信息</a></li>
        <li style="float:right">
            <div id="userImg">
                <img src="${client_avator}" id="mine">
            </div>
        </li>
    </ul>

</div>
<div class="content">
    <div class="page">
        <div class="nothing">nothing</div>
        <div class="havething">
            <div class="picbox">
                <img id="mainPic" src='https://n.sinaimg.cn/default/transform/350/w2840h710/20210621/1099-krpikqh4003503.png'>
            </div>
            <div class="contextbox">
                <div class="left" id="bigleft">
                    <!-- 查看时间 -->
                    <div id="chuxing-service" class="message-mine">
                        <div id="out-clock-box" style="transform: translateX(-50%) translateY(25%);">
                            <div id="in-clock-box">
                                <div id="watch">
                                    <ul class="minute-marks">
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                        <li></li><li></li><li></li><li></li><li></li><li></li>
                                    </ul>
                                    <ul class="digits">
                                        <li>1</li><li>2</li><li>3</li><li>4</li><li>5</li><li>6</li>
                                        <li>7</li><li>8</li><li>9</li><li>10</li><li>11</li><li>12</li>
                                    </ul>
                                </div>
                                <div class="clock">
                                    <div class="hour-hand"></div>
                                    <div class="minute-hand"></div>
                                    <div class="second-hand"></div>
                                    <div class="circle"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="right" >
                    <div class="hover-pic" id="top"  onclick="top()" style="background: url('http://localhost:8080/raliway12307/img/managerImg/stationManagerRaliway.jpg') no-repeat;background-size: 100% 100%;">
                    </div>
                    <div id="bottom">
                        <div class="left hover-pic" onclick="smallleft()"  id="smallleft" style="background: url('http://localhost:8080/raliway12307/img/managerImg/raliwayStation.jpg') no-repeat;background-size: 100% 100%;">

                        </div>
                        <div class="right hover-pic" onclick="smallright()" id="smallright" style="background: url('http://localhost:8080/raliway12307/img/managerImg/mine.jpg') no-repeat;background-size: 100% 100%;" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="context-zanwei"></div>
        </div>

        <div class="message" >
            <div id="item" class="hover-pic" style="background: url('http://localhost:8080/raliway12307/img/managerImg/bigbottom.jpg') no-repeat;background-size: 100% 100%;"></div>
        </div>

    </div>
</div>


<script src="http://localhost:8080/raliway12307/js/importJq/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/all.js"></script>
<script src="http://localhost:8080/raliway12307/js/clientJs/clock.js"></script>
<script src="http://localhost:8080/raliway12307/js/clientJs/railwayOperator.js"></script>
<script>
    function top() {
        document.location.href = "http://localhost:8080/raliway12307/manager/Railways";
    }
    function smallleft() {
        document.location.href = "http://localhost:8080/raliway12307/manager/station";
    }
    function smallright() {
        document.location.href = "http://localhost:8080/raliway12307/raliway/mine";
    }
</script>
</body>

</html>