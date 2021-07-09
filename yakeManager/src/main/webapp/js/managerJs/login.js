

                var checkbox = document.getElementById("checkbox1");
                var checked = document.getElementById("gou");
                var pwd = document.getElementById("password");
                var txt = document.getElementById("txt");
                var img = document.querySelector("#img");
                var flage = 0;

                // $("#checkbox1").click(
                // function ck1() {
                //     if (flage == "0") {
                //         pwd.type = 'text';
                //         flage = "1";
                //         checked.style.visibility = "visible;";
                //         img.src = "http://localhost:8080/raliway12307/img/clientImg/loginImg/see.jpg";
                //     }
                //     else {
                //         pwd.type = 'password';
                //         flage = "0";
                //         checked.style.visibility = "hidden;";
                //         img.src = "http://localhost:8080/raliway12307/img/clientImg/loginImg/notsee.jpg";
                //     }
                // }
                // function focus() {
                //     var length = txt.value.length;
                //     if (length <= 0) {
                //         length = 1;
                //     }
                //     else if (length >= 20) {
                //         length = 20;
                //     }
                //     img.src = "http://localhost:8080/raliway12307/img/clientImg/loginImg/" + length + ".jpg";
                // }
                // // txt.onfocus = focus();
                // // txt.onblur =
                // function blur() {
                //     img.src = "http://localhost:8080/raliway12307/img/clientImg/loginImg/10.jpg";
                // }
                //
                // // pwd.onfocus =
                // function pwds() {
                //     if (flage == "0") {
                //
                //         img.src = "http://localhost:8080/raliway12307/img/clientImg/loginImg/notsee.jpg";
                //     }
                //     else {
                //         img.src = "http://localhost:8080/raliway12307/img/clientImg/loginImg/see.jpg";
                //     }
                // }



                function funx() {

                    var data ={client_id:txt.value,password:password.value};

                    if($("#password").val() != "" && $("#txt").val() != "") {
                        $.ajax({
                            type: "post",
                            url: "http://localhost:8080/raliway12307/login/clientLogin",
                            dataType: "json",
                            data: data,
                            success: function (data) {

                                if (data === 200) {
                                    alert("登录成功！");
                                    document.location.href = "http://localhost:8080/raliway12307/";
                                }
                                else if(data === -1 ){
                                    if(confirm("账号："+txt.value+"  不存在！是否去注册？")){
                                        document.location.href = "http://localhost:8080/raliway12307/raliway/toRegister";
                                    }
                                }
                                else{
                                    alert("账号或密码输入有误！");
                                }
                            }
                        });
                    }
                    else {
                        alert("输入不能为空！")
                    }
                }

                $("#register").click(function () {
                    document.location.href = "http://localhost:8080/raliway12307/raliway/toRegister";
                });