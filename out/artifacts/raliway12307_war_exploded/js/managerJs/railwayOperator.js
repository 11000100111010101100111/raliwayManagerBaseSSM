//通过ajax判断用户是否存在
document.getElementsByClassName(".isLogin").onclick = function () {
    //获取表单数据
        $.ajax({
            type: "post",                //数据提交方式（post）
            url: "http://localhost:8080/manager.com/ajax/notLogin", //提交的数据
            dataType: "json",           //返回的数据类型格式
            success: function (data) {
                if (data.statusCode != 1){
                    if(confirm("您还没有登录，是否要跳转到到登录页面？")){
                        //返回到本页
                        window.location.href= "http://localhost:8080/manager.com/manager/home/noUser";
                    }
                }
            }
        });
}