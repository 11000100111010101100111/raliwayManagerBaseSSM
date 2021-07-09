<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="http://localhost:8080/raliway12307/img/train_ico.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/unifiStyle.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/mine.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/clientCss/clock.css">
    <title>我的</title>
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
    <div id="my-bar">
        <ul>
            <li id="my-message-bar">
                <input type="button" value="我的信息">
            </li>
            <li id="manager-shenqing-bar">
                <input type="button" value="管理员申请">
            </li>
            <li id="account-safe-bar">
                <input type="button" value="账号安全">
            </li>
        </ul>
    </div>
    <div id="zhanwei"></div>

    <!-- 展示个人信息 -->
    <div id="my-message" class="message-mine">

        <div id="user-top">
            <div id="user-top-child">
                <div id="id-name">
                    <h3>海子哥的主页</h3>
                </div>
                <div>
                    <p>不需要描述!</p>
                </div>
            </div>
        </div>
        <div id="user-bottom">
            <div id="img-box">
                <img id="user-img" src="http://localhost:8080/raliway12307/img/clientImg/0_qq_44140450_1620910175.png">
            </div>
            <div id="user-title">
                <div>
                    <h4>${client_name}</h4>
                </div>
                <div>
                    <h5>
                        工作之星
                    </h5>
                </div>
                <div>
                    <p>
                        一直在努力！
                    </p>
                </div>
            </div>
            <div id="user-message">
                <div id="left-lan" class="lan">
                    <div>id:
                        <label id="userid">${client_id}</label>
                        <button>
                            <?xml version="1.0" encoding="UTF-8"?>
                            <svg width="24" height="24" viewBox="0 0 48 48" fill="none"
                                 xmlns="http://www.w3.org/2000/svg" id="modify">
                                <rect width="48" height="48" fill="white" fill-opacity="0.01" />
                                <path d="M7 42H43" stroke="#666" stroke-width="4" stroke-linecap="square"
                                      stroke-linejoin="bevel" />
                                <path d="M11 26.7199V34H18.3172L39 13.3081L31.6951 6L11 26.7199Z" fill="none"
                                      stroke="#666" stroke-width="4" stroke-linejoin="bevel" />
                            </svg>
                        </button>
                    </div>
                    <div>name:
                        <label id="username">${client_name}</label>
                        <button>
                            <?xml version="1.0" encoding="UTF-8"?>
                            <svg width="24" height="24" viewBox="0 0 48 48" fill="none"
                                 xmlns="http://www.w3.org/2000/svg" id="modify">
                                <rect width="48" height="48" fill="white" fill-opacity="0.01" />
                                <path d="M7 42H43" stroke="#666" stroke-width="4" stroke-linecap="square"
                                      stroke-linejoin="bevel" />
                                <path d="M11 26.7199V34H18.3172L39 13.3081L31.6951 6L11 26.7199Z" fill="none"
                                      stroke="#666" stroke-width="4" stroke-linejoin="bevel" />
                            </svg>
                        </button>
                    </div>
                    <div>身份:
                        <label id="usertype">${client_type}</label>
                    </div>
                </div>
                <div id="right-lan" class="lan">
                    <div>phone：
                        <label id="userphone">${client_type}</label>
                        <button>
                            <?xml version="1.0" encoding="UTF-8"?>
                            <svg width="24" height="24" viewBox="0 0 48 48" fill="none"
                                 xmlns="http://www.w3.org/2000/svg" id="modify">
                                <rect width="48" height="48" fill="white" fill-opacity="0.01" />
                                <path d="M7 42H43" stroke="#666" stroke-width="4" stroke-linecap="square"
                                      stroke-linejoin="bevel" />
                                <path d="M11 26.7199V34H18.3172L39 13.3081L31.6951 6L11 26.7199Z" fill="none"
                                      stroke="#666" stroke-width="4" stroke-linejoin="bevel" />
                            </svg>
                        </button>
                    </div>
                    <div>身份证：
                        <label id="useric">${client_ic}</label>
                        <button>
                            <?xml version="1.0" encoding="UTF-8"?>
                            <svg width="24" height="24" viewBox="0 0 48 48" fill="none"
                                 xmlns="http://www.w3.org/2000/svg" id="modify">
                                <rect width="48" height="48" fill="white" fill-opacity="0.01" />
                                <path d="M7 42H43" stroke="#666" stroke-width="4" stroke-linecap="square"
                                      stroke-linejoin="bevel" />
                                <path d="M11 26.7199V34H18.3172L39 13.3081L31.6951 6L11 26.7199Z" fill="none"
                                      stroke="#666" stroke-width="4" stroke-linejoin="bevel" />
                            </svg>
                        </button>
                    </div>
                    <div>email：
                        <label id="useremail">${client_email}</label>
                        <button>
                            <?xml version="1.0" encoding="UTF-8"?>
                            <svg width="24" height="24" viewBox="0 0 48 48" fill="none"
                                 xmlns="http://www.w3.org/2000/svg" id="modify">
                                <rect width="48" height="48" fill="white" fill-opacity="0.01" />
                                <path d="M7 42H43" stroke="#666" stroke-width="4" stroke-linecap="square"
                                      stroke-linejoin="bevel" />
                                <path d="M11 26.7199V34H18.3172L39 13.3081L31.6951 6L11 26.7199Z" fill="none"
                                      stroke="#666" stroke-width="4" stroke-linejoin="bevel" />
                            </svg>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 处理管理员账号注册的申请 -->
    <div id="manager-shenqing" class="message-mine">
        处理管理员账号注册的申请
    </div>

    <!-- 个人账号安全管理 -->
    <div id="account-safe" class="message-mine">
        个人账号安全管理
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
</div>
</div>


<script src="http://localhost:8080/raliway12307/js/importJq/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/all.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/railwayOperator.js"></script>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/mine.js"></script>
</body>

</html>
