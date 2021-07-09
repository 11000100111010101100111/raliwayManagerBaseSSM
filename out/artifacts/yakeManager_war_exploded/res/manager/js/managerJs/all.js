
var data= {id:"0"};
function getUser() {
    $.ajax({
        url: "http://localhost:8080/manager.com/ajax/getSession",
        type: "GET",
        data: data,
        dataType: "json",
        success: function (data) {
            // if ("1" == data)
            //     alert("没有登录，去登录！");
        },
        error: function (e) {
            // alert("error:404:服务器无法连接！");
        }
    });
}

var idinput=document.querySelector("#id");

var logindata={userid:"123456"};

function login_id() {
    // logindata.userid=idinput.value;
    data.id=idinput.value;
    $.ajax({
        url:"http://localhost:8080/manager.com/ajax/login_id",
        type:"POST",
        data: data,
        dataType: "json",
        success:function (data) {
            if("0" == data){
                // alert("用户："+idinput.value+"不存在！");
                // idinput.value="";
            }
            else{}
        },
        error: function (e) {
            // alert("error:404:服务器无法连接！");
        }
    });
}

