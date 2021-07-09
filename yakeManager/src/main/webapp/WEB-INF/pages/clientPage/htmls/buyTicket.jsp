<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <link rel="icon" href="http://localhost:8080/raliway12307/img/train_ico.ico">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/clientCss/buyTicket.css">
    <title>铁路12307淘票</title>
    <style>

    </style>
</head>
<body>
<div id="left-panel">
    <div id="img" style="background: url('${client_avator}')  no-repeat; background-size: 100% 100%;"></div>
    <p id="name">海子哥</p>
    <p id="gexingqianmi">个性签名：这个人什么都没有写</p>
    <p id="user-type">我是：学生</p>
    <p id="phone">phone：15770674965</p>
    <p id="email">邮箱：2749984520@qq.com</p>
    <p id="ic">海子哥</p>
    <input style="width: 0;height: 0;visibility: hidden;" id =  "client_id" value="${client_id}">

</div>
<div id="right-panel" style="overflow: auto;">
    <div id="input-bar">
        <div id="top-imgarea" >
            <!-- //显示当前时间 -->
            <div id="show_time" >
                <script>
                    setInterval("show_time.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
                </script>
            </div>
            <!-- <img src="" alt=""> -->
        </div>

        <div id="bottom-inputarea">
            <div>
                <p>输入出发地区（省/市/区）：</p>
                <input type="text" placeholder="从哪出发？" id="start-area" value="${start_station}" autocomplete="off" >
            </div>

            <div>
                <p>输入目的地（省/市/区）：</p>
                <input type="text" placeholder="到哪里去？" id="end-area" value="${end_station}" autocomplete="off" >
            </div>

            <div>
                <p>选择出发日期：</p>
                <input type="date" id="start-time" value="${time}">
            </div>
            <button style="width: 100px;height: 30px;" id="submit-but">确定</button>
        </div>
    </div>
    <div id="ticket-table" >
        <div id="pick-message" style="position: fixed;z-index: 99;">
            <div class="sub-box">
                <div id="close" onclick="close_ticketpanel()">
                    <svg t="1624727498413" class="icon" viewBox="0 0 1051 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2373" width="48" height="48">
                        <path d="M656.412 507.821l300.087-292.172a92.077 92.077 0 0 0 0-132.76 98.221 98.221 0 0 0-136.358 0L520.026 375.005 219.994 82.89a98.221 98.221 0 0 0-136.386 0 92.077 92.077 0 0 0 0 132.76l300.088 292.17L83.58 799.993a92.077 92.077 0 0 0 0 132.76c18.072 17.602 42.62 27.538 68.192 27.455 25.573 0 50.093-9.853 68.193-27.455l300.06-292.172 300.087 292.172c18.045 17.602 42.593 27.538 68.165 27.455 25.573 0 50.121-9.853 68.193-27.455a92.077 92.077 0 0 0 0-132.76L656.41 507.821z" p-id="2374" fill="#d81e06">
                        </path>
                    </svg>
                </div>
                <div id="u-msg" class="ticks-panel pick-top">
                    <div id="u-img" class="pick-top" style="background: url('${client_avator}')  no-repeat; background-size: 100% 100%;"></div>
                    <div class="pick-top u-msg-box" >
                        <p id="u-name">${client_name}</p>
                        <p id="u-id">${client_id}</p>
                        <p id="u-type">${client_type}</p>
                        <p id="u-ic">${client_ic}</p>
                        <p id="u-pho">${client_phone}</p>
                    </div>
                </div>
                <div id="ticket-msg" >
                    <div class="pick-top pt-1 pt1-1">
                        <ul>
                            <li>车次</li>
                            <li>发车/到站</li>
                            <li>发车时间</li>
                            <li>选座</li>
                            <li>应付金额</li>
                        </ul>
                    </div>
                    <div class="pick-top pt-1 pt1-2">
                        <ul id="tic-msgs ">
                            <li>
                                <p id="ticket-train-id">G2312</p>
                            </li>
                            <li>
                                <div>
                                    <p id="s-station" class="li-left" style="display: inline;">南昌站</p>
                                    <p id="e-station" class="li-right"style="display: inline;">上海虹桥</p>
                                </div>
                            </li>
                            <li>
                                <div>
                                    <p id="s-time" class="li-left" style="font-size: 12px;display: inline;">2020-6-30&nbsp;&nbsp;6:12:52</p>
                                    <p id="e-time" class="li-right" style="font-size: 12px;display: inline;">2020-6-30&nbsp;&nbsp;13:00:52</p>
                                </div>
                            </li>
                            <li>
                                <select id="seat-type" style="width: 200px;height: 30px;">
                                    <option value="1">一等座</option>
                                    <option value="2">二等座</option>
                                    <option value="3">硬卧</option>
                                    <option value="4">硬座</option>
                                    <option value="5">无座</option>
                                </select>
                            </li>
                            <li>
                                <p id="money">￥562.00元</p>
                            </li>
                        </ul>
                    </div>
                </div>
                <input type="button" id="buy-ticket" value="立即下单">
            </div>
        </div>
        <table id="tab">
            <tr>
                <th>车次</th>
                <th class="exe-td">起点站</th>
                <th class="exe-td">到达站</th>
                <th>商务座</th>
                <th>软卧</th>
                <th>硬卧</th>
                <th>一等座</th>
                <th>二等座</th>
                <th>硬座</th>
                <th>无座</th>
                <th>备注</th>
            </tr>
            <!-- <tr>
                <td>G2312</td>
                <td class="exe-td">
                    <div>
                        <p >南昌西</p>
                        <p >2020-7-1&nbsp;&nbsp;6:12:00</p>
                    </div>
                </td>
                <td class="exe-td">
                    <div>
                        <p >上海虹桥</p>
                        <p >2020-7-1&nbsp;&nbsp;10:12:00</p>
                    </div>
                </td>
                <td>12</td>
                <td>56</td>
                <td>无</td>
                <td>无</td>
                <td>无</td>
                <td>85</td>
                <td>10</td>
                <td>
                    <a href="#">去购买</a>
                </td>
            </tr> -->
        </table>
    </div>
</div>
<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
<!--                                                          这里有链接-->
<!--    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
<%--<script src="http://localhost:8080/raliway12307/js/importJq/jquery-3.6.0.min.js"></script>--%>
<script src="http://localhost:8080/raliway12307/js/managerJs/all.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/railwayOperator.js"></script>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/clientJs/buyTicket.js"></script>
<!--    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
</body>
</html>
