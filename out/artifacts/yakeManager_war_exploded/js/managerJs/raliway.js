// 获取的元素、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、

            var panel1 = document.getElementById("add-station");

            var panel2 = document.getElementById("add-raliway");

                var step1=document.getElementById("step-1");
                var step2=document.getElementById("step-2");
                var step3=document.getElementById("step-3");
                // var step4=document.getElementById("step-4");

            var panel3 = document.getElementById("add-raliwaytimes");



            var tb_chexiangtype=document.querySelector('#chiose-resoult table');   //获取每节车厢对应的类型
            var tb_noseatnum=document.querySelector('#step3-box table');  //获取每节车厢对应无座的票数
            var train_id=document.querySelector('#train-id-text');


            var train_nums=document.querySelector('#train-num-text');

            var va=document.getElementById("train-type-text");

            // 添加选择后端车厢类型按钮
            var add_seattype=$("#add-this-type");
            var select_typeNo=document.getElementById("select-train-type-no");
            var select_typeYse=document.getElementById("select-train-type-yes");



            // 添加列车车次
            var select_trainid=$("#add-select-train-id");
            var select_startstation=$("#add-select-station-name");
            var select_starttime=$("#add-select-start-time");

            var select_nextstation=document.querySelector("#add-select-nextstation");
            var select_nextdaozantime=document.querySelector("#add-daozan-time");
            var select_nextdaozandistance=document.querySelector("#add-daozan-distance");
            var add_onetrip=$("#add-one-trip");
            var show_oneadd=$("#show-once-add-table");

            var submit_all=$("#train-submit");
            var show_all_submit=$("#show-submit-all-table");



 //注册的事件 、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、
 //        add_province();
// 第一步、添加下一站
// 打开新增车站栏，请求ajax异步查询省份和城市加入Httpsession,开始新增车站

            function add_province() {
                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/getPro", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    success: function (data) {
                        if (  data.falge == 200) {
                            delete_select("#chiose-province");
                            $("#chiose-province").append("<option  disabled selected>-请选择-</option>");
                            for (i = 0; i < data.list.length; i++) {
                                if ($("#chiose-province option").size() > i) {
                                    $("#chiose-province option[index=" + (i - 1) + "]").remove();
                                }
                                $("#chiose-province").append("<option>" + data.list[i] + "</option>");
                            }
                        }
                        else{
                            alert("服务器链接失败！")
                        }
                    }
                });
            }



// 打开新增车站栏
            $('#add-station-bar').click(function () {
                hidden_page(panel1);
            });

// 选择完省后进行异步查询此省份的城市，并添加到下拉列表，提供选择
            $("#chiose-province").blur(function province_onblur() {
                // delete_select("#chiose-city");
                //通过ajax判断用户是否存在
                // var data={city:"北京"};
                // data.city=document.getElementById("chiose-province").value;
                var pro=document.getElementById("chiose-province").value;
                //获取城市数据
                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/getCity", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: {pro:pro},
                    success: function (data) {
                        if (data.falge == 200){
                            delete_select("#chiose-city");
                            if(data.list.length<=0){
                                $("#chiose-city").append("<option  disabled selected>暂时没有这个省的城市信息</option>");
                            }
                            else {
                                for (i = 0; i < data.list.length; i++) {
                                    // alert(data.list[i]);
                                    $("#chiose-city").append("<option>" + data.list[i]+ "</option>");
                                    // addOptions("#chiose-city", data.list[i]);
                                    // console.log(data.list[i]);
                                }
                            }
                        }
                    }
                });
            });

//输入完车站名称后异步查询此车站是否存在
            function stationName_onblur() {
                //通过ajax判断车站名称是否存在

                var data={stationId:null,stationName:""};
                data.stationName=$("#station-name input").val();

                if(data.stationName != ""){
                    $.ajax({
                        type: "post",
                        url: "http://localhost:8080/raliway12307/getData/findElem", //提交的数据
                        dataType: "json",           //返回的数据类型格式
                        data: data,
                        success: function (data) {
                            if (data == 100){
                                alert("当前车站名称已经存在！请输入其他车站名称！");
                                document.querySelector("#station-name input").innerText="";
                            }
                            else if(data==0){
                                alert("操作异常！")
                            }
                        }
                    });
                }
            }
