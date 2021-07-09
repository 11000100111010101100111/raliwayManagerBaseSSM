<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 19:40
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
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/clientCss/backTicket.css">
    <title>铁路12307在线退改签</title>
    <style>
        body::-webkit-scrollbar{
            display:none;
        }
    </style>
</head>
<body>
<div>
    <div id="back-tick-service" class="message-mine">

        <div id="msg-lan">
            <div id="msg-lan-img"></div>
            <div style="width: 100%;display: inline-block;">
                <p style="width: 0;height: 0;visibility: hidden;" id =  "client_id">${client_id}</p>
                <p class="inline-block-elem"  style="margin-left: 20px;">用户${client_id},欢迎来到退票管理！</p>
<%--                ${ticket_num}--%>
                <p  class="inline-block-elem" id="tickets-nums" style="font-size: 14px;margin-right: 10px;color: #fff;width: 10%;">已购买火车票如下：</p>
<%--                <p  class="inline-block-elem" style="font-size: 22px;width: 50%;text-align: center;transform: translateY(5px) translateX(175px);">您已购买的火车票列表如下</p>--%>
                <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
                <form action="http://localhost:8080/raliway12307/raliway/modify" method="GET" class="inline-block-elem">
                    <!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
                    <input class="inline-block-elem" id="tickets-id-nums" name="ticketNO" type="text" style="visibility: hidden;width: 50%;">
                    <div class="inline-block-elem">
<%--                        <input type="submit" class="modify-tickets-but back-tickets-but" id='modify-button' value="去改签">--%>
                    </div>
                </form>
                <div id="sureto-back-tickte" >
                    <div class="box-two">
                        <div id="sure-1" >
                            <h3 style="font-size: 16px;">确认退票：G2312次？</h3>
                        </div>
                        <div  id="sure2">
                            <h2 id="sure-2-start">上海虹桥</h2>
                            <div id="sure-21">
                                <h5>发往</h5>
                                <!--////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
                                <img src="http://localhost:8080/raliway12307/img/clientImg/icon_go.png">
                                <!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
                            </div>
                            <h2 id="sure-2-end">南天门</h2>
                        </div>
                        <div id="sure-3">
                            <p>订单编号：5555555555555555</p>
                        </div>
                        <div id="sure-4">
                            <p>发车时间：2021年6月29日&nbsp;&nbsp;16:55:00</p>
                        </div>
                        <div id="sure-5">
                            <p>￥：456.00元</p>
                        </div>
                        <div id="sure-6">
                            <input type="button" id="sureto-back-bt" value="确认退票">
                        </div>
                        <div class="close">
                            <input type="button" id="close-bt" value="关闭">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 占位 -->
        <div style="width: 100%;height: 265px;" ></div>
        <!-- 退票/改签 -->
        <div id="tickets-box">
            <ul id="uls">
            </ul>
        </div>
        <div id="no-tickets" style="width: 100px;height: 200px;border-radius: 20px;top: 500px;left:50%;position: absolute;transform: translateX(-50%);display: none;">
            <h1 style="width: 100%;text-align: center;margin-top: 80px;">暂无购票记录</h1>
        </div>
    </div>

</div>



<!--//////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
<!--    //////////////////////////////////////////////////////////////////////////////////////////////////////////////-->


<script src="http://localhost:8080/raliway12307/js/importJq/jquery-3.6.0.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/all.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/railwayOperator.js"></script>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/clientJs/backTicket.js"></script>
<!--    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
<!--    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

<script>

</script>
</body>
</html>
