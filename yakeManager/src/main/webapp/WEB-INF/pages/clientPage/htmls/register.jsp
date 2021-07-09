<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/7/3
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="http://localhost:8080/raliway12307/img/train_ico.ico" type="image/x-icon">
    <title>用户注册</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            background: url("http://localhost:8080/raliway12307/img/homeImg/train_12.jpg") no-repeat;
            background-size:100% 100%;
        }
        #box{
            position: absolute;
            width: 33%;
            height: 70%;
            top: 50%;
            left: 50%;
            transform: translateY(-50%) translateX(15%);
            border-radius: 20px;
            box-shadow: 0 0 40px #439ba4;
            background-color: rgba(255,255,255,0.3);
        }
        #box .msg{
            width: 80%;
            height: 30px;
            margin-top: 10px;
            margin-left: 10%;
            border: none;
            text-align: center;
            font-size: 18px;
            outline: none;
            border-radius: 5px;
            margin-bottom: 5px;
            border-bottom: solid 1px darkslateblue;

        }
        #box .msg:hover{
            transition: 0.5s;
            box-shadow: 0 0 12px darkslateblue;
            border-bottom: solid 1px #fff;
        }
        #box input[type='button']{
            width: 36%;
            height: 35px;
            border-radius: 10px;
            border: solid 0px darkslateblue;
            margin-left: 32%;
            margin-top: 30px;
            font-size: 18px;
        }
        #box input[type='button']:hover{
            transition: 0.5s;
            background-color: #dc841d;
            box-shadow: 0 0 12px #d69c45;
            color: #fff;
        }
        #sub-box{
            width: 90%;
            height: 90%;
            margin-left: 5%;
        }
        h1{
            margin-top: 30px;
            width: 100%;
            text-align: center;
            margin-bottom: 10px;
            border-bottom: solid 1px #666;
            padding-bottom: 10px;
        }
    </style>
</head>
<body>
<div id="box">
    <div id="sub-box">
        <h1 >填写注册信息</h1>
        <form >
            <input type="text" class="msg" autocomplete="off" id ="u_id" placeholder="请输入账号" onblur="id_msg(this)">
            <input type="tel"  class="msg" autocomplete="off" id ="u_phone" placeholder="请输入电话号码" onblur="tel_phone(this)">
            <input type="text" class="msg" autocomplete="off" id ="u_email" placeholder="请输入电子邮箱">
            <input type="text" class="msg" autocomplete="off" id ="u_name" placeholder="请输入您的名称">
            <input type="text" class="msg" autocomplete="off" id ="u_ic"  placeholder="请输入身份证号码" onblur="user_ic(this)">
            <select class="msg" id ="u_type" style="text-align: center;">
                <option value="-请选择你的用户类型-" selected disabled="disabled" style="color: #aaa;">-请选择你的用户类型-</option>
                <option value="退伍军人">退伍军人</option>
                <option value="学生">学生</option>
                <option value="儿童">儿童</option>
                <option value="成人">成人</option>
                <option value="优待对象">优待对象</option>
                <option value="VIP">VIP</option>
            </select>
            <input type="text" class="msg" autocomplete="off" id ="u_ava" placeholder="请输入你的个性签名" onblur="text_len(this)">
            <input type="button" value="提 交" onclick="submit_msg()">
        </form>
    </div>
</div>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
<script>
    function submit_msg() {
        var id=document.getElementById("u_id").value;
        var phone=document.getElementById("u_phone").value;
        var email=document.getElementById("u_email").value;
        var name=document.getElementById("u_name").value;
        var ic=document.getElementById("u_ic").value;
        var type=$("#u_type").find("option:selected").text();
        var ava=document.getElementById("u_ava").value;
        // alert(phone + "+" +id +"+"+email +"+"+name+"+"+ type);
        if(phone !== "" && id !== "" && email !== "" && name!== "" && type !== "-请选择你的用户类型-"){
            var data={
                client_phone:phone,
                client_id:id,
                client_email:email,
                client_name:name,
                client_ic:ic,
                client_type:type,
                signature:ava,
            };
            $.ajax({
                type: "post",                //数据提交方式（post）
                url: "http://localhost:8080/raliway12307/getData/register", //提交的数据
                dataType: "json",           //返回的数据类型格式
                data:data,
                success: function (data) {

                    if(data === 200){
                        if (confirm("注册成功！立即去登录？")){
                            document.getElementById("u_id").innerHTML="";
                            document.getElementById("u_phone").innerHTML="";
                            document.getElementById("u_email").innerHTML="";
                            document.getElementById("u_name").innerHTML="";
                            document.getElementById("u_ic").innerHTML="";
                            document.getElementById("u_ava").innerHTML="";
                            document.location.href="http://localhost:8080/raliway12307/raliway/noUser";
                        }
                    }else{
                        alert("注册失败，服务器为链接！")
                    }
                }
            });
        }else{
            alert("输入内容不能为空！");
        }
    }
    function tel_phone(str) {
        var valid_rule = /^(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}$/;
        if (str.value!=="" &&  !valid_rule.test(str.value)){
            alert("输入的内容不符合标准电话号吗格式！");
            str.value="";
            //
        }else{

        }
    }
    function id_msg(str) {
        if (str.value !== "" &&  isNaN(str.value) ){
            alert("请输入9位数字构成的账号！");
            str.value="";
        }else{
            $.ajax({
                type: "post",                //数据提交方式（post）
                url: "http://localhost:8080/raliway12307/getData/hasUserById", //提交的数据
                dataType: "json",           //返回的数据类型格式
                data:{client_id:str.value},
                success: function (data) {
                    if(data !== 0){
                        alert("账号已存在！");
                        str.value="";
                    }
                }
            });
        }
    }
    function text_len(str) {
        if (str.value!=="" && str.value.length > 16){
            alert("输入标签太长了！这个个性签名不行！"+str.value.length);
            str.value="";
        }
    }
    function user_ic(str) {
        if(str.value!=="" && ! /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(str.value) ){
            alert("输入身份证号码格式不正确！")
            str.value="";
        }
    }
</script>
</body>
</html>
