
                        // 更新用户内容
                        // setUser();
                        // 单击关闭按钮，关闭下单面板document.getElementById("close").onclick();

                        //获取时间，设置日历最小可选时间为十分钟后,且一分钟刷新一次
                        // getNowTime();

                        var myDate = new Date;
                        var year = myDate.getFullYear(); //获取当前年
                        var mon = myDate.getMonth()+1 < 10 ? "0"+(myDate.getMonth()+1) : (myDate.getMonth()+1);//
                        var dat = myDate.getDate() < 10 ? "0"+myDate.getDate() : myDate.getDate();
                        $("#start-time").attr("min",year+"-"+mon+"-"+dat);

                        // setInterval(getNowTime,600000);
                        //
                        // function getNowTime() {
                        //
                        //     $.ajax({
                        //         type: "post",                //数据提交方式（post）
                        //         url: "http://localhost:8080/raliway12307/getData/getTimeNow", //提交的数据
                        //         dataType: "json",           //返回的数据类型格式
                        //         success: function (data) {
                        //             // if(data !== ""){
                        //                 alert("刷新时间"+data);
                        //                 document.getElementById("start-time").min = data;
                        //             // }
                        //         }
                        //     });
                        // }


                        function close_ticketpanel(){
                            document.querySelector("#pick-message").style.display="none";
                        }

                        function add(){
                            for(i=0;i<20;i++){
                                add_table(i);
                            }
                        }
                        // alert("123");
                        // delete_table("tab");
                        // 获取表格元素
                        var table=$('#ticket-table table');

                        // 获取输入内容的元素
                        var startArea=document.getElementById("start-area");
                        var endArea=document.getElementById("end-area");
                        var startTime=document.getElementById("start-time");

                        //鼠标从出发地的输入框离开后进行异步操作，模糊查询输入城市是否存在数据库
                        // $("#start-area").onblur(function(){
                        // delete_table("tab");
                        // });

                        //鼠标从目的站的输入框离开后进行异步操作，模糊查询输入城市是否存在数据库
                        // $("#end-area").onblur(function(){
                        //
                        // });
                        //鼠标从时间输入框离开后进行异步操作，查询时间是否选择合理
                        // startArea.onblur(function(){

                        // });


                        // 获取侧边栏元素
                        var img=document.getElementById("img");
                        var uname=document.getElementById("name");
                        var gexingqianmi=document.getElementById("gexingqianmi");
                        var userType=document.getElementById("user-type");
                        var phone=document.getElementById("phone");
                        var email=document.getElementById("email");

                        // 更新用户内容
                        function setUser(){
                            var v0="http://localhost:8080/raliway12307/clientImg/0_qq_44140450_1620910175.jpg";
                            var v1="肖家海";
                            var v2="没有";
                            var v3="VIP";
                            var v4="19970246857";
                            var v5="2749984520@qq.com";
                            var v6="36243019******481X"
                            document.getElementById("img").style.background="url("+v0+") no-repeat";
                            document.getElementById("img").style.backgroundSize="100px";
                            document.getElementById("name").innerHTML=v1;
                            document.getElementById("gexingqianmi").innerHTML="个性签名："+v2;
                            document.getElementById("user-type").innerHTML="我是："+v3;
                            document.getElementById("phone").innerHTML="phone："+v4;
                            document.getElementById("email").innerHTML="邮箱："+v5;
                            document.getElementById("ic").innerHTML="身份证："+v6;

                            document.getElementById("u-img").style.background="url("+v0+") no-repeat";
                            document.getElementById("u-img").style.backgroundSize="100px";
                            document.getElementById("u-name").innerHTML=v1;
                            document.getElementById("u-type").innerHTML=v3;
                            document.getElementById("u-pho").innerHTML=v4;
                            document.getElementById("u-ic").innerHTML=v6;
                        }

                        // 删除表格中的元素
                        function delete_table(table_id){
                            var tab=document.getElementById(table_id);
                            var len=tab.rows.length;
                            for(i=len-1;i >0; i--){
                                tab.deleteRow(i);
                            }
                        }

                        // 动态向表格中添加一行元素
                        function add_table0(index,arr){
                            // arr[0]="G2314";
                            // arr[1]="南昌西";
                            // arr[2]="2020-7-1 6:12:00";
                            // arr[3]="上海虹桥";
                            // arr[4]=" 2020-7-1 10:12:00";
                            // arr[5]="20";
                            // arr[6]="56";
                            // arr[7]="无";
                            // arr[8]="无";
                            // arr[9]="无";
                            // arr[10]="85";
                            // arr[11]="10";
                            var v12="去购买";
                            $("#tab").append("<tr><td>"+
                                arr[0]+"</td><td class='exe-td'><div><p >"+
                                arr[1]+"</p><p >"+
                                arr[2]+"</p></div></td><td class='exe-td'><div><p >"+
                                arr[3]+"</p><p >"+
                                arr[4]+"</p></div></td><td>"+
                                arr[5]+"</td><td>"+
                                arr[6]+"</td><td>"+
                                arr[7]+"</td><td>"+
                                arr[8]+"</td><td>"+
                                arr[9]+"</td><td>"+
                                arr[10]+"</td><td>"+
                                arr[11]+"</td><td><a href='#' onclick='click_a("+index+")'>"+
                                v12+"</a></td></tr>");
                            arr_end[index]=arr[13];
                            arr_star[index]=arr[12];
                        }


                        // delete_table("+tab+")
                        var startArea=document.getElementById("start-area");
                        var endArea=document.getElementById("end-area");
                        var startTime=document.getElementById("start-time");

                        // 单击查找按钮后进行查票

                        $('#submit-but').click(function () {


                            if(startArea.value != "" && endArea.value != "" && startTime.value !=""){
                                delete_table("tab");

                                // alert("开始查票");

                                var data={start_point:startArea.value,end_point:endArea.value,time:startTime.value}
                                // alert("开始查票！");
                                $.ajax({
                                    type: "post",                //数据提交方式（post）
                                    url: "http://localhost:8080/raliway12307/getData/findTicket", //提交的数据
                                    dataType: "json",           //返回的数据类型格式
                                    data:data,
                                    success: function (data) {
                                        if(data.falge == 200){
                                            if(data.list.length<=0){
                                                alert("暂时没有查到"+startTime.value+"从  ["+startArea.value+"]  发往/途径  ["+endArea.value+"]  的列车信息！");
                                            }else{
                                                for(i=0;i<data.list.length;i++){
                                                    add_table0(i,data.list[i]);
                                                }
                                            }

                                        }else{
                                           alert("服务器链接失败！")
                                        }
                                    }
                                });

                            }
                            else{
                                alert("输入不能为空！");
                            }
                        });

                        var arr_end = new Array();
                        var arr_star = new Array();
                        var time_star_train="";
                        var train_name_chiose="";
                        function add_buymsgPanel(index){

                            var cells=document.getElementById("tab").rows[index+1].cells;

                            document.getElementById("ticket-train-id").innerHTML=cells[0].innerText;
                            var station_name=cells[0].innerText;
                            var start_time=cells[1].getElementsByTagName('p')[1].innerText;

                            // var station_name=arr_star[i];
                            // var start_time=arr_end[i];
                            time_star_train=start_time;
                            train_name_chiose=station_name;

                            var start_station=$("#start-area").val();
                            var end_station=$("#end-area").val();

                            var data ={station_name:station_name,
                                start_time:start_time,
                                start_station:start_station,
                                end_station:end_station};
                            $.ajax({
                                type: "post",                //数据提交方式（post）
                                url: "http://localhost:8080/raliway12307/getData/findStationTimes", //提交的数据
                                dataType: "json",           //返回的数据类型格式
                                data:data,
                                success: function (data) {

                                    if(data.falge == 200){

                                        var cells=document.getElementById("tab").rows[index+1].cells;

                                        document.getElementById("ticket-train-id").innerHTML=cells[0].innerText;

                                        // document.getElementById("s-station").innerHTML=$("#start-area").val();
                                        //
                                        // document.getElementById("e-station").innerHTML=$("#end-area").val();
// alert(arr_star[index]+"<===>"+arr_end[index]);
                                        document.getElementById("s-station").innerHTML=arr_star[index];

                                        document.getElementById("e-station").innerHTML=arr_end[index];

                                        document.getElementById("e-time").innerHTML=data.list[1];
                                        document.getElementById("s-time").innerHTML=data.list[0];

                                        document.getElementById("money").innerHTML="*";
                                        ajax_add(index);//形参arr

                                    }
                                }
                            });
                        }
                        // function seach(arr){
                        //     arr.document.getElementsByTagName('p')[0].nodeValue;
                        // }

                        // ajax异步请求不同座位对应的价格(异步次数较多，每次重选座位类型异步一次)
                        function ajax_change_money(money){
                            document.getElementById("money").innerHTML=money;
                        }

                        // 访问以数据库，查询当前 时刻当前车次对应的可选座位类型（每次打开买票面板异步查询一次）arr
                        function ajax_add(index){

                            var cells=document.getElementById("tab").rows[index+1].cells;

                            arr=["商务座","软卧","硬卧","一等座","二等座","硬座","无座"];

                            remove_select("seat-type");

                            for ( i=0;i<arr.length ;i++){
                                var disable="disabled";
                                if(parseInt( cells[i+3].innerText) > 0){
                                    disable="";
                                }
                                $('#seat-type').append("<option value= " + arr[i] +" "+disable+ ">" + arr[i] + "</option>");
                            }

                            for(i=1;i<arr.length;i++){

                            }
                        }
                        // 清除下拉框的选项
                        function remove_select(selectid){
                            var div = document.getElementById(selectid);
                            div.innerHTML = '';
                            $('#seat-type').append("<option selected disabled>-请选择座位类型-</option>");
                        }


                        // 为“去购买”的链接写一个事件处理方法,传入选择的列车车次、出发站，目的站、日期，进行异步查询，显示下单信息给用户。
                        function click_a(index){
                            // train_id,start_area,end_area,start_time
                            add_buymsgPanel(index);
                            document.querySelector("#pick-message").style.display="block";
                        }

                        // findPrice
                        $("#seat-type").change(function () {
                            var data={
                                train_name:document.getElementById("ticket-train-id").innerText,
                                seat_type:$("#seat-type").find("option:selected").text(),
                                client_id:$("#client_id").val(),
                                start_point:document.getElementById("s-station").innerText,
                                start_time:document.getElementById("s-time").innerText,
                                end_point: document.getElementById("e-station").innerText,
                            };
                            $.ajax({
                                type: "post",                //数据提交方式（post）
                                url: "http://localhost:8080/raliway12307/getData/findPrice", //提交的数据
                                dataType: "json",           //返回的数据类型格式
                                data:data,
                                success: function (data) {
                                    document.getElementById("money").innerHTML="￥"+data+" 元";
                                },
                                error:function () {
                                    document.getElementById("money").innerHTML="￥*** 元";
                                }
                            });
                        });

                        // @RequestMapping("/buyTicket")
                        // public int userHasThisTicket(@RequestParam("train_name") String train_name,
                        // @RequestParam("time") String time,
                        // @RequestParam("client_id")String client_id,

                        $("#buy-ticket").click(function () {

                            var hasTicket={
                                client_id:$("#client_id").val(),
                                train_name:train_name_chiose,
                                time:time_star_train
                            };
                            // alert(hasTicket.client_id+"=="+hasTicket.train_name+"=="+hasTicket.time);
                            $.ajax({
                                type: "post",                //数据提交方式（post）
                                url: "http://localhost:8080/raliway12307/getData/userHasThisTicket", //提交的数据
                                dataType: "json",           //返回的数据类型格式
                                data:hasTicket,
                                success: function (data) {
                                    if(data === 0){

                                        if(confirm("确认下单吗？")){
                                            var data={
                                                train_name:document.getElementById("ticket-train-id").innerText,
                                                seat_type:$("#seat-type").find("option:selected").text(),
                                                client_id:$("#client_id").val(),
                                                start_point:document.getElementById("s-station").innerText,
                                                start_time:document.getElementById("s-time").innerText,
                                                end_time:document.getElementById("e-time").innerText,
                                                end_point: document.getElementById("e-station").innerText,
                                                };
                                            $.ajax({
                                                type: "post",                //数据提交方式（post）
                                                url: "http://localhost:8080/raliway12307/getData/buyTicket", //提交的数据
                                                dataType: "json",           //返回的数据类型格式
                                                data:data,
                                                success: function (data) {
                                                    // alert(data);
                                                    // add_table1(data);
                                                    if(data == 200){
                                                        if (confirm("购票成功！是否去我的主页查看我的票？")){
                                                            document.location.href="http://localhost:8080/raliway12307/raliway/mine";
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                    else{
                                        if(confirm("您已购买了过了这张票！下单失败！是否去我的主页查看？")){
                                            document.location.href="http://localhost:8080/raliway12307/raliway/mine";
                                        }
                                    }
                                }
                            });
                        });
