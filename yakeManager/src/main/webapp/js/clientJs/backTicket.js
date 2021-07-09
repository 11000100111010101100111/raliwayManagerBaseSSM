


                    var li_size=0;//记录车票数

                    // 选中当前车票出现阴影，其他车票失去阴影
                    function chiosed(elem){
                        for(x =0;x<li_size;x++){
                            document.querySelectorAll("#uls li .tickes")[x].style.cssText = "box-shadow:0;";
                        }
                        elem.style.cssText = "box-shadow:0 0 18px darkslateblue ;";
                    }
                    //传入数值，生成车票列表
                    //火车票对应的账单号
                    //火车票的始发站
                    //火车对应的编号
                    //到达站
                    //发车时间
                    //票价
                    //座位类型
                    //用户身份证
                    //用户姓名
                    add_list();



                    var back_panel=document.getElementById("sureto-back-tickte");
                    $("#find-my-tickets").click(add_list);

                    $('#modify-button').click(function () {
                        // alert("签票");
                        // alert("value:"+document.querySelector('#tickets-id-nums').value);
                        document.querySelector("input[type='text']").value=document.querySelector('#tickets-id-nums').value;
                        alert("value:"+document.querySelector("input[type='text']").value);

                    });
                    $('#back-button').click(function () {
                        back_panel.style.display="block";
                    });
                    $("#tickets-id-nums").mouseenter(function(){

                        document.querySelector("input[type='text']").value=document.querySelector('#tickets-id-nums').value;
                    });
                    $("#tickets-id-nums").mousedown(function(){

                    });
                    //关闭退票提示
                    $("#close-bt").click(function(){
                        back_panel.style.display="none";
                    });



                    $("#tickets-box").mouseenter(function(){
                        // alert("value:"+document.querySelector('#tickets-id-nums').value);
                        // document.querySelector("input[type='text']").value=document.querySelector('#tickets-id-nums').value;

                    });

                    // 清除元素子节点
                    function delete_select(id){
                        var e = document.querySelector(id);
                        var first = e.firstElementChild;
                        while (first) {
                            first.remove();
                            first = e.firstElementChild;
                            // sleep(100);
                        }
                    }



                    function set_selected(str){
                        // var obj = document.getElementById("tickets-id-nums");
                        // for(i=0;i<obj.length;i++){
                        //     if(obj[i].value==str)
                        //         obj[i].selected = true;
                        // }
                    }


                    function sleep(numberMillis) {
                        var now = new Date();
                        var exitTime = now.getTime() + numberMillis;
                        while (true) {
                            now = new Date();
                            if (now.getTime() > exitTime){
                                return;
                            }
                        }

                    }

                    //单击退票按钮时
                    function backTicks(str){
                        // alert("111");
                        // back_panel.style.display="block";


                        // var tick_ID=document.querySelector("input[type='text']").value;

                        // 根据此订单编号来查询车票在数据库的信息，包含：
                        // 1.车次号、2.始发站、3.到达站、4.订单编号、5.发车时间、6.单价
                        // var v0="G2312";
                        //                         // var v1="南昌西";
                        //                         // var v2="吉安西";
                        //                         // var v3="6666666666666666666";
                        //                         // var v4="2020-6-30  18:52:00";
                        //                         // var v5="120.50";
                        //                         // addTicketPanelmsg(v0,v1,v2,v3,v4,v5);
                        // alert(str);
                        if(confirm("确定要退了这张票吗？")){
                            $.ajax({
                                type: "post",                //数据提交方式（post）
                                url: "http://localhost:8080/raliway12307/backTicket/modifyAndDelete", //提交的数据
                                dataType: "json",           //返回的数据类型格式
                                data: {ticket_id:str},
                                success: function (data) {
                                    if (  data >= 0) {
                                            li_size=0;
                                            add_list();
                                            alert("退票成功！")
                                    }
                                    else{alert("失败了：操作异常！")}
                                }
                            });
                        }

                    }
                    function addTicketPanelmsg(v0,v1,v2,v3,v4,v5) {
                        document.querySelector("#sure-1 h3").innerHTML="确认退票："+v0+"次？";
                        document.querySelector("#sure-2-start").innerHTML=v1;
                        document.querySelector("#sure-2-end").innerHTML=v2;
                        document.querySelector("#sure-3 p").innerHTML="订单编号："+v3;
                        document.querySelector("#sure-4 p").innerHTML="发车时间："+v4+"开";
                        document.querySelector("#sure-5 p").innerHTML="￥："+v5+"元";
                    }

                    // 确认退票
                    $("#sureto-back-bt").click(function(){

                        document.querySelector("input[type='text']").value=document.querySelector('#tickets-id-nums').value;

                        var tick_ID=document.querySelector("input[type='text']").value;

                        // 根据此订单编号来进行修改数据库信息
                        alert("订单编号为:"+tick_ID+"退票成功，交易完成！");




                    });

                    //单击改签按钮时,提交表单，跳转到改签页面，提交数据为被选中的票的编号
                    function modifyTicks(str){
                        alert("立即去改签！");
                    }


                    // 选中对应的车票后，记录当前选择的票
                    function add_action(str){
                        document.querySelector('#tickets-id-nums').value=str;
                    }


                    // 向列表中添加车票
                    function add_list(){
                        var uls=$("#tickets-box ul");
                        delete_select("#tickets-id-nums");
                        delete_select("#tickets-box ul");

                        li_size=0;

                        $.ajax({
                            type: "post",                //数据提交方式（post）
                            url: "http://localhost:8080/raliway12307/backTicket/findAllTicketAboutClient", //提交的数据
                            dataType: "json",           //返回的数据类型格式
                            data: {client_id:$("#client_id").val()},
                            success: function (data) {
                                if (  data != null) {
                                    if(data.length <= 0){
                                        document.querySelector("#no-tickets").style.display= 'block';
                                    }else{
                                        document.querySelector("#no-tickets").style.display= 'none';
                                    }
                                    for(i=0;i<data.length;i++){
                                        // alert(data[i])
                                        add_oneTicket(data[i]);
                                        li_size=li_size+1;
                                    }
                                }
                                else{alert("失败了：操作异常！")}
                            }
                        });
                    }
                    // 向列表中添加一张车票
                    function add_oneTicket(list){
                        // var v0="123465846516456"+i;//火车票对应的账单号
                        // var v1="南昌西";//火车票的始发站
                        // var v2="G2312";//火车对应的编号
                        // var v3="北京南";//到达站
                        // var v4="2021年6月13号  12:36:00";//发车时间
                        // var v5="45.5";//票价
                        // var v6="二等座";//座位类型
                        // var v7="26354899951257841X";//用户身份证
                        // var v8="张三";//用户姓名
                        // var v9='不失效';

                        var v0=list.ticket_id;//火车票对应的账单号

                        var v1=list.start_point;//火车票的始发站
                        var v2=list.train_id;//火车对应的编号
                        var v3=list.end_point;//到达站
                        var v4=list.start_time;//发车时间
                        var v5=list.price;//票价
                        var v6=list.seat_type;//座位类型
                        var v7=list.client_ic;//用户身份证
                        var v8=list.client_name;//用户姓名
                        var v9=list.ticket_state;

                        var v10="";
                        if(v9 != "未失效"){
                            v9="style='display:none;'";
                            // alert(v9);
                        }
                        else{
                            // v9="";
                            v10="style='pointer-events: none;cursor: default;'";
                        }

                        $('#tickets-id-nums').append("<option value= " +
                            v0 + ">" +
                            v0 + "</option>");
                        $("#tickets-box ul").append("<li class='inline-block-elem' value="+
                            v0+"  onmousemove=add_action("+
                            v0+")><div class='tickes' onmousedown='chiosed(this)'><div class='tick-1'><div class='tick-11'><p class='id-warter' >"+
                            v0+"</p><div class='tick-111'><h3 class='inline-block-elem tick-111-sub'>"+
                            v1+"</h3><div class='tick-1111 inline-block-elem tick-111-sub'><h5 style='text-align: center;'>"+
                            v2+"</h5><img src='http://localhost:8080/raliway12307/img/clientImg/icon_go.png' ></div><h3 class='inline-block-elem tick-111-sub'>"+
                            v3+"</h3></div><p class='tick-1121'>"+
                            v4+"&nbsp;&nbsp;开</p><div class='tick-112'><p class='tick-1121 inline-block-elem'>"+
                            v5+"元</p><p class='tick-1122 inline-block-elem'>"+
                            v6+"</p></div><div class='tick-113 '><p class='tick-1121 inline-block-elem'>"+
                            v7+"&nbsp;&nbsp;"+
                            v8+"</p><img class='inline-block-elem' src=''></div></div><div class='tick-12'><button id='back-button' "+
                            v10 +" onclick=backTicks("+
                            v0+")>退票</button></div><div class='is-shixiao' "+
                            v9+"><p>"+
                            v9+"</p></div></div><p class='make-msg'>188207245肖家海&nbsp;&nbsp;制</p></div></li>");

                    // <button id='modify-button' onclick=modifyTicks("+
                    //     v0+")>改签</button>
                    }