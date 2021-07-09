<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/24
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>铁路12307-庆祝中国共产党建党100周年</title>
        <style>
            *{
                margin: 0;
                padding: 0;
            }
            .nav-bar{
                width: 100%;
                height: 45px;
                background-color: bisque;
                position: fixed;
                z-index: 99;
            }
            .nav-bar ul{
                width: 100%;
                height: 100%;
            }
            #logo{
                width: 80px;
                height: 40px;
                float: left;
                margin: 3px auto 2px 5px;
            }
            #logo img{
                width: 100%;
                height: 100%;
            }
            .nav-bar .nav-li,
            .nav-bar .nav-li-sub{
                width: 100px;
                height: 45px;
                list-style: none;
                display: inline-block;
                margin:0 10px 0 10px;
            }
            .nav-li{
                float: left;
            }
            .nav-li a{
                position:absolute;
                /* float: right; */
                top:50%;
                margin-left:5px ;
                transform: translateY(-50%);
                color:#666;
                cursor: pointer;
            }

            .nav-li a:hover{
                transition: color 0.3s;
                font-size: 18px;
                color: crimson;
            }
            .nav-li svg{
                /* position:absolute; */
                float: left;
                width: 35%;
                height: 35%;
                /* bsolute; */
                /* float: right; */
                top:50%;
                transform: translateY(10%);
                /* background-color: brown; */
            }
            .nav-li-sub{
                float: right;
            }

            /* 定位。返回顶部 */
            #be-local{
                position: fixed;
                width: 40px;
                height: 40px;
                border-radius: 20px;
            }

            #bottom-msg {
                /* position: fixed; */
                /* bottom: 0; */
                width: 100%;
                height: 200px;
                /* background-color: #888; */
                background-color: #a92e30;
                z-index: 1;
            }


            /* 底部 */
            #bottom-msg .raliway-link {
                float: right;
                width: 80%;
                height: 100%;
            }

            #bottom-msg .raliway-link li {
                float: left;
                margin-top: 5px;
                margin-left: 20px;
                margin-right: 20px;
                list-style: none;
            }

            #bottom-msg .raliway-link li p {
                margin-top: 10px;
            }

            h3 {
                font-size: 16px;
            }

            a {
                text-decoration: none;
                font-size: 14px;
                color: #ddd;
            }
            #two-D-code {
                float: left;
                width: 150px;
                height: 150px;
                /* background-color: darkviolet; */
                margin-left: 300px;
                margin-top: 20px;
            }


            #home-img{
                width: 100%;
                height: 376px;
            }
            #home-img img{
                width: 100%;
                height: 100%;
            }
            #message{
                width: 100%;
                height: 2000px;
                /* background-color: blueviolet; */
            }

            #text-area{
                width: 100%;
                height: 200px;
                /* background-color: darkgoldenrod; */
            }

            #find-box{
                position: relative;
                width: 700px;
                height: 350px;
                /* background-color: darkcyan; */
                margin-left: 10px;
                left: 50%;
                transform: translateX(-58%);
            }

            #find-box-sub{
                position: absolute;
                width: 350px;
                height: 250px;
                background-color: #fff;
                /* background-color: violet; */
                left: 50%;
                transform: translateY(-20px);
                transform: translateX(-50%);
                margin-left: 20px;
                margin-top: -20px;
                border-radius: 10px;
                box-shadow: 0 0 12px #333;

            }
            #find-box-sub .sub-div{
                border-bottom: solid 1px #666;
            }
            #seach-left{
                position: relative;
                margin: 20px;
                height: 60%;
                top:30%;
                transform: translateY(-30%);        }
            #seach-title{
                height: 60px;
                /* border-bottom: solid 1px #666; */
            }
            #seach-logo{
                margin-top: 10px;
                display: inline-block;
                width: 40px;
                height: 40px;
                position: absolute;
                left: 50%;
                transform: translateX(-50%);
                border-radius: 20px;
                /* background-color: rgb(214, 27, 27); */
            }
            #seach-logo svg{
                width: 39px;
                height: 39px;
                margin: 0;
            }
            #seach-left .seach-boxs{
                margin-top: 10px;
                font-size: 26px;
                width: 150px;
                height: 40px;
                /* background-color: rgba(255, 255, 255, 0); */
                border: 0;
                display: inline-block;
                text-align: center;
            }
            #seach-left .seach-boxs:focus{
                border: 0;
                /* 去除获取焦点时的边框 */
                outline: none;
            }
            #seach-start{
                float: left;
            }
            #seach-end{
                float: right;
            }

            #seach-time{
                width: 150px;
                height: 40px;
                border:0;
                font-size: 16px;
                text-align: center;
            }

            #seach-sub{
                position: relative;
                margin: 30px auto 5px auto;
                width: 200px;
                height: 40px;
                background-color: #0272e9;
                left: 50%;
                border: 0;
                color: #fff;
                font-size: 16px;
                border-radius: 10px;
                transform: translateX(-50%);
            }
        </style>
    </head>

    <body>
        <div class="nav-bar">
            <div id="logo">
                <img src="https://img10.360buyimg.com/img/jfs/t1/173986/30/16214/17745/60d1f5faE34f88ffc/91fea764dbbdd6e7.gif" />
            </div>
            <div class="top-nav">
                <ul>
                    <li id="home" class="nav-li">
                        <div>
                            <div>
                                <?xml version="1.0" encoding="UTF-8"?>
                                <?xml version="1.0" encoding="UTF-8"?>
                                <svg width="20" height="20" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <rect width="48" height="48" fill="white" fill-opacity="0.01"/>
                                    <path d="M9 18V42H39V18L24 6L9 18Z" fill="none"/>
                                    <path d="M9 42V18L4 22L24 6L44 22L39 18V42H9Z" stroke="#666" stroke-width="4" stroke-linecap="square" stroke-linejoin="bevel"/>
                                    <path d="M19 29V42H29V29H19Z" fill="none" stroke="#666" stroke-width="4" stroke-linejoin="bevel"/>
                                    <path d="M9 42H39" stroke="#666" stroke-width="4" stroke-linecap="square"/>
                                </svg>
                            </div>
                            <a href="./home.html">主页</a>
                        </div>
                    </li>
                    <li id="find-ticket" class="nav-li">
                        <div>
                            <div>
                                <?xml version="1.0" encoding="UTF-8"?>
                                <svg width="20" height="20" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg"><rect width="48" height="48" fill="white" fill-opacity="0.01"/>
                                    <path d="M4 7.00012H44" stroke="#666" stroke-width="4" stroke-linecap="square"/>
                                    <path d="M4 23.0001H15" stroke="#666" stroke-width="4" stroke-linecap="square"/>
                                    <path d="M4 39.0001H15" stroke="#666" stroke-width="4" stroke-linecap="square"/>
                                    <path d="M31.5 34.0001C36.1944 34.0001 40 30.1945 40 25.5001C40 20.8057 36.1944 17.0001 31.5 17.0001C26.8056 17.0001 23 20.8057 23 25.5001C23 30.1945 26.8056 34.0001 31.5 34.0001Z" fill="none" stroke="#666" stroke-width="4"/>
                                    <path d="M37 32.0001L44 39.0506" stroke="#666" stroke-width="4" stroke-linecap="square"/>
                                </svg>
                            </div>
                            <a href="./findTicket.html">查票票</a>
                        </div>
                    </li>
                    <li id="buy-ticket" class="nav-li">
                        <div>
                            <div></div>
                            <a href="./buyTicket.html">在线购票</a>
                        </div>
                    </li>
                    <li id="back-ticket" class="nav-li">
                        <div>
                            <div></div>
                            <a href="./backTicket.html">退票</a>
                        </div>
                    </li>
                    <li id="modify-ticket" class="nav-li">
                        <div>
                            <div></div>
                            <a href="./backTicket.html">改签</a>
                        </div>
                    </li>
                    <li id="mine" class="nav-li">
                        <div>
                            <div></div>
                            <a href="./mine.html">个人</a>
                        </div>
                    </li>

                    <li id="login" class="nav-li-sub">
                        <div>
                            <div></div>
                            <a>登录</a>
                        </div>
                    </li>
                    <li id="register" class="nav-li-sub">
                        <div>
                            <div></div>
                            <a>注册</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div style="height: 45px;width: 100%;"></div>
        <div id="home-img">
            <img src="http://images.wenming.cn/web_wenming/images/rlqzxzgcl20210406-11.jpg" />
        </div>
        <div id="be-local">
            <?xml version="1.0" encoding="UTF-8"?>
            <svg width="40" height="40" viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg">
                <g>
                    <rect width="48" height="48" fill="white" fill-opacity="0.01" stroke-linejoin="bevel" stroke-width="4" stroke="none" fill-rule="evenodd"/>
                    <g transform="translate(4.000000, 4.000000)">
                        <path d="M20,38 C32,38 34,27.5323633 34,24 C34,20.837862 34,16.1711953 34,10 L6,10 C6,13.442296 6,18.1089627 6,24 C6,27.450596 8,38 20,38 Z" stroke="#666" fill="none" fill-rule="nonzero" stroke-linejoin="bevel" stroke-width="4"/>
                        <path d="M3.55271368e-15,4 L6,10" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M40,4 L34,10" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M0,23 L6,23" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M40,23 L34,23" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M3,40 L9,34" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M37,40 L31,34" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M20,38 L20,10" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M10.920475,35.0408965 C13.002464,36.7831828 15.9245088,38 20,38 L20,38 C24.1112534,38 27.0487287,36.7713317 29.1341392,35.0138386" stroke="#666" stroke-linecap="square" stroke-linejoin="bevel" stroke-width="4" fill="none" fill-rule="evenodd"/>
                        <path d="M28,8.33333333 C28,3.73096042 24.418278,0 20,0 C15.581722,0 12,3.73096042 12,8.33333333 L12,10 L28,10 L28,8.33333333 Z" stroke="#666" fill="none" fill-rule="nonzero" stroke-linejoin="bevel" stroke-width="4"/>
                    </g>
                </g>
            </svg>
        </div>
        <div id="message">
            <!-- <div id="text-area"></div> -->
            <div id="find-box">
                <div id="find-box-sub">
                    <div id="seach-left">
                        <form>
                            <div id="seach-title" class="sub-div">
                                <!-- 输入开始位置 start_city-->
                                <input type="text" class="seach-boxs" name="start_city" id="seach-start" value="北京" autocomplete="off" required>
                                <!-- 单击logo交换位置 -->
                                <div id="seach-logo">
                                    <svg t="1624677328137" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2418" width="48" height="48">
                                        <path d="M25.6 524.8a499.2 499.2 0 1 0 998.4 0 499.2 499.2 0 1 0-998.4 0z" fill="#36A5F5" p-id="2419">
                                        </path>
                                        <path d="M704 755.2c-83.2-6.4-147.2-19.2-147.2-102.4v-57.6c0-19.2 44.8-38.4 64-38.4v-89.6c0-6.4-6.4-6.4-6.4-6.4H441.6c-6.4 0-6.4 6.4-6.4 6.4v89.6c19.2 0 64 19.2 64 38.4v57.6c0 83.2-64 102.4-153.6 102.4V800c0 6.4 6.4 6.4 6.4 6.4h339.2c6.4 0 6.4-6.4 6.4-6.4l6.4-44.8z" fill="#FFFFFF" p-id="2420">
                                        </path>
                                        <path d="M576 230.4v-25.6c0-6.4-6.4-6.4-6.4-6.4h-96c-6.4 0-6.4 6.4-6.4 6.4v32c-121.6 25.6-211.2 128-211.2 256 0 89.6 44.8 172.8 115.2 224l25.6-83.2c-38.4-32-64-83.2-64-140.8 0-108.8 83.2-192 192-192s192 83.2 192 192c0 57.6-25.6 108.8-70.4 147.2l25.6 76.8c70.4-51.2 115.2-128 115.2-224 6.4-128-89.6-236.8-211.2-262.4z" fill="#FFFFFF" p-id="2421">
                                        </path>
                                    </svg>
                                </div>
                                <!-- 输入到达位置 end_city-->
                                <input type="text" class="seach-boxs" name="end_city" id="seach-end" value="上海" autocomplete="off" required>
                            </div>
                            <div class="sub-div">
                                <!-- 选择出发时间start_date -->
                                <input type="date" name="start_date" id="seach-time" required>
                            </div>
                            <div class="sub-div">
                                <input type="submit" id="seach-sub" value="查询车票">
                            </div>
                        </form>
                    </div>
                </div>
                <div id="seach-right">
                    <div id="find-ticket-panel"></div>
                    <div id="buy-ticket-panel"></div>
                </div>
            </div>
            <div id="sub">
                <div id="sub-top"></div>
                <div id="sub-bottom"></div>
            </div>
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
                        <img src='http://localhost:8080/raliway12307/img/-6a34e7f5552a5041.jpg'>
                    </div>
                </ul>
            </div>
        </div>

        <script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
        <script>
            // 开始位置
            var seach_start = document.getElementById("seach-start");
            // 到站位置
            var seach_end = document.getElementById("seach-end");
            // 之间的logo，交换开始到站位置
            var seach_logo = document.getElementById("seach-logo");
            $("#seach-logo").click(function(){
                var star=seach_start.value;
                seach_start.value=seach_end.value;
                seach_end.value=star;
            });
            // 出发日期
            var seach_time=document.getElementById("seach-time");
            // 提交按钮
            var submit_seach=document.getElementById("seach-sub");


            var step3=document.getElementById("step-3");
            var step4=document.getElementById("step-4");




            $('#find-ticket').click(function () {
                $('html,body').animate({
                    scrollTop: $('#my-message').offset().top - 140
                }, 600);
            });
            $('#buy-ticket').click(function () {
                $('html,body').animate({
                    scrollTop: $('#manager-shenqing').offset().top - 140
                }, 600);
            });
            $('#account-safe-bar input').click(function () {
                $('html,body').animate({
                    scrollTop: $('#account-safe').offset().top - 140
                }, 600);
            });
        </script>
    </body>

</html>
