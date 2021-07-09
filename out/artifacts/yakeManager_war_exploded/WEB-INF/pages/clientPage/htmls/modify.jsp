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
    <link rel="icon" href="http://localhost:8080/raliway12307/img/train_ico.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>改签</title>
    <style>
        * {
            margin: 0px;
            padding: 0px;
        }

        body {
            width: 100vw;
            height: 100vh;
            position: relative;
        }

        .update_ticket {
            width: 100%;
            height: 100%;
        }

        /* 退票页面的上部分 */
        .update_ticket_top {
            width: 100%;
            height: 35%;
            position: relative;
            box-sizing: border-box;
        }

        /* 导航栏部分 */
        .update_ticket_nav {
            width: 100%;
            height: 45px;
            position: fixed;
            background-color: brown;
        }

        /* 回显的票据信息 */
        .ticket_show {
            width: 90%;
            height: 78%;
            background-color: white;
            box-sizing: border-box;
            margin-left: 5%;
            padding-left: 15px;
            padding-top: 5px;
            border: 1px solid darkslateblue;
        }

        /* 火车票的ID */
        .ticket_Id {
            font-size: 20px;
            color: red;
            font-weight: bold;
        }

        /* 火车起始站名 */
        .station_name {
            font-size: 26px;
            font-weight: bolder;
            margin: 5px 60px;
        }

        .time_price_Id {
            margin-left: 30%;
            font-size: 18px;
            color: #2c2c54;
            margin-top: 5px;
        }

        /* 退票页面的下部分 */
        .update_ticket_bottom {
            width: 100%;
            height: 65%;
            box-sizing: border-box;
            padding: 20px 90px;

        }

        /* 起始的输入框 */
        .btn_box input {
            width: 200px;
            height: 35px;
            outline: none;
            border: 1px solid darkslateblue;
            margin-right: 75px;
            text-align: center;
            font-size: 18px;
        }

        /* 查询的按钮 */
        .select_btn {
            width: 100px;
            height: 35px;
            outline: none;
            border: 1px solid darkslateblue;
            text-align: center;
            font-size: 18px;
        }

        .select_btn:hover {
            background-color: rgba(0, 0, 139, 0.705);
            transition: 0.3s;
            color: white;
            cursor: pointer;
        }

        /* 表格样式 */
        .back_ticket_table {
            width: 100%;
            height: 370px;
            border-collapse: collapse;
            margin-top: 15px;
            border: 1px solid black;
            box-sizing: border-box;
            padding: 10px;
            overflow: hidden;
        }

        .back_ticket_table thead {
            background-color: brown;
            height: 50px;
        }

        .back_ticket_table tbody td {
            text-align: center;
        }

        .back_ticket_table tbody tr {

            border-bottom: 1px solid black;
        }

        .back_ticket_table tbody tr:hover {
            transform: scale(1.01);
            transition: 0.3s;
            background-color: #34e7e4b7;
        }
    </style>
</head>

<body>
<!-- 改签的整个大盒子 -->
<div class="update_ticket">
    <!-- 改签上部分 -->
    <div class="update_ticket_top">
        <!-- 导航栏部分 -->
        <div class="update_ticket_nav">defrvr</div>
        <div style="width: 100%;height: 50px;"></div>
        <!-- 回显的火车票信息 -->
        <div class="ticket_show">
            <p class="ticket_Id">123456987452123654</p>
            <p style="text-align: center;"><span class="station_name">南昌西</span><strong
                    style="font-size: 23px;">G2312</strong>
                <span class="station_name">北京南</span>
            </p>
            <p class="time_price_Id">2021年6月13号 <span style="margin: 0px 40px;">12:36:00</span>开</p>
            <p class="time_price_Id"><span>45.5元</span><span style="margin-left: 45%;">二等座</span></p>
            <p class="time_price_Id">12456987452145236541&nbsp;&nbsp;<span style="margin-left: 15px;">张三</span></p>
            <p style="margin-left: 55%;">铁路12306&nbsp;&nbsp;制</p>
        </div>
    </div>
    <!-- 改签下部分 -->
    <div class="update_ticket_bottom">
        <!-- 选择框区域 -->
        <div class="btn_box">
            <!-- 起始 -->
            <em>起始站：</em>&nbsp;<input type="text" value="南昌西" disabled>
            <!-- 终止 -->
            <em>终点站：</em>&nbsp;<input type="text" value="北京南" disabled>
            <!-- 选择时间 -->
            <em>时间选择：</em>&nbsp;<input type="date">
            <button class="select_btn">查询</button>
        </div>
        <!-- 所有匹配时间的查询结果 -->
        <div>
            <!-- 显示的所有结果 -->
            <table class="back_ticket_table">
                <thead>
                <tr>
                    <th>车次</th>
                    <th>起点站</th>
                    <th>终点站</th>
                    <th>商务座</th>
                    <th>软卧</th>
                    <th>硬卧</th>
                    <th>一等座</th>
                    <th>二等座</th>
                    <th>硬座</th>
                    <th>无座</th>
                    <th>操作</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>G2312</td>
                    <td>南昌西</td>
                    <td>北京南</td>
                    <td>699.00</td>
                    <td>599.00</td>
                    <td>499.00</td>
                    <td>399.00</td>
                    <td>369.00</td>
                    <td>320.00</td>
                    <td>320.00</td>
                    <td><a href="#">购票</a></td>
                </tr>
                <tr>
                    <td>G2312</td>
                    <td>南昌西</td>
                    <td>北京南</td>
                    <td>699.00</td>
                    <td>599.00</td>
                    <td>499.00</td>
                    <td>399.00</td>
                    <td>369.00</td>
                    <td>320.00</td>
                    <td>320.00</td>
                    <td><a href="#">购票</a></td>
                </tr>
                <tr>
                    <td>G2312</td>
                    <td>南昌西</td>
                    <td>北京南</td>
                    <td>699.00</td>
                    <td>599.00</td>
                    <td>499.00</td>
                    <td>399.00</td>
                    <td>369.00</td>
                    <td>320.00</td>
                    <td>320.00</td>
                    <td><a href="#">购票</a></td>
                </tr>
                <tr>
                    <td>G2312</td>
                    <td>南昌西</td>
                    <td>北京南</td>
                    <td>699.00</td>
                    <td>599.00</td>
                    <td>499.00</td>
                    <td>399.00</td>
                    <td>369.00</td>
                    <td>320.00</td>
                    <td>320.00</td>
                    <td><a href="#">购票</a></td>
                </tr>
                <tr>
                    <td>G2312</td>
                    <td>南昌西</td>
                    <td>北京南</td>
                    <td>699.00</td>
                    <td>599.00</td>
                    <td>499.00</td>
                    <td>399.00</td>
                    <td>369.00</td>
                    <td>320.00</td>
                    <td>320.00</td>
                    <td><a href="#">购票</a></td>
                </tr>
                <tr>
                    <td>G2312</td>
                    <td>南昌西</td>
                    <td>北京南</td>
                    <td>699.00</td>
                    <td>599.00</td>
                    <td>499.00</td>
                    <td>399.00</td>
                    <td>369.00</td>
                    <td>320.00</td>
                    <td>320.00</td>
                    <td><a href="#">购票</a></td>
                </tr>
                <tr>
                    <td>G2312</td>
                    <td>南昌西</td>
                    <td>北京南</td>
                    <td>699.00</td>
                    <td>599.00</td>
                    <td>499.00</td>
                    <td>399.00</td>
                    <td>369.00</td>
                    <td>320.00</td>
                    <td>320.00</td>
                    <td><a href="#">购票</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

</html>