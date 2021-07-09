
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

document.querySelector("#slocal").onclick =function () {
    document.querySelector("#context4 .provinces").style.visibility="visible";
    $.ajax({
        type: "post",                //数据提交方式（post）
        url: "http://localhost:8080/manager.com/ajax/findlocal", //提交的数据
        dataType: "json",           //返回的数据类型格式
        success: function (data) {
            if (data.statusCode != 1){
                var command=document.querySelector("#context4 .provinces ul");
                var list = command.querySelectorAll("li");

                for (var i = 0; i < list.length; i++) {
                    list[i].remove();
                }
               for(var str=0;str<data.lists.length;str++){
                   command.innerHTML += "<li>"+data.lists[str]+"</li>";
               }
                document.querySelector("#context4 .provinces").style.visibility="visible";
            }else {
                alert("数据库查询失败！服务器未连接！404！")
            }
        }
    });
}
document.querySelector("#context4 .provinces .close").onclick =function (){
    document.querySelector("#context4 .provinces").style.visibility="hidden";
}
// document.getElementById("J_List").innerHTML
//     +="<li>"+_userName+"</li><li>"+userEamil+"</li>" +
//     "<li>"+userPhone+"</li>";
//
//
// Contact.prototype.init = function () {
//
//     console.log("Test");
//
//     var div = document.getElementsByClassName("user-delete");
//
//     var ul = document.querySelector("#J_List");
//
//     var list = ul.querySelectorAll("li");
//
//     for (var i = 0; i < div.length; i++) {
//
//         (function (i) {
//
//             div[i].onclick = function () {
//
//                 list[i].remove();
//
//                 console.log(i);
//
//             }
//
//         })(i);
//
//     }
//
// }
