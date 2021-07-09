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