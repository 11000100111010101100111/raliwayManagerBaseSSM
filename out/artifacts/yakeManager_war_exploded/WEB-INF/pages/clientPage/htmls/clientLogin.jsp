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
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/unifiStyle.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/login.css">
    <title>铁路12307用户登录</title>
    <style>
        body{
            background: url('http://localhost:8080/raliway12307/img/homeImg/train_02.jpg') no-repeat;
            background-size: 100% auto;
        }
        .Bigbox{
            background-color: rgba(255,255,255,0.65);
            width: 350px;
            height: 455px;
            box-shadow: 0 0 80px rgb(153 121 76);
        }
        .Bigbox div img{
            transform: translateX(90%);

        }
        #register {
            float: right;
            width: 60px;
            height: 30px;
            border-radius: 15px;
            border: 0;
        }
        #register:hover{
            transition: 0.5s;
            box-shadow: 0 0 12px darkslateblue;

        }
    </style>
<body>
<div class="Bigbox">

    <svg id="hi" t="1620881830154" class="icon" viewBox="0 0 1024 1024" version="1.1"
         xmlns="http://www.w3.org/2000/svg" p-id="4955" width="32" height="32">
        <path d="M526.3 488.9l-142.8 0.3c-0.2 0-0.3-0.1-0.3-0.3l19.2-156c0-0.2-0.1-0.3-0.3-0.3l-71.1 0.2c-0.1 0-0.2 0.1-0.3 0.2l-44 357.4c0 0.2 0.1 0.3 0.3 0.3l71.1-0.2c0.1 0 0.2-0.1 0.3-0.2l16.5-133.8c0-0.1 0.1-0.2 0.3-0.2L518 556c0.2 0 0.3 0.1 0.3 0.3L501.8 690c0 0.2 0.1 0.3 0.3 0.3l71.1-0.2c0.1 0 0.2-0.1 0.3-0.2l44-357.4c0-0.2-0.1-0.3-0.3-0.3l-71.1 0.2c-0.1 0-0.2 0.1-0.3 0.2l-19.2 156.1c0 0.1-0.1 0.2-0.3 0.2zM645.4 690l71.1-0.2c0.1 0 0.2-0.1 0.3-0.2L747 444c0-0.2-0.1-0.3-0.3-0.3l-71.1 0.2c-0.1 0-0.2 0.1-0.3 0.2l-30.2 245.5c0 0.2 0.2 0.4 0.3 0.4zM870 781.4c63.6-69 90-168.3 90-269.4 0-273.5-245.1-489.8-527.6-441.1C263.4 100 100 263.4 70.9 432.4 22.2 714.9 238.5 960 512 960h358.1c0.1 0 0.3-0.1 0.3-0.3-0.1-7.6-2.3-176.3-0.4-178.3z m-67.1 111.4h-288c-225.5 0-399.2-184.2-382.7-409.1 14.5-197.1 179-352.5 379.8-352.5 210.3 0 380.8 170.5 380.8 380.8 0 81.8-26.2 157.2-69.7 219.6-24.5 35.2-20.2 154.5-19.9 160.9 0 0.2-0.1 0.3-0.3 0.3zM725 332c-19.8 0-37.7 15.1-40 33.6-2.3 18.5 11.9 33.5 31.7 33.5 19.8 0 37.7-15.1 40-33.6 2.3-18.6-11.9-33.6-31.7-33.5z"
              fill="#0E0E0E" p-id="4956"></path>
    </svg>
    <div>
        <img src="http://localhost:8080/raliway12307/img/clientImg/login.png" id="img" >
    </div>


    <label class="child">账号:</label>
    <input class="child padding-class" style="height: 30px;border-radius: 10px;" type="text" id="txt" name="client_id" placeholder="请输入账号" autocomplete="off" onblur="blur()" onfocus="focus()">

    <label class="child" >密码:</label>

    <div class="check">
        <div class="child padding-class" id="checkbox1" onclick="ck1()">
            <svg id="gou" t="1620880513442" class="icon" viewBox="0 0 1024 1024" version="1.1"
                 xmlns="http://www.w3.org/2000/svg" p-id="2493" width="16" height="16" style="visibility: hidden;">
                <path d="M289.0752 475.3408l138.3424 263.0656c0 0 224.768-534.6304 579.2768-712.9088-8.6016 127.2832-43.2128 237.568 17.3056 373.3504-155.648 33.8944-475.5456 415.8464-579.2768 602.5216C297.6768 823.296 124.7232 687.5136 3.6864 645.12L289.0752 475.3408z"
                      fill="#707070" p-id="2494"></path>
            </svg>
        </div>

        <p class="child" style="visibility: hidden">show:</p>

    </div>

    <input class="child padding-class" style="height: 30px;border-radius: 10px;"  type="password" id="password" name="password" placeholder="请输入密码" autocomplete="off" onfocus="pwds()">
    <button class="child" id="submit" onclick="funx()" >登  录</button>
    <button class="child" id="register" >注册</button>
</div>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>

<script src="http://localhost:8080/raliway12307/js/managerJs/login.js"></script>

</body>

</html>
