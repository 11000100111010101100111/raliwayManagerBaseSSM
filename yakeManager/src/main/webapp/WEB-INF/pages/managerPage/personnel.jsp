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
    <title>Title</title>
    <link rel="shortcut icon" href="http://localhost:8080/raliway12307/img/train_ico.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/managerCss/unifiStyle.css">
    <title>人事管理</title>
    <style>

    </style>
</head>

<body>
<div class="navigation">
    <ul>
        <li id="logo">
            <img src="http://localhost:8080/raliway12307/img/100years.gif">
        </li>
        <li><a href="http://localhost:8080/raliway12307/managerHome">首页</a></li>
        <li><a id="nav-buts1" href="http://localhost:8080/raliway12307/manager/station" onclick="getUser()">列车管控</a></li>
        <!-- <li><a id="nav-buts2" href="./station.html" onclick="getUser()">铁路运维</a></li> -->
        <li><a id="nav-buts3" href="http://localhost:8080/raliway12307/manager/Railways" onclick="getUser()">列车大屏</a></li>
        <li><a id="nav-buts4" href="http://localhost:8080/raliway12307/manager/mine" onclick="getUser()">个人信息</a></li>
        <li style="float:right">
            <div id="userImg">
                <img src="http://localhost:8080/raliway12307/img/clientImg/0_qq_44140450_1620910175.png" id="mine">
            </div>
        </li>
    </ul>

</div>

<div class="page">
    <div class="nothing"></div>
    <div class="message-page">

    </div>
</div>

<div class="msg">
    <div>
        <ul class="raliway-link">
            <li class="first">
                <h3>关于我们</h3>
                <p><a href="#" target="_blank">全国出行</a></p>

                <p><a href="#" target="_blank">省内直达</a></p>

                <p><a href="#" target="_blank">安全出行</a></p>

                <p><a href="#" target="_blank">贴心保障</a></p>
            </li>
            <li>
                <h3>使用指南</h3>

                <p><a href="#" target="_blank">新手入门</a></p>

                <p><a href="#" target="_blank">买票流程</a></p>

                <p><a href="#" target="_blank">常见问题</a></p>

                <p><a href="#" target="_blank">帮助中心</a></p>

            </li>
            <li>
                <h3>支付方式</h3>

                <p><a href="#" target="_blank">铁路12307</a></p>

                <p><a href="#" target="_blank">实名认证</a></p>

                <p><a href="#" target="_blank">会员服务</a></p>

            </li>
            <li class="last">
                <h3>商家支持</h3>
                <p><a href="#" target="_blank">招商频道</a></p>
                <p><a href="#" target="_blank">商标代理</a></p>
                <p><a href="#" target="_blank">知识产权保护</a></p>
                <p><a href="#" target="_blank">问题反馈</a></p>

            </li>
            <div id="two-D-code">
                <img src='http://localhost:8080/raliway12307/img/-6a34e7f5552a5041.jpg'>
            </div>
        </ul>


    </div>

</div>

</body>

</html>
