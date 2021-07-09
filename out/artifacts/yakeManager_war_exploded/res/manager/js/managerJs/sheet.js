function hidden(str) {
    document.querySelector("#context1").style.visibility="hidden";
    document.querySelector("#context1").style.display="none";
    document.querySelector("#context2").style.visibility="hidden";
    document.querySelector("#context2").style.display="none";
    document.querySelector("#context3").style.visibility="hidden";
    document.querySelector("#context3").style.display="none";
    document.querySelector("#context4").style.visibility="hidden";
    document.querySelector("#context4").style.display="none";
    document.querySelector("#context5").style.visibility="hidden";
    document.querySelector("#context5").style.display="none";
    document.querySelector("#context6").style.visibility="hidden";
    document.querySelector("#context6").style.display="none";
    document.querySelector(str).style.visibility="visible";
    document.querySelector(str).style.display="block";
    // document.getElementById("#id").style.display="none";
    //
    // document.getElementById("#id").style.display="block";
}
document.querySelector("#but1").onclick = function () {
    hidden("#context1");
};
document.querySelector("#but2").onclick = function () {
    hidden("#context2");
};
document.querySelector("#but4").onclick = function () {
    hidden("#context3");
};
document.querySelector("#but5").onclick = function () {
    hidden("#context4");
};
document.querySelector("#but6").onclick = function () {
    hidden("#context5");
};
document.querySelector("#but7").onclick = function () {
    hidden("#context6");
};

var data={lists:['1','2','3']};
document.querySelector("#slocal").onclick =function () {
    document.querySelector("#context4 .provinces").style.visibility="visible";
    $.ajax({
        timeout : 20000,
        type : "GET",
        url : "http://localhost:8080/manager.com/ajax/findlocal",
        data:data,
        success : function(data){
            alert(data);
        },
        // url: "http://localhost:8080/manager.com/ajax/findlocal",
        // type: "post",
        // dataType: "json",
        // data:data,
        // success: function (data) {
        //     alert("0");
        //     if (data != null){
        //         alert("1");
        //         var command=document.querySelector("#context4 .provinces ul");
        //         alert("2");
        //         var list = command.querySelectorAll("li");
        //         alert("3");
        //         for (var i = 0; i < list.length; i++) {
        //             list[i].remove();
        //         }
        //         alert("4");
        //         for(var str=0;str<data;str++){
        //             command.innerHTML += "<li>"+data[str]+"</li>";
        //         }
        //         alert("5");
        //         document.querySelector("#context4 .provinces").style.visibility="visible";
        //     }
        //     else {
        //         alert("数据库查询失败！服务器未连接！404！")
        //     }
        // },
        error:function() {
            alert("404");
        }
    });
}
document.querySelector("#context4 .provinces .close").onclick =function (){
    document.querySelector("#context4 .provinces").style.visibility="hidden";
}