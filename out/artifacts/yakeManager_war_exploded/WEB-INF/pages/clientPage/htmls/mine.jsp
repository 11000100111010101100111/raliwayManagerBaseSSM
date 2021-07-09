<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="http://localhost:8080/raliway12307/img/train_ico.ico">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/clientCss/ticket.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/clientCss/clock.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/clientCss/mine.css">
    <title>个人主页</title>
    <style>
        body::-webkit-scrollbar{
            display:none;
        }
        #account-safe h5{
            padding-top: 20px;
            text-align: center;width: 100%;
            font-size: 32px;
        }
        #account-safe .msg-my-input{
            width: 50%;
            height: 30px;
            text-align: center;
            /*position:absolute;*/
            left:50%;
            /*transform: translateX(50%) translateY(10%);*/
            margin-top: 40px;
            margin-left: 25%;
            font-size: 16px;
            outline: none;
            /*border: 0;*/
        }
        #account-safe .fist-my-input{
            margin-top: 160px;
            border-radius: 5px;

        }
        #account-safe input[type='button']{
            width: 10%;height: 30px;
            margin-left:45% ;
            background-color: #fff;
            border: solid 1px darkslateblue;
            border-radius: 10px;

        }
        #account-safe input:focus{
            transition: 0.3s;
            /*border: solid 1px darkslateblue;*/
            box-shadow: 0 0 12px darkslateblue;
        }
        #account-safe input[type='button']:hover{
            transition: 0.3s;
            background-color: darkslateblue;
            color: #fff;
            box-shadow: 0 0 12px #43376e;
        }
    </style>
</head>

<body>
<div id="head">
    <div class="navigation" style="width: 100%;height: 70px;margin: 0;background: url('http://localhost:8080/raliway12307/img/homeImg/train_00.jpg') no-repeat;
            background-size: 100% 100%;">
    </div>

    <div id="my-bar">
        <ul>
            <li id="home-bar">
                <a href="http://localhost:8080/raliway12307/">
                    <input type="button" value="主页" >
                </a>
            </li>
            <li id="my-message-bar">
                <input type="button" value="我的信息">
            </li>
            <li id="chuxing-service-bar">
                <input type="button" value="查看时间">
            </li>
            <li id="bake-ticket-bar">
                <input type="button" value="我的火车票">
            </li>
            <li id="account-safe-bar">
                <input type="button" value="账号安全">
            </li>
        </ul>
    </div>
</div>
<div class="page">
    <div class="nothing"></div>

    <div id="zhanwei"></div>

    <!-- 展示个人信息 -->
    <div id="my-message" class="message-mine" style="height: 710px;">

        <div id="user-top">
            <div id="user-top-child">
                <div id="id-name">
                    <h3>${client_name}的主页</h3>
                </div>
                <div>
                    <p>不需要描述!</p>
                </div>
            </div>
        </div>
<%--        <div id="user-bottom">--%>
<%--            <div id="img-box">--%>
<%--                <img id="user-img" src="http://localhost:8080/raliway12307/img/clientImg/0_qq_44140450_1620910175.png">--%>
<%--            </div>--%>
<%--            <div id="user-title">--%>
<%--                <div>--%>
<%--                    <h4>海子哥</h4>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <h5>--%>
<%--                        出行达人--%>
<%--                    </h5>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <p>--%>
<%--                        这个人什么也没写！--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div id="user-bottom">
                <div id="img-box">
<%--                    <img id="user-img" src="https://avatar.csdnimg.cn/6/3/7/0_qq_44140450_1620910175.jpg">--%>
    <img id="user-img" src="${client_avator}">
<%--    client_avator--%>
                </div>
                <div id="user-title">

                    <div>
                        <h4>${client_name}</h4>
                    </div>
                    <div>
                        <h5>
                            出行达人
                        </h5>
                    </div>

                </div>
                <div>
                    <p style="width: 100%;text-align: center;">
                        ${client_signature}
                        <button style="width: 20px;height: 20px;border: 0;">
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
                    </p>
                </div>
<%--            <p id="u-name">${client_msg.client_name}</p>--%>
<%--            <p id="u-id">${client.client_id}</p>--%>
<%--            <p id="u-type">${client.client_type}</p>--%>
<%--            <p id="u-ic">${client.client_ic}</p>--%>
<%--            <p id="u-pho">${client.client_phone}</p>--%>
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
                        <label id="userphone">${client_phone}</label>
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

    <!-- 查看时间 -->
    <div id="chuxing-service" class="message-mine">
        <div id="out-clock-box">
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

    <!-- 我的火车票管理 -->
    <div id="back-tick-service" class="message-mine"  style="overflow: auto;">
        <div>
            <button id= "find-my-tickets" style="margin-left: 20px;width: 100px;height: 30px;border: 0;background-color: #222E3C;color: #fff;" class="inline-block-elem">点击查询我的票</button>
            <select class="inline-block-elem" id="tickets-id-nums" style="margin-left: 20px;width: 200px;height: 30px;border: 0;border-bottom: solid 1px #666;">
                <option value="" style="color: #888" disabled selected>请选择一张火车票：</option>
            </select>
        </div>
        <!-- 我的火车票管理 -->
        <div id="tickets-box">
            <ul id="uls">

<%--                <li class="inline-block-elem" value="11116">--%>

<%--                    <div class="tickes"  onmousedown='chiosed(this)'>--%>

<%--                        <div class="tick-1">--%>
<%--                            <div class="tick-11">--%>
<%--                                <p class="id-warter" >123465846516456</p>--%>

