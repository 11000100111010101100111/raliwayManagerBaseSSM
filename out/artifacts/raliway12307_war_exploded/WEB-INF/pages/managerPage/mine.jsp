<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/24
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <META http-equiv=Content-Type content="text/html;charset=utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <!--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
    <meta name="referrer" content="never">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/managerCss/unifiStyle.css">
    <title>我的</title>
</head>
<body>
<div class="nav">
    <div class="navigation">
        <ul>
            <li id="logo">
                <img src="https://img-home.csdnimg.cn/images/20210616034854.gif">
            </li>
            <li> <a href="${pageContext.request.contextPath}">首页</a></li>
            <li><a id="nav-buts1" href="${pageContext.request.contextPath}/manager/raliway" onclick="getUser()">列车管控</a></li>
            <li><a id="nav-buts2" href="${pageContext.request.contextPath}/manager/station" onclick="getUser()">铁路运维</a></li>
            <li><a id="nav-buts3" href="${pageContext.request.contextPath}/manager/client" onclick="getUser()">客户管理</a></li>
            <li><a id="nav-buts4" href="${pageContext.request.contextPath}/manager/personnel" onclick="getUser()">人事</a></li>
            <li style="float:right">
                <div id="userImg">
                    <!--https://avatar.csdnimg.cn/6/3/7/0_qq_44140450_1620910175.jpg
                                            http://localhost:8888/manager.yake.com/manager/home/mine-->
                    <img src="https://avatar.csdnimg.cn/6/3/7/0_qq_44140450_1620910175.jpg" id="mine">
                </div>
            </li>
        </ul>

    </div>
</div>

<div class="title">
    <div class="nav-box">
        <ul class="nav">
            <li class="J-liecheguabli">
                <h3 class="nav-header head-nav">列车管理</h3>
                <div class="nav-body">
                    <ul class="nav-body-item">
                        <li>
                            <a href="#">列车列表</a>
                        </li>
                        <li>
                            <a href="#">列车新发</a>
                        </li>
                        <li>
                            <a href="#">更改信息</a>
                        </li>
                        <li>
                            <a href="#">更改信息</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="J-keyunzhan">
                <h3 class="nav-header head-nav">客运站</h3>
                <div class="nav-body">
                    <ul class="nav-body-item">
                        <li>
                            <a href="#">位置图</a>
                        </li>
                        <li>
                            <a href="#">站台信息</a>
                        </li>
                        <li>
                            <a href="#">新增客运站</a>
                        </li>
                        <li>
                            <a href="#">更多信息</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="J-lichediaodu">
                <h3 class="nav-header head-nav">列车调度</h3>
                <div class="nav-body">
                    <ul class="nav-body-item">
                        <li>
                            <a href="#">列车首发</a>
                        </li>
                        <li>
                            <a href="#">停运</a>
                        </li>
                        <li>
                            <a href="#">启用</a>
                        </li>
                        <li>
                            <a href="#">列车改发</a>
                        </li>
                        <li>
                            <a href="#">更多</a>
                        </li>
                    </ul>
                </div>
            </li>

        </ul>
    </div>
</div>

<div class="page">
    <div class="nothing"></div>
    <h1></h1>
</div>

<div class="msg"></div>
个人信息<br>
安全管理<br>
人事申请<br>
工作记录<br>

<script src="${pageContext.request.contextPath}/js/importJq/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/managerJs/all.js"></script>
</body>
</html>
