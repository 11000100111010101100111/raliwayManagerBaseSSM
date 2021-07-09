
                delete_select("#tickets-box ul");
                delete_select("#tickets-id-nums");
                var li_size=0;//记录车票数

                // 选中当前车票出现阴影，其他车票失去阴影
                function chiosed(elem){
                    for(x =0;x<li_size;x++){
                        document.querySelectorAll("#uls li .tickes")[x].style.cssText = "box-shadow:0;";
                    }
                    elem.style.cssText = "box-shadow:0 0 18px darkslateblue ;";
                }

                function delete_select(id){
                    var e = document.querySelector(id);
                    var first = e.firstElementChild;
                    while (first) {
                        first.remove();
                        first = e.firstElementChild;
                        // sleep(100);
                    }
                }

                $('#my-message-bar input').click(function () {
                    $('html,body').animate({
                        scrollTop: $('#my-message').offset().top - 140
                    }, 600);
                });
                $('#chuxing-service-bar input').click(function () {
                    $('html,body').animate({
                        scrollTop: $('#chuxing-service').offset().top - 140
                    }, 600);
                });
                $('#bake-ticket-bar input').click(function () {
                    $('html,body').animate({
                        scrollTop: $('#back-tick-service').offset().top - 140
                    }, 600);
                });

                $('#account-safe-bar input').click(function () {
                    $('html,body').animate({
                        scrollTop: $('#account-safe').offset().top - 140
                    }, 600);
                });

                function backTicks(str){
                    alert("111:"+str);
                }
                function modifyTicks(str){
                    alert("222:"+str);
                }
                // $("#find-my-tickets").click(function(){
                //     // alert('开始');
                //     var uls=$("#tickets-box ul");
                //     var len=document.querySelectorAll("#tickets-id-nums option");
                //     // alert("len:"+len.length);
                //     for(j=0;j<len.length;j++){
                //         $("#tickets-id-nums option[index="+j+"]").remove();
                //     }
                //
                //     delete_select("#tickets-box ul");
                //     delete_select("#tickets-id-nums");
                //     // #back-tick-service .is-shixiao
                //
                //     li_size=0;
                //     for(i=0;i<20;i++){
                //         var value="12222"+i;
                //         var v0="123465846516456"+i;
                //         var v1="南昌西";
                //         var v2="G2312";
                //         var v3="北京南";
                //         var v4="2021年6月13号";
                //         var v5="45.5";
                //         var v6="二等座";
                //         var v7="26354899951257841X";
                //         var v8="张三";
                //         var v9='不失效';
                //         if(v9 != '失效'){
                //             v9="style='display:none;'";
                //         }
                //         else{
                //             v9='';
                //         }
                //         $('#tickets-id-nums').append("<option value= " +
                //             v0 + ">" +
                //             v0 + "</option>");
                //         $("#tickets-box ul").append("<li class='inline-block-elem' value="+
                //             v0+"  onmousemove=add_action("+
                //             v0+")><div class='tickes' onmousedown='chiosed(this)'><div class='tick-1'><div class='tick-11'><p class='id-warter' >"+
                //             v0+"</p><div class='tick-111'><h3 class='inline-block-elem tick-111-sub'>"+
                //             v1+"</h3><div class='tick-1111 inline-block-elem tick-111-sub'><h5 style='text-align: center;'>"+
                //             v2+"</h5><img src='http://localhost:8080/train12307.com/img/cilentImg/icon_go.png' ></div><h3 class='inline-block-elem tick-111-sub'>"+
                //             v3+"</h3></div><p class='tick-1121'>"+
                //             v4+"&nbsp;&nbsp;开</p><div class='tick-112'><p class='tick-1121 inline-block-elem'>"+
                //             v5+"元</p><p class='tick-1122 inline-block-elem'>"+
                //             v6+"</p></div><div class='tick-113 '><p class='tick-1121 inline-block-elem'>"+
                //             v7+"&nbsp;&nbsp;"+
                //             v8+"</p><img class='inline-block-elem' src=''></div></div><div class='tick-12'><button id='back-button' onclick=backTicks("+
                //             v0+")>退票</button><button id='modify-button' onclick=modifyTicks("+
                //             v0+")>改签</button></div><div class='is-shixiao' "+
                //             v9+"><p>已失效</p></div></div><p class='make-msg'>铁路12306&nbsp;&nbsp;制</p></div></li>");
                //         li_size=li_size+1;
                //     }
                // });
                // 向列表中添加车票
                $("#find-my-tickets").click(function(){
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
                                for(i=0;i<data.length;i++){
                                    // alert(data[i])
                                    add_oneTicket(data[i]);
                                    li_size=li_size+1;
                                }
                            }
                            else{alert("失败了：操作异常！")}
                        }
                    });
                });
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

                    if(v9 !== "未失效"){
                        v9="style='display:none;'";
                        // alert(v9);
                    }
                    else{
                        v9='';
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
                        v8+"</p><img class='inline-block-elem' src=''></div></div><div class='tick-12'><button id='back-button' onclick=backTicks("+
                        v0+") style='visibility: hidden;'>退票</button></div><div class='is-shixiao' "+
                        v9+"><p>已失效</p></div></div><p class='make-msg'>188207245肖家海&nbsp;&nbsp;制</p></div></li>");

                    // <button id='modify-button' onclick=modifyTicks("+
                    //     v0+")>改签</button>
                }





                // 刷新显示时间
                function showTime(){
                    var myDate = new Date;
                    var myHours = myDate.getHours();
                    var myMinutes = myDate.getMinutes();
                    var mySeconds = myDate.getSeconds();
                    document.querySelector(".hour-hand").style.transform = `rotate(${myHours * 30 + myMinutes * 0.5 + mySeconds /120 }deg)`;
                    //1分钟 分针走6度，再加上秒针影响分针走的度数，即一秒钟分钟走0.1度
                    document.querySelector(".minute-hand").style.transform = `rotate(${myMinutes * 6 + mySeconds * 0.1}deg)`;
                    document.querySelector(".second-hand").style.transform = `rotate(${mySeconds * 6}deg)`;
                }
                showTime();
                setInterval(showTime,1000);