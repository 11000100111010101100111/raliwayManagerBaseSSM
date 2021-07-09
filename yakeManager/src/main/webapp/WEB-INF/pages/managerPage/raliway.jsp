<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 波罗的海
  Date: 2021/6/27
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="http://localhost:8080/raliway12307/img/train_ico.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/unifiStyle.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/raliway12307/css/managerCss/raliway.css">
    <title>铁路运营管理</title>
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


<div class="memu-bar">
    <ul>
        <li>
            <h3>菜单栏</h3>
        </li>
        <li>
            <input type="button" id="add-station-bar" value="新增车站" />
        </li>
        <li>
            <input type="button" id="add-raliway-bars" value="新增列车" />
        </li>
        <li>
            <input type="button" id="add-raliwaytimes-bar" value="新增班次" />
        </li>
    </ul>
</div>
<!-- <div class="content"> -->
<div class="page">
    <div class="nothing">
    </div>
    <div class="message-page">
        <!-- 增加火车站 -->
        <div id="add-station" class="add-message">
            <div id="add-station-message">
                <h1>增加火车站</h1>
                <div id="location"  class="station-class">
                    <h5>车站地址：</h5>
<%--                    onblur="province_onblur()"--%>
                    <select id="chiose-province" >
                        <option style="color: #888" disabled selected>选择省份：</option>
<%--                        <option>江西省</option>--%>
<%--                        <option>湖南省</option>--%>
<%--                        <option>湖北省</option>--%>
<%--                        <option>广东省</option>--%>
                        <c:forEach items="${provinces}" var="province">
                            <option value="${province}">${province}</option>
                        </c:forEach>
                    </select>
                    <select id="chiose-city" >
                        <option style="color: #888" disabled selected>选择市/区：</option>
                        <option>吉安市</option>
                        <option>南昌市</option>
                        <option>九江市</option>
                        <option>长沙市</option>
                        <option>武汉市</option>
                    </select>
                    <input type="text" id="write-add" required autocomplete="off" placeholder="填写更多地址信息..." >
                </div>
                <div id="station-name" class="station-class">
                    <h5>车站名称：</h5>
                    <input type="text" required autocomplete="off" placeholder="例如：南昌西" onblur="stationName_onblur() ">
                </div>
                <div id="station-id"  class="station-class">
                    <h5>车站编号：</h5>
                    <input type="text" required autocomplete="off" placeholder="例如：南昌西的id可为ncx" onblur="stationId_onblur() ">
                </div>
                <input type="button" value="提  交" onclick="submit_station_msg()"/>
            </div>
        </div>

        <!-- 增加火车 -->
        <div id="add-raliway" class="add-message">
            <!-- 增加火车 -->
            <div id="add-raliway-bar">
                <div class="rect" id="rect-one">
                    <!-- <div class="cir"></div> -->
                    <button id="write-raliway-id">
                        <div class="cir"></div>
                        填写列车基本信息</button>
                </div>
                <div class="rect" id="rect-two">
                    <!-- <div class="cir"></div> -->
                    <button id="fenpei-chexiang-type">
                        <div class="cir"></div>
                        分配车厢类型</button>
                </div>
                <div class="rect" id="rect-three">
                    <!-- <div class="cir"></div> -->
                    <button id="no-seat">
                        <div class="cir"></div>
                        核对数据</button>
                </div>