<%--                                <div class="tick-111">--%>

<%--                                    <h3 class="inline-block-elem tick-111-sub">南昌西</h3>--%>

<%--                                    <div class="tick-1111 inline-block-elem tick-111-sub">--%>
<%--                                        <h5 style="text-align: center;">G2312</h5>--%>
<%--                                        <!--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->--%>
<%--                                        <img src='http://localhost:8080/raliway12307/img/clientImg/icon_go.png' >--%>
<%--                                        <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->--%>
<%--                                    </div>--%>
<%--                                    <h3 class="inline-block-elem tick-111-sub">北京南</h3>--%>

<%--                                </div>--%>
<%--                                <p class="tick-1121">2021年6月13号&nbsp;&nbsp;16:45&nbsp;&nbsp;开</p>--%>
<%--                                <div class="tick-112">--%>
<%--                                    <p class="tick-1121 inline-block-elem">￥45.5元</p>--%>
<%--                                    <p class="tick-1122 inline-block-elem">二等座</p>--%>
<%--                                </div>--%>

<%--                                <div class="tick-113 ">--%>
<%--                                    <p class="tick-1121 inline-block-elem">26354899951257841X&nbsp;&nbsp;张三</p>--%>
<%--                                    <img class="inline-block-elem" src=''>--%>
<%--                                </div>--%>

<%--                            </div>--%>
<%--                            <div class="tick-12">--%>
<%--                                <button id='back-button'>退票</button>--%>
<%--                                <button id='modify-button'>改签</button>--%>
<%--                            </div>--%>
<%--                            <div class="is-shixiao"><p>已失效</p></div>--%>
<%--                        </div>--%>
<%--                        <p class="make-msg">铁路12306&nbsp;&nbsp;制</p>--%>
<%--                    </div>--%>
<%--                </li>--%>
                <!-- <li class="inline-block-elem" value="11116"><div class="tickes"><div class="tick-1"><div class="tick-11"><p class="id-warter" >
                123465846516456</p><div class="tick-111"><h3 class="inline-block-elem tick-111-sub">
                南昌西</h3><div class="tick-1111 inline-block-elem tick-111-sub"><h5 style="text-align: center;">
                G2312</h5><img src='./img/icon_go.png' ></div><h3 class="inline-block-elem tick-111-sub">
                北京南</h3></div><p class="tick-1121">
                2021年6月13号&nbsp;&nbsp;16:45&nbsp;&nbsp;开</p><div class="tick-112"><p class="tick-1121 inline-block-elem">
                ￥45.5元</p><p class="tick-1122 inline-block-elem">
                二等座</p></div><div class="tick-113 "><p class="tick-1121 inline-block-elem">
                26354899951257841X&nbsp;&nbsp;张三</p><img class="inline-block-elem" src=''></div></div><div class="tick-12"><button id='back-button'>
                退票</button><button id='modify-button'>
                改签</button></div><div class="is-shixiao"><p>
                已失效</p></div></div><p class="make-msg">
                铁路12306&nbsp;&nbsp;制</p></div></li> -->
            </ul>
        </div>
        <div> </div>
    </div>
    <!-- 个人账号安全管理 -->

        <div id="account-safe" class="message-mine">
            <div style="width: 100%;height: 80%;">
                <h5 >账号安全</h5>
                <input class="msg-my-input fist-my-input" value="${client_id}" id="c_id" readonly>
                <input class="msg-my-input" type="password" id="old_pwd" placeholder="请输入密码" onblur="pwd_onblur()">
                <input class="msg-my-input" type="password" id="new_pwd" placeholder="请输入新密码" >
                <input class="msg-my-input" type="password" id="new_pwd2" placeholder="请确认新密码" >
                <input class="msg-my-input" type="button" value="确认修改" onclick="submit_newmsg()">
            </div>
        </div>

    <label style="width: 0;height: 0;visibility: hidden;" id =  "client_id">${client_id}</label>
</div>
<div id="bottom-msg">
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
                <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
                <img src='http://localhost:8080/raliway12307/img/clientImg/-6a34e7f5552a5041.jpg'>
                <!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
            </div>
        </ul>
    </div>

</div>
</div>

<script src="http://localhost:8080/raliway12307/js/importJq/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/all.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/railwayOperator.js"></script>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/clientJs/mine.js"></script>
<script>

    // /modifyPwd

    function pwd_onblur(){
        // alert("离开密码");
    }
    function submit_newmsg(){
        if($("#old_pwd").val() === "" || $("#new_pwd").val() === "" || $("#new_pwd2").val() === ""){
            alert("请输入完整后再提交！");
        }else{
            if($("#new_pwd2").val() != $("#new_pwd").val()){
                alert("前后密码输入不一致！");
                $("#new_pwd2").val("");
                $("#new_pwd").val("");
            }else{
                var data={
                    id:$("#c_id").val(),
                    old_pwd:$("#old_pwd").val(),
                    new_pwd: $("#new_pwd").val()
                };
                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/modifyPwd", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: data,
                    success: function (data) {
                        if (  data === 2) {
                           alert("新密码已经修改成功，请重新登录！");
                            document.location.href="http://localhost:8080/raliway12307/raliway/noUser";
                        }else if(data === 1){
                            alert("原始密码输入错误！请重新输入！");
                            $("#old_pwd").val("");
                        }else{
                            alert("失败了！异常操作！");
                        }
                    }
                });
            }
        }
    }

</script>
</body>

</html>
