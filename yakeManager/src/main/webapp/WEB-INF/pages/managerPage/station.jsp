<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="http://localhost:8080/raliway12307/img/train_ico.ico">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/unifiStyle.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/station.css">
    <title>列车大屏</title>
</head>
    <body>
        <div class="navigation">
            <ul>
                <li id="logo">
                    <img src="http://localhost:8080/raliway12307/img/100years.gif">
                </li>
                <li><a href="http://localhost:8080/raliway12307/managerHome">首页</a></li>
                <li><a id="nav-buts1" href="http://localhost:8080/raliway12307/manager/station" onclick="getUser()">列车管控</a></li>
                <li><a id="nav-buts3" href="http://localhost:8080/raliway12307/manager/Railways" onclick="getUser()">列车大屏</a></li>
                <li><a id="nav-buts4" href="http://localhost:8080/raliway12307/raliway/mine" onclick="getUser()">个人信息</a></li>
                <li style="float:right">
                    <div id="userImg">
                        <img src="http://localhost:8080/raliway12307/img/clientImg/0_qq_44140450_1620910175.png" id="mine">
                    </div>
                </li>
            </ul>
        </div>
        <div class="page">
            <div class="nothing"></div>
            <div id="message-page">
                <div >
                    <input type="date" style="margin-left: 2%;" id="time" >
                    <button id="submit-btn">查看</button>
                </div>
                <table id="tab">
                    <tr>
                        <th>班次</th>
                        <th>发车时间</th>
                        <th>起点</th>
                        <th>终点</th>
                        <th>行车时间</th>
                        <th>载客量</th>
                        <th>已订票人数</th>
                        <th>列车运行状态</th>
                    </tr>
                </table>
            </div>
        </div>
        <script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
        <script src="http://localhost:8080/raliway12307/js/managerJs/station.js"></script>
    </body>
</html>