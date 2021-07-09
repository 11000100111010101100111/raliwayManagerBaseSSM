<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/24
  Time: 9:15
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

    <title>涯客后台服务</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background-color: #666;
        }
        .box{
            position: absolute;
            width: 300px;
            height: 400px;
            top:50%;
            left: 75%;
            transform: translateX(-50%) translateY(-50%);
            box-shadow: 0 0 12px pink;
            border-radius: 10px;
        }
        .box h1{
            font-size: 48px;
            color: pink;
            width: 300px;
            text-align: center;
            margin: 20px 0 20px 0;
        }
        .box input{
            width: 200px;
            height: 30px;
            font-size: 18px;
            margin: 20px 50px 20px 50px;
            border: 0;
        }
        .box input:focus{
            box-shadow: 0 0 12px pink;
        }
        .box input[type="submit"]{
            background-color: #555;
            width: 150px;
            height: 40px;
            font-size: 22px;
            color: pink;
            border-radius: 8px;
            margin: 20px 75px 20px 75px;
            transition: 0.3s;
        }
        .box input[type="submit"]:hover{
            box-shadow: 0 0 12px pink;
        }
    </style>
</head>
<body>
<div class="box">
    <h1>登录</h1>
    <!--        -->
    <!--        action="http://localhost:8080/manager.com/manager/home"-->
    <form method="post">
        <input type="text" name="client_id" id = "id" required placeholder="输入账号" autocomplete="off" onblur="login_id()"/>
        <input type="password" name="password" id="pwd" required placeholder="输入密码" autocomplete="off"/>
        <input type="submit" value="登  录" onclick="login()"/>
    </form>
</div>
<script src="${pageContext.request.contextPath}/js/importJq/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/managerJs/all.js"></script>
<script>
    var idinput=document.querySelector("#id");
    var password=document.querySelector("#pwd");
    var logindata={uid:"123456",pwd:password};
    var form=document.querySelector("form");
    function login() {
        logindata.uid=idinput.value;
        logindata.pwd=password.value;
        $.ajax({
            url:"${pageContext.request.contextPath}/ajax/login_msg",
            type:"POST",
            data: logindata,
            dataType: "json",
            success:function (data) {
                if("0" === data){
                    alert("登录失败：账号或密码输入有误！");
                    idinput.value="";
                    password.value="";
                }
                else if("2" === data){
                    alert("失败："+idinput.value+"正在登录!");
                }
                else{
                    alert("登陆成功！");
                    form.action="${pageContext.request.contextPath}/manager/home";
                    form.submit();
                }
            },
            error: function (e) {
                alert("error:404:服务器无法连接！");
            }
        });
    }
</script>
</body>
</html>