//输入完车站id后异步查询此车站id是否已被使用
            function stationId_onblur() {
                var data={stationId:"",stationName:null};
                data.stationId=$("#station-id input").val();
                if(data.stationId != ""){
                    $.ajax({
                        type: "post",
                        url: "http://localhost:8080/raliway12307/getData/findElem", //提交的数据
                        dataType: "json",           //返回的数据类型格式
                        data: data,
                        success: function (data) {
                            if (data == 100){
                                alert("当前车站id已经存在！请输入其他车站id！");
                                $("#station-name input").val("");
                                document.querySelector("#station-id input").innerText="";
                            }
                            else if(data==0){
                                alert("操作异常！")
                            }
                        }
                    });
                }
            }
//向城市下拉框填入一个选项
            function addOptions(selectId,val){
                $(selectId).append("<option>" +val + "</option>");
            }
//ajax异步执行：提交新增车站信息
            function submit_station_msg(){
               var localPro=$("#chiose-province").val();
               var localCity=$("#chiose-city").val();
               var otherLocal=$("#location input").val();
               var stationId=$("#station-id input").val();
               var stationname=$("#station-name input").val();
               if(localPro =="" || localCity == "" ||stationId == "" || stationname == ""){
                   alert("信息输入不完整！");
               }
               else {
                   var data={local:localPro+localCity+otherLocal,stationId:stationId,stationName:stationname};
                   $.ajax({
                       type: "post",                //数据提交方式（post）
                       url: "http://localhost:8080/raliway12307/getData/addStation", //提交的数据
                       dataType: "json",           //返回的数据类型格式
                       data: data,
                       success: function (data) {
                           if (data == 200){
                               alert("添加成功！");
                               $("#station-name input").val("");
                               $("#write-add").val("");
                               $("#station-id input").val("");
                           }
                           else if(data == 100){
                               alert("网络无法连接！");
                           }
                           else {
                               alert("失败了：输入了重复的已存在的车站信息！");
                           }
                       }
                   });
               }
            }


// 第二步、新增列车
// 异步查询所有列车类型，添加到下拉表中

            var trains_arr=new Array();//存放已选择好了的列车车厢数据，包含列车编号和座位类型、车厢号。

            $('#add-raliway-bars').click(function () {
                hidden_page(panel2);
            });

            // 2.1输入车厢基本信息
            // 单击添加按钮开始进入添加列车基本信息,
            $('#write-raliway-id').click(function () {
                hidden_steppage(step1);
            });

            //输入列车编号后焦点离开，判断输入的列车编号是否可行（数字编号），可行则进行异步查询是否存在，不存在需重新输入一个
            function judge_isNum(){
                var headcode=$("#train-type-text").val();

                var id_text=$("#train-id-text");
                if( !isNaN(id_text.val()) ){
                    if(id_text.val()==""){
                        return 0;
                    }
                    var train_id=headcode+"*"+id_text.val();
                    $.ajax({
                        type: "post",                //数据提交方式（post）
                        url: "http://localhost:8080/raliway12307/getData/judgeTrainId", //提交的数据
                        dataType: "json",           //返回的数据类型格式
                        data: {train_id:train_id},
                        success: function (data) {
                            if (data != 200){
                                alert("输入的列车id已存在，请重新输入！")
                            }
                            else if(data==0){
                                alert("操作异常！")
                            }
                        }
                    });
                }
                else{
                    alert("输入错误：列车编号只能由数字组成！")
                }
            }

            // 2.2分配车厢类型
            $('#fenpei-chexiang-type').click(function () {
                to_next2();
            });

            var flage_trainNums_changeed=0;
            function to_next2(){
                var val=0;
                var trainType=$("#train-type-text").val();
                var trainId=$("#train-id-text").val();
                var  trainNums=$("#train-num-text").val();

                if(trainId== "" || trainType == "" || trainNums == ""){
                    alert("请先输入列车的基本信息！");
                }
                else{
                    if(flage_trainNums_changeed==1){
                        flush();
                        if($("#select-train-type-no option").size()<=0){
                            add_Select();
                        }
                        flage_trainNums_changeed=0;
                    }
                    hidden_steppage(step2);
                }
            }

            // 删除列表选项，重新添加数据
            function flush(){
                //清除已选择好了的列车车厢信息

                // alert(trains_arr.length);
                // trains_arr=trains_arr.splice(0,trains_arr.length);
                trains_arr.length=0;
                // alert(trains_arr.length);

                delete_select("#chiose-resoult-table");
                document.getElementById("chiose-resoult-table").innerHTML+="<tr><th>车厢号</th><th>座位类型</th><th>座位编号</th></tr>";


                //2.添加可选车厢选项，
                delete_select("#select-train-type-yes");



                var data=$("#train-type-text").val();
                // 3.添加可选车厢类型，通过ajax请求数据
                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/findSeatType", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: {data:data},
                    success: function (data) {
                        if (data.falge == 200){
                            for(i=0;i<data.list.length;i++){
                                $("#select-train-type-yes").append(data.list[i]);
                            }
                        }
                        else{
                            alert("操作异常！")
                        }
                    }
                });
            }
            function add_Select(){
                delete_select("#select-train-type-no");
                var nums=train_nums.value;
                for(i=1;i<=nums;i++){
                    if($("#select-train-type-no option").size()>i){
                        $("#select-train-type-no option[index="+(i-1)+"]").remove();
                    }
                    $('#select-train-type-no').append("<option value= " + i + ">第" + i + "节车厢</option>");
                }
            }
            // 新增一趟列车，注册鼠标离开输入框事件，一趟列车车厢数至少一节最多20节
            $("#train-num-text").mouseleave(function(){
                var nums=train_nums.value;
                if(nums>20){
                    this.value=20;
                }
                else if(nums<1){
                    this.value=1;
                }
                //1.添加可选车厢列表，
                add_Select();
                flage_trainNums_changeed=1;
                // flush();
            });


            // 鼠标单击后，将选择完的车厢类型添加到表格，并从下拉框中删除已添加号的车厢
            add_seattype.click(function(){
                var tab =document.getElementById("chiose-resoult-table");
                if($("#select-train-type-no option").size()>0){

                    //获取选中车厢的值，下来框的值
                    var val1=select_typeNo.value;
                    // 获取选中的车厢类型
                    var val2=select_typeYse.value;
                    // var val3=select_typeYse.innerText;
                    var val3=$("#select-train-type-yes").find("option:selected").text();
                    tab.innerHTML+="<tr>\n"+
                        "<td>"+val1+"</td>\n"+
                        "<td>"+val3+"</td>"+
                        "<td>"+val2+"</td>"+
                        "</tr>";
                    $("#select-train-type-no option[value="+val1+"]").remove();

                    // 将这条信息加入到待上传的列表
                    var train_id=$("#train-type-text").val()+"*"+$("#train-id-text").val();
                    trains_arr.push(train_id+"*"+val1+"*"+val2);
                }
                else{
                    alert("车厢已全部选完了！");
                }
                // 追加下来项
                // $('#id').append("<option value= " + keyValue + ">" + keyName + "</option>");

            });


            // 为车厢选完座位类型后才能打开下一个面板
            function next_3(){
                var datas=new Obj(["",""],["",""]);
                datas=getData();
                var tab =document.getElementById("all-message");
                for(i=0;i<datas.name.length;i++){
                    if(i<tab.rows.length-1){
                        tab.rows[i].cells[0].innerText=datas.name[i];
                        tab.rows[i].cells[1].innerText=datas.msg[i];
                    }
                    else{
                        tab.innerHTML+="<tr>\n"+
                            "<td>"+datas.name[i]+"</td>\n"+
                            "<td>"+datas.msg[i]+"</td>"+
                            "</tr>";
                    }
                }
                hidden_steppage(step3);
            }

            function canToNext_3(){
                if($("#select-train-type-no option").size() <= 0){
                    next_3();
                }
                else{
                    alert("请先输入完整的数据！");
                }
            }
            //  核对输入数据
            $('#no-seat').click(function () {
                canToNext_3();
            });

            // $("#next-3").click();
            function submit_Trains(){
                if($("#all-message tr").size() <= 0){
                    alert("没有数据可以提交了！sorry!");
                }
                else {
                    if (confirm("确认提交这些数据？提交后不可修改！")) {
                        // 3.添加可选车厢类型，通过ajax请求数据
                        for (i = 0; i < trains_arr.length; i++) {
                            submit_onec_data(trains_arr[i]);
                        }
                        var train_id=$("#train-type-text").val()+"*"+$("#train-id-text").val();
                        //提交完成后再次异步查询，操作是否生效
                        $.ajax({
                            type: "post",                //数据提交方式（post）
                            url: "http://localhost:8080/raliway12307/getData/havaTrain", //提交的数据
                            dataType: "json",           //返回的数据类型格式
                            data: {train_id:train_id},
                            success: function (data) {

                                if ( trains_arr.length == data) {
                                    //清空表中数据，防止多次重复提交已成功提交的数据
                                    trains_arr.length = 0;
                                    trains_arr=new Array();
                                    delete_select("#chiose-resoult-table");
                                    delete_select("#all-message");
                                    alert("提交成功！")
                                }
                                else{
                                    alert("失败了：操作异常！")
                                }
                            }
                        });

                    }
                }
            }

            function submit_onec_data(str){
                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/submitTrains", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: {data:str},
                    success: function (data) {
                        // flage=data;
                    }
                });
            }

            function hidden_steppage(page){
                step1.style.display="none";
                step2.style.display="none";
                step3.style.display="none";
                // step4.style.display="none";
                page.style.display="block";
            }
// 第三步、 新增班次
//             记录是否有始发站信息
            var has_startPoint=false;


            // function get_trains() {
            //     for (i = 0; i < canchiose_trains.length ; i++) {
            //         if($("#add-select-station-name option").size()>i){
            //             $("#select-train-type-no option[index="+(i-1)+"]").remove();
            //         }
            //         $('#add-select-station-name').append("<option value= " + i-1 + ">"+canchiose_trains[i]+"</option>");
            //     }
            // }

            // 异步查询所有火车站名称和列车编号
            $('#add-raliwaytimes-bar').click(function () {
                // 查询车站信息并添加到可选项
                ajax_seachmsg("1","#add-select-station-name");
                // 查询列车信息并添加到可选项
                ajax_seachmsg("2","#add-select-train-id");


                hidden_page(panel3);
            });
//
            function ajax_seachmsg(type,selectId) {
                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/allTrainStation", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: {data:type},
                    success: function (data) {
                        if (  data.falge == 200) {
                            delete_select(selectId);
                            $(selectId).append("<option  disabled selected>-请选择-</option>");
                            for (i = 0; i < data.list.length; i++) {
                                if ($(selectId + " option").size() > i) {
                                    $(selectId+" option[index=" + (i - 1) + "]").remove();
                                }
                                $(selectId).append("<option>" + data.list[i] + "</option>");
                            }
                            //
                            document.getElementById("add-select-start-time").min = data.value;
                            document.getElementById("add-daozan-time").min = data.value;
                        }
                        else{
                            alert("失败了：操作异常！")
                        }
                    }
                });
            }

            // 输入框失去焦点就判断输入的内容是不是数字，如果不是就情况重新输入
            function judgeNaN(elem) {
              var txt=  $("#add-daozan-distance");
              // alert(txt.val());
                if(isNaN(txt.val())){
                    alert("到站距离是一个数字！输入有误，请重新输入！")
                    txt.val("");
                }
            }

            function addStartTime_onblur() {
                // 异步判断时间是否可行

                var time=$("#add-select-start-time").val();

                var trainId=$("#add-select-train-id").find("option:selected").text();;

                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/timeIsTrue", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: {time:time,trainId:trainId},
                    success: function (data) {
                        if ( data != 200) {
                            alert("时间是错误的!时间冲突!");
                            //情况时间，重新输入一个合适的时间
                            $("#add-select-start-time").val("");
                        }
                    }
                });
            }

            function addStartStation_onfoucs(elem) {

                if(hasMsg){
                }
                else{
                    elem.blur();
                    alert("确认始发站、列车车次以及发车时间得到选择后才能添加下一站信息！");
                    $("#sure-msg").onfocus();
                }
            }

            function addNextTime_onfoucs(elem) {
                   if(hasMsg){
                   }
                   else{
                       elem.blur();
                       alert("确认始发站、列车车次以及发车时间得到选择后才能添加下一站信息！");
                       $("#sure-msg").onfocus();
                   }
            }
            function judgeTime() {
                // 异步判断时间是否可行
            }
            function addDistance_onfoucs(elem){
                if(hasMsg){

                }
                else{
                    elem.blur();
                    alert("确认始发站、列车车次以及发车时间得到选择后才能添加下一站信息！");
                    $("#sure-msg").onfocus();
                }
            }
            var hasMsg=false;
            var click_times=1;
            $("#sure-msg").click(function () {
                if(!hasMsg) {
                    var val1 = $("#add-select-start-time").val();
                    var val2 = $("#add-select-station-name").find("option:selected").text();

                    var val3 = $("#add-select-train-id").find("option:selected").text();

                    if (val1 != "" && val2 != "" && val3 != "") {
                        if (confirm("确认后暂时不能进行修改始发站、列车车次以及发车时间!确认执行吗?")) {
                            document.getElementById("add-select-start-time").style.pointerEvents = "none";
                            document.getElementById("add-select-station-name").style.pointerEvents = "none";
                            document.getElementById("add-select-train-id").style.pointerEvents = "none";
                            hasMsg = true;

                            // 下一站可选时间设置不能早于始发时间
                            document.getElementById("add-daozan-time").min = $("#add-select-start-time").val();

                            addOptions();
                        }
                    } else {
                        alert("信息输入不完整！不可确认！请确保始发站、列车车次以及发车时间得到选择！")
                    }
                }
                else{
                    alert("错误的操作：已经确认过了！不要再点了，烦死了！+"+click_times++);
                }
            });

            $("#modify-msg").click(function () {
               if(confirm("确认修改？修改后添加过的信息将被清除！")) {
                   reagain();
               }
            });
            function reagain() {
                document.getElementById("add-select-start-time").style.pointerEvents = "auto";
                document.getElementById("add-select-station-name").style.pointerEvents = "auto";
                document.getElementById("add-select-train-id").style.pointerEvents = "auto";


                document.getElementById('add-select-station-name').children[0].selected=true;
                document.getElementById('add-select-train-id').children[0].selected=true;

                document.getElementById('add-select-nextstation').children[0].selected=true;

                delete_select("#show-once-add-table");
                document.getElementById("show-once-add-table").innerHTML += "<tr><th>下一站</th><th>到站时间</th><th>到站距离</th></tr>";

                hasMsg=false;
                click_times=1;
            }

            function addOptions(){
               delete_select("#add-select-nextstation");
                // 异步添加车站到下拉列表
                ajax_seachmsg("1","#add-select-nextstation");
            }

            // 选择一个下一站，并选择到站时间和填写与上一站之间的距离，单击这个添加按钮后判断是否有站台可选择了

            $("#add-one-trip").click(function(){
                if($("#add-select-nextstation option").size()<=1){
                    alert('无站可选！');
                    return 0;
                }
                if(select_nextstation.value != '' && select_nextdaozantime.value != "" && select_nextdaozandistance.value !='') {

                    var start_var=$("#add-select-station-name").find("option:selected").text();

                    var next_var=$("#add-select-nextstation").find("option:selected").text();

                    var tab = document.getElementById("show-once-add-table");

                    var tab_row=tab.rows.length;

                    if ( !(tab_row == 1 && start_var == next_var)) {

                        var val1 = $("#add-select-nextstation").find("option:selected").text();

                        // 获取选中的车厢类型
                        var val2 = select_nextdaozantime.value;
                        var val3 = select_nextdaozandistance.value;

                        tab.innerHTML += "<tr>\n" +
                            "<td>" + val1 + "</td>\n" +
                            "<td>" + val2 + "</td>" +
                            "<td>" + val3 + "</td>\n" +
                            "</tr>";

                        $("#add-select-nextstation").find("option:selected").remove();
                        select_nextdaozandistance.value = "";
                    }
                    else{
                        alert("第二站不能与始发站相同！错误了！错误了！")
                    }

                    // 设置下一次可选时间不能超过此次被选中的时间
                    document.getElementById("add-daozan-time").min = $("#add-daozan-time").val();
                }
                else{
                    alert("输入不完整！");
                }
            });





            function getdate(){
                va.value;
                train_id.value;
                train_nums.value;
                readTable(tb_chexiangtype);
            }

            //提交本躺列车到服务器
            $("#train-submit").click(function () {
                ajax_trainStatr();
            });


            function ajax_trainStatr() {
                var train_id = 0;

                var t =document.getElementById("show-once-add-table");
                var r = t.rows.length;
                var distances=0;

                for(i=1;i<r;i++){
                    distances = parseInt(distances)+ parseInt(t.rows[i].cells[2].innerText);
                }
                var json_data={train_id: $('#add-select-train-id').find("option:selected").text(),
                    start_station:$('#add-select-station-name').find("option:selected").text(),
                    end_station:t.rows[r-1].cells[0].innerText,
                    start_time:$('#add-select-start-time').val(),
                    end_time:t.rows[r-1].cells[1].innerText,
                    distance:distances};

                // alert(json_data.train_id+"="+json_data.start_station+"="+json_data.end_station+"="+json_data.start_time+"="+json_data.end_time+"="+json_data.distance);

                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/addTrainAndGetTrainNO", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: json_data,
                    success: function (data) {
                        if (0 !== parseInt(data)) {
                            // alert(data);
                            train_id = parseInt(data);


                            //整列车次已成功提交并返回了id标号train_id,开始把分趟路程提交

                            //获取到了本趟列车的编号，本趟列车的编号有数据库子增产生，开始传输每一条列车到站信息

                            //获取表格元素
                            var tab = document.getElementById("show-once-add-table");

                            // 清空这个表格的数据，用来存放新提交并被服务器确认的数据
                            delete_select("#show-submit-all-table");
                            var resoult = document.getElementById("show-submit-all-table");

                            resoult.innerHTML += "<tr><td>发车</td><td>耗时</td><td>到达</td></tr>";
                            //循环遍历表格
                            for (i = 1; i < tab.rows.length; i++) {
                                // for(j=0;j<tab.rows[i].cells.length;j++){

                                var start = "";
                                var start_time = "";

                                var end = tab.rows[i].cells[0].innerText;
                                var end_time = tab.rows[i].cells[1].innerText;

                                var distance = tab.rows[i].cells[2].innerText;
                                //如果遍历到表格的第一列，则始发站就是始发站，否则这里的始发站是上一列的站，下面的发车时间理论上一样，取绝对情况
                                start = (i === 1) ? $("#add-select-station-name").find("option:selected").text() : tab.rows[i - 1].cells[0].innerText;

                                start_time = (i === 1) ? $("#add-select-start-time").val() : tab.rows[i - 1].cells[1].innerText;

                                ajax_onceTrain(train_id, start, end, start_time, end_time, distance);

                            }
                            alert("提交成功了!");
                            //提交成功，阻止继续提交
                            succeed();

                        }
                        else{
                                alert("数据传输失败！链接错误啦！xjh.com-error-message.....");
                        }

                    }
                });
            }


            function ajax_onceTrain(v0,v1,v2,v3,v4,v5) {
                var json_data={train_id:v0,
                    start_station:v1,
                    end_station:v2,
                    start_time:v3,
                    end_time:v4,
                    distance:v5};
                $.ajax({
                    type: "post",                //数据提交方式（post）
                    url: "http://localhost:8080/raliway12307/getData/addOnceOfAllTrains", //提交的数据
                    dataType: "json",           //返回的数据类型格式
                    data: json_data,
                    success: function (data) {
                        if(data.falge == 200){
                            $("#").append();
                            var tab =document.getElementById("show-submit-all-table");
                            tab.innerHTML+="<tr>\n"+
                                    "<td>"+data.list[0]+"</td>\n"+
                                    "<td>"+data.list[1]+"</td>"+
                                    "<td>"+data.list[2]+"</td>"+
                                    "</tr>";
                        }
                    }
                });
            }

            $("#tryagain").click(function () {
                restart();
            });

            function succeed() {
                document.getElementById("train-submit").style.pointerEvents = "none";
            }
            function restart() {

                //情空始发时间
                $("#add-select-start-time").val("");
                //清空输入的到站时间
                $("#add-daozan-time").val("");

                //将始发站信息重置
                reagain();


                delete_select("#show-submit-all-table");
                document.getElementById("show-submit-all-table").innerHTML += "<tr><th>发车</th><th>耗时</th><th>到达</th></tr>";

                document.getElementById("train-submit").style.pointerEvents = "auto";
            }

            function delTr(obj){
                var table =  obj.parentNode.parentNode.parentNode;
                var tr = obj.parentNode.parentNode;
                table.removeChild(tr);
            }

            function readTable(table){
                var arr =new Array();
                var rows=table.rows;
                for(var i=1;i<rows.length;i++){
                    arr[i-1]=new Array();
                    //遍历表格列
                    for(var j=0;j<rows[i].cells.length;j++){
                        arr[i-1][j]=rows[i].cells[j].innerText;
                    }
                }
                return arr;
            }

            // $('#ack-no-seatnum').click(function(){
            //     console.log("==>"+ va.value+":");//得到列车类型
            //     console.log("==>" +train_id.value);
            //     console.log("==>" +train_nums.value);
            //     console.log("==>" +readTable(tb_chexiangtype));
            //     // console.log("==>" +readTable(tb_noseatnum));
            // });

//被调用的方法 、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、

            // 通过隐藏全部再打开一个的方式，实现三个版的跳转
            function hidden_page(page){
                panel1.style.display="none";
                panel2.style.display="none";
                panel3.style.display="none";
                page.style.display="block";
                has_startPoint=false;
            }

            function Obj(arr1,arr2){//自定义对象构造器，然后创建实例
                this.name=arr1;
                this.msg=arr2;
            }
            function getData(){
                var obj=new Obj([],[]);
                obj.name[0]="车次";
                obj.msg[0]=va.value+train_id.value;
                obj.name[1]="车厢数";
                obj.msg[1]=train_nums.value;
                var rows=tb_chexiangtype.rows;
                for(var i=1;i<rows.length;i++){
                    obj.name[i+1]=rows[i].cells[0].innerText+"号车厢";
                    obj.msg[i+1]=rows[i].cells[1].innerText;
                }
                return obj;
            }

            // 清除列表选项
            function delete_select(id){
                var e = document.querySelector(id);
                var first = e.firstElementChild;
                while (first) {
                    first.remove();
                    first = e.firstElementChild;
                    // sleep(100);
                }
            }