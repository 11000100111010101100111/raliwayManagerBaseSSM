<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=drive-width,initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="http://localhost:8080/raliway12307/img/train_ico.ico" type="image/x-icon">
    <link rel="stylesheet" href="http://localhost:8080/raliway12307/css/managerCss/login.css">
    <title>管理员登录</title>
    <style>
        body{
            background: url('http://localhost:8080/raliway12307/img/homeImg/train_01.jpg') no-repeat;
        background-size: 100% auto;
        }

        #login-box{
            /*filter:blur(2px);*/
            /*-webkit-filter:blur(2px);*/
            /*float: left;*/
            width: 30%;
            height: 320px;
            margin: 0 auto;
            margin-top: 15%;
            text-align: center;
            background: rgba(250,250,250,0.30);
            padding: 20px 50px;
            border-radius: 20px;
            box-shadow: 0 0 12px darkslateblue;
            /*display: inline-b/lock;*/
        }
        /*#login-box{*/
        /*    z-index: 99;*/
        /*    transform: translateX(70%);*/
        /*}*/
        #login-box h1{
            color: #000;
            font-size: 24px;
        }
        #login-box .form .item input{
            margin-top: 45px;
        }
        #login-box .form i{
            font-size: 18px;
            color: #fff;
        }
        #login-box .form .item input {
            width: 80%;
            font-size: 18px;
            text-align: center;
            border: 0;
            border-bottom: 1px solid #999;
            padding: 5px 10px;
            background:#fff;
            border-radius: 10px;
            color: #000;
        }
        #login-box .form .item input:focus{
            border: 0;
            outline: none;
        }
        #login-box .form .item input:hover{
            transition: 0.5s;
            outline: none;
            box-shadow: 0 0 12px darkslateblue;
        }
        #login-box button{
            margin-top: 45px;
            width: 180px;
            height: 35px;
            font-size: 20px;
            font-weight: 700;
            color: #fff;
            background:linear-gradient(to right,#f30909 0%,#4013e6e1 100%);
            border: 0;
            border-radius: 15px;
        }
        #login-box button:hover{
            transition: 0.3s;
            box-shadow: 0 0 12px darkslateblue;
        }
        a{
            display: inline-block;
            float: right;
            margin-bottom: 5px;
            border-radius: 20px;
            width: 50px;
            height: 15px;
            color: white;
            text-align: center;
            outline-style: none;
            background-color: #fff;
            padding: 5px;
            color: #000;
            border: solid 1px darkslateblue;

        }
        a:hover{
            transition: 0.5s;
            background-color: #43376e;
            color: white;
            box-shadow: 0 0 12px darkslateblue;
        }
    </style>
</head>

<div id="login-box">
    <h1>管理员登录</h1>
    <div class="form">
        <div class="item">
            <i class="fa fa-user-circle-o" aria-hidden="true"></i>
            <input type="text" placeholder="请输入账号" id="txt" autocomplete="off">
        </div>
        <div class="item">
            <i class="fa fa-key" aria-hidden="true"></i>
            <input type="password" placeholder="请输入密码" id="password" autocomplete="off">
        </div>
        <button onclick="funx()">登录</button>
    </div>
    <a href=" http://localhost:8080/raliway12307/raliway/toRegister">注册</a>
</div>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
<script>


    var pwd = document.getElementById("password");
    var txt = document.getElementById("txt");

    var flage = 0;

        function funx() {

        var data ={client_id:txt.value,password:password.value};

        if($("#password").val() != "" && $("#txt").val() != "") {
        $.ajax({
        type: "post",
        url: "http://localhost:8080/raliway12307/login/clientLogin",
        dataType: "json",
        data: data,
        success: function (data) {

        if (data === 200) {
        alert("登录成功！");
            document.location.href = "http://localhost:8080/raliway12307/managerHome";
        }
        else if(data === -1 ){
        if(confirm("账号："+txt.value+"  不存在！是否去注册？")){
            document.location.href = "http://localhost:8080/raliway12307/raliway/toRegister";
        }
        }
        else{
        alert("账号或密码输入有误！");
        }
        }
        });
        }
        else {
        alert("输入不能为空！")
        }
        }

        // $("#register").click(function () {
        //     document.location.href = "http://localhost:8080/raliway12307/raliway/toRegister";
        // });
</script>
<body>
</body>
</html>