<%--                <div class="rect" id="rect-four">--%>
<%--                    <!-- <div class="cir"></div> -->--%>
<%--                    <button id="submit">--%>
<%--                        <div class="cir"></div>--%>
<%--                        提交结果</button>--%>
<%--                </div>--%>
            </div>
            <div id="add-raliway-panels">
                <!-- 第一步填写列车基本信息 -->
                <div class="steps" id="step-1">
                    <div class="arg"></div>
                    <div id="basemessage-panel">
                        <div id="train-type" class="chiose-contrain">
                            <p class="block-elemt">选择新增列车类型(如：G)：</p>
                            <p class="necessary block-elemt">*</p>
                            <select name="select-traintype" id="train-type-text" class="block-elemt">
                                 <option value="1" style="color: #888" disabled selected>选择列车类型：</option>

                                <c:forEach items="${traintypes}" var="traintype">
                                    <option value="${traintype}">${traintype}</option>
                                </c:forEach>

                            </select>
                        </div>

                        <div id="train-id" class="chiose-contrain">
                            <p class="block-elemt">输入列车编号(如：2312)：</p>
                            <p class="necessary block-elemt">*</p>
                            <input type="text" class="block-elemt" id="train-id-text" autocomplete="off" required onblur="judge_isNum()">
                        </div>

                        <div id="train-num" class="chiose-contrain">
                            <p class="block-elemt">输入车厢数量(1~20)：</p>
                            <p class="necessary block-elemt">*</p>
                            <input type="number" class="block-elemt" id="train-num-text" max="20" min="1" value="1" required>
                        </div>
                        <div class="chiose-contrain">
                            <button class="next-but" id="next1" onclick="to_next2()" style="border:solid 1px darkslateblue">下一步</button>
                        </div>
                    </div>
                </div>

                <div class="steps" id="step-2">
                    <!-- 第二步：分配车厢类型 -->
                    <div class="arg"></div>
                    <h1>分配车厢类型</h1>
                    <div id="step2-box">
                        <div id="can-choise">
                            可选车厢号有：
                            <ul>
                                <li>1</li>
                                <li>2</li>
                                <li>3</li>
                                <li>4</li>
                                <li>5</li>
                            </ul>
                        </div>
                        <div id="to-chiose" >
                            <table>
                                <tr >
                                    <th >选择车厢号(多选)</th>
                                    <th >选择车厢类型(单选)</th>
                                    <th >添加选择结果</th>
                                </tr>
                                <tr >
                                    <td >
                                        <select multip id="select-train-type-no" >
                                            <option value="1">1</option>
<%--                                            <option value="2">2</option>--%>
<%--                                            <option value="3">3</option>--%>
<%--                                            <option value="4">4</option>--%>
<%--                                            <option value="5">5</option>--%>
                                        </select>
                                    </td>
                                    <td>
                                        <select id="select-train-type-yes">
                                            <option value="一等座+20座+单价23.5￥/km">一等座+20座+单价23.5￥/km</option>
                                            <option value="二等座+20座+单价23.5￥/km">二等座+20座+单价23.5￥/km</option>
                                            <option value="三等座+20座+单价23.5￥/km">三等座+20座+单价23.5￥/km</option>
                                            <option value="商务座+20座+单价23.5￥/km">商务座+20座+单价23.5￥/km</option>
                                            <option value="软卧+20座+单价23.5￥/km">软卧+20座+单价23.5￥/km</option>
                                        </select>
                                    </td>
                                    <td>
                                        <button id="add-this-type">添加</button>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="chiose-resoult" style="overflow:auto;">
                            <h4>已选择：</h4>
                            <table id="chiose-resoult-table">
                                <tr>
                                    <th>车厢号</th>
                                    <th>座位类型</th>
                                    <th>座位编号</th>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>一等座+20座+单价23.5￥/km</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>一等座+20座+单价23.5￥/km</td>
                                    <td>0</td>
                                </tr>
                            </table>
                        </div>
                        <button id="next-2" class="next-but" onclick="canToNext_3()">下一步</button>
                    </div>

                </div>

                <div class="steps" id="step-3">
                    <!-- 第三步：显示结果 -->
                    <div class="arg"></div>

                    <div id="step3-box" style="overflow:auto;">
                        <h1>输入结果</h1>

                        <table id="all-message" >
                            <tr>
                                <th>属性</th>
                                <th>内容</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td >
                                    2<!-- <input placeholder="输入座位数"> -->
                                </td>
                            </tr>
                            <tr>
                                <td>全选</td>
                                <td>
                                    2 <!-- <input placeholder="输入座位数"> -->
                                </td>
                            </tr>
                        </table>
                        <button id="next-3" class="next-but" style="margin: 20px 20px 20px 40px;" onclick="submit_Trains()">提&nbsp;&nbsp;交</button>
                    </div>

                </div>

<%--                <div class="steps" id="step-4">--%>
<%--                    <!-- 第四步：提交结果 -->--%>
<%--                    <div class="arg"></div>--%>
<%--&lt;%&ndash;                    <button id="ack-no-seatnum">提交</button>&ndash;%&gt;--%>
<%--                </div>--%>
            </div>
        </div>
        <!-- 增加车次 -->
        <div id="add-raliwaytimes" class="add-message">
            <!-- 增加火车车次 -->
            <div id="add-train-box">
                <h1>增加火车车次</h1>
                <div id="input-panel">
                     <div class="box-1">
                        <p class="box-inline">1.选择始发站：</p>
                        <select id="add-select-station-name" >
                            <option value="" style="color: #888" disabled selected>-选择火车站-</option>
<%--                            <option value="北京西">北京西</option>--%>
<%--                            <option value="南昌西">南昌西</option>--%>
<%--                            <option value="江西西">江西西</option>--%>
<%--                            <option value="上海虹桥">上海虹桥</option>--%>
<%--                            <c:forEach items="${chiose_stations}" var="c_station">--%>
<%--                                <option value="${c_station}">${c_station}</option>--%>
<%--                            </c:forEach>--%>
                        </select>
                    </div>
                    <div class="box-1">
                        <p class="box-inline">2.选择发车车次：</p>
                        <select  class="box-inline" id="add-select-train-id" >
                            <option value="" style="color: #888" disabled selected>-选择列车-</option>
<%--                            <option value="G2312">G2312</option>--%>
<%--                            <option value="G2313">G2313</option>--%>
<%--                            <option value="G2314">G2314</option>--%>
<%--                            <option value="K2312">K2312</option>--%>
<%--                            <c:forEach items="${chiose_raliways}" var="c_raliway">--%>
<%--                                <option value="${c_raliway}">${c_raliway}</option>--%>
<%--                            </c:forEach>--%>
                        </select>
                    </div>
                    <div class="box-1">
                        <div class="box-1">
                            <p class="box-inline">3.选择发车时间:</p>
                            <!-- <input type="datetime"  placeholder="选择时间"> -->
                            <input type="datetime-local" id="add-select-start-time" value=""  class="box-inline" onblur="addStartTime_onblur()"/>
                        </div>
                    </div>
                    <div class="box-1" style="width: 15%;height: 80%;">
                        <div class="box-1" style="width: 100%;height: 100%;text-align: center;">
                            <button id="sure-msg" style="margin: 5%;height: 50%;">确认</button>
                            <button id="modify-msg" style="margin: 5%;height: 50%;">修改</button>
                        </div>
                    </div>
                </div>
                <div id="chiose-station-panel" style="overflow:auto;" >
                    <div>
                        <select class="box-1 chiose-box" id="add-select-nextstation" onfocus="addStartStation_onfoucs(this)">
                            <option value="" style="color: #888" disabled selected>选择下一站:</option>
                            <option value="北京西">北京西</option>
                            <option value="南昌西">南昌西</option>
                            <option value="江西西">江西西</option>
                            <option value="上海虹桥">上海虹桥</option>
                        </select>
                        <!-- <input type="datetime" placeholder="选择时间"> -->
                        <input class="box-1 chiose-box" id="add-daozan-time" type="datetime-local" value="" onfocus="addNextTime_onfoucs(this)" onblur="judgeTime()"/>
                        <input class="box-1 chiose-box" id="add-daozan-distance" type="text" placeholder="输入到站距离(/km)" onfocus="addDistance_onfoucs(this)" onblur="judgeNaN(this)">
                        <input class="box-1 chiose-box" id="add-one-trip" type="button" value="加入">
                    </div>
                    <table id="show-once-add-table">
                        <tr>
                            <th>下一站</th>
                            <th>到站时间</th>
                            <th>到站距离</th>
                        </tr>
                    </table>
                </div>
                <div id="submit-and-message"  style="overflow:auto;">
                    <button id="train-submit">提交</button>
                    <div>
                        <div></div>
                        <div >
                            <table id="show-submit-all-table">
                                <tr>
                                    <th>发车</th>
                                    <th>耗时</th>
                                    <th>到达</th>
                                </tr>
<%--                                <tr>--%>
<%--                                    <td>上海虹桥</td>--%>
<%--                                    <td>1:30</td>--%>
<%--                                    <td>北京西</td>--%>
<%--                                </tr>--%>
<%--                                <tr>--%>
<%--                                    <td>上海虹桥</td>--%>
<%--                                    <td>1:30</td>--%>
<%--                                    <td>北京西</td>--%>
<%--                                </tr>--%>
                            </table>
                        </div>
                    </div>
                    <button id="tryagain">新增</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
<script src="http://localhost:8080/raliway12307/js/managerJs/raliway.js"></script>
<script>

</script>
</body>

