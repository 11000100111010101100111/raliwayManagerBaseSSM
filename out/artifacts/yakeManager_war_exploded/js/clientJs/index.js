// 开始位置
var seach_start = document.getElementById("seach-start");
// 到站位置
var seach_end = document.getElementById("seach-end");
// 之间的logo，交换开始到站位置
var seach_logo = document.getElementById("seach-logo");
$("#seach-logo").click(function(){
    var star=seach_start.value;
    seach_start.value=seach_end.value;
    seach_end.value=star;
});
// 出发日期
var seach_time=document.getElementById("seach-time");
// 提交按钮
var submit_seach=document.getElementById("seach-sub");


var step3=document.getElementById("step-3");
var step4=document.getElementById("step-4");




$('#find-ticket').click(function () {
    $('html,body').animate({
        scrollTop: $('#my-message').offset().top - 140
    }, 600);
});
$('#buy-ticket').click(function () {
    $('html,body').animate({
        scrollTop: $('#manager-shenqing').offset().top - 140
    }, 600);
});
$('#account-safe-bar input').click(function () {
    $('html,body').animate({
        scrollTop: $('#account-safe').offset().top - 140
    }, 600);
});