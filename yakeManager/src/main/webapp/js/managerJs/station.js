function add_table0(index,arr){
    if(arr[7] === "正在运行")
        arr[8]="style='color:green;font-family:Arial,Helvetica,sans-serif;font:24px \"楷体\"; '";
    else if(arr[7] === "未发车")
        arr[8]="style='color:#666;font-family:Arial,Helvetica,sans-serif;font:24px;'";
    else if( arr[7] === "已停用")
        arr[8]="style='color:red;font-family:Arial,Helvetica,sans-serif;font:24px ;'";

    $("#tab").append("<tr> <td>"+
        arr[0]+"</td> <td>"+
        arr[1]+"</td> <td>"+
        arr[2]+"</td> <td>"+
        arr[3]+"</td> <td>"+
        arr[4]+"</td> <td>"+
        arr[5]+"</td> <td>"+
        arr[6]+"</td> <td "+
        arr[8]+">"+
        arr[7]+"</td></tr>");

}

function addTab() {
    delete_table("tab");
    var array=new Array();
    for (i=0;i<20;i++){
        add_table0(i,array);
    }
}

$('#submit-btn').click(function () {

    if($("#time").val() !== ""){
        delete_table("tab");
        var chioseTime=$("#time").val();
        $.ajax({
            type: "post",                //数据提交方式（post）
            url: "http://localhost:8080/raliway12307/getData/getAllRaliwayByTime", //提交的数据
            dataType: "json",           //返回的数据类型格式
            data:{time:chioseTime},
            success: function (data) {
                if(data.falge == 200){
                    if(data.list.length<=0){
                        alert("暂时没有查到 ["+$("#time").val()+"]  的列车信息！");
                    }else{
                        for(i=0;i<data.list.length;i++){
                            // alert(data.list[i]);
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

// 删除表格中的元素
function delete_table(table_id){
    var tab=document.getElementById(table_id);
    var len=tab.rows.length;
    for(i=len-1;i >0; i--){
        tab.deleteRow(i);
    }
}