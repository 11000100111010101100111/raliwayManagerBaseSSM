package com.yakeManager.controller.managerController.managerAjax;

import com.yakeManager.pojo.User;
import com.yakeManager.pojo.AjaxModel;
import com.yakeManager.pojo.Raliway;
import com.yakeManager.pojo.Ticket;
import com.yakeManager.pojo.TrainList;
import com.yakeManager.service.serviceInterface.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//以下异步操作执行后：成功转态码：200，失败状态码：100，异常状态码：0；

@Controller("managerAjax")
@RequestMapping("/getData")
public class ManagerAjax {
    @Resource(name = "userServiceImpl")
    UserService userService;

    @ResponseBody
    @RequestMapping("/register")
    public int register(@RequestParam("client_id") String  client_id,
                        @RequestParam("client_phone") String client_phone,
                        @RequestParam("client_email") String client_email,
                        @RequestParam("client_name") String client_name,
                        @RequestParam("client_ic") String client_ic,
                        @RequestParam("client_type") String client_type,
                        @RequestParam("signature") String signature) {
        System.out.println("用户注册=============================================================>");
        try{
            Long c_id=Long.parseLong(client_id);
            Long c_p=Long.parseLong(client_phone);
            userService.register(c_id,c_p,client_email,client_name,client_ic,client_type,signature);
            return 200;
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return 0;
        }
    }
    @ResponseBody
    @RequestMapping("/modifyPwd")
    public int modifyPwd(@RequestParam("id")String client_id,@RequestParam("old_pwd") String old_pwd,@RequestParam("new_pwd") String password,HttpSession session){
//        id:$("#c_id").val(),
//                old_pwd:$("#old_pwd").val(),
//                new_pwd: $("#new_pwd").val()
        System.out.println("用户："+client_id+"==执行修改密码：");
        try{
            Long id=Long.parseLong(client_id);
            User user=userService.findUserById(client_id);

            if (old_pwd.equals(user.getPassword())) {
                userService.modifyPwd(id, password);
                session.removeAttribute("client_id");
                System.out.println("密码修改成功！");
                return 2;
            }else{
                System.out.println("密码修改失败，by:原始密码输入不正确！");
                return 1;
            }
        }catch (Exception e){
            System.out.println("密码修改异常===》"+e.getLocalizedMessage());
            return -1;
        }

    }
    @ResponseBody
    @RequestMapping("/hasUserById")
    public int hasUserById(@RequestParam("client_id") String  client_id) {
        System.out.println("判断此id的账号是否注册了=============================================================>");
        System.out.println(client_id);
        try{
            return userService.hasUserById(Long.parseLong(client_id));
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }

//<!--====新增车站信息时========================================================================================================-->

    @ResponseBody
    @RequestMapping("/getPro")
    public AjaxModel<String>  getPro(HttpSession httpSession){
        System.out.println("获取省份=============================================================>");
        AjaxModel<String> pros=new AjaxModel<String>();
        try {
            HashMap<String, List<String>> citys = new HashMap<>();
            ArrayList<String> privonces = userService.findAllProvince();
            for (String pro : privonces) {
                citys.put(pro, userService.findCity(pro));
                System.out.println(pro+":"+userService.findCity(pro));
            }
            httpSession.setAttribute("provinces", privonces);
//            httpSession.setAttribute("citys", citys);
            pros.setFalge(200);
            pros.setList(privonces);
        }
        catch (Exception e){
            pros.setFalge(100);
        }
        return pros;
    }

    @ResponseBody
    @RequestMapping("/getProvince")
    public int  getPrivonce(HttpSession httpSession){
        System.out.println("获取省份=============================================================>");
        int flage=1;
        try {
            HashMap<String, List<String>> citys = new HashMap<>();
            ArrayList<String> privonces = userService.findAllProvince();
            for (String pro : privonces) {
                citys.put(pro, userService.findCity(pro));
                System.out.println(pro+":"+userService.findCity(pro));
            }
            httpSession.setAttribute("provinces", privonces);
//            httpSession.setAttribute("citys", citys);
        }
        catch (Exception e){
            flage=0;
        }
        return flage;
    }

        @ResponseBody
        @RequestMapping("/getCity")
        public AjaxModel<String> getCity( @RequestParam("pro") String data){
            System.out.println("用户城市=============================================================>");
            AjaxModel<String> citys=new AjaxModel<String>();
            try {
                ArrayList<String> City = userService.findAllCityOfProvince(data);
                System.out.print("===>查询"+data+"的省份有：");
                for (String pro : City) {
                    System.out.print(pro);
                    //citys.put(pro, userService.findCity(pro));
                }
                System.out.println();
                citys.setList(City);
                citys.setFalge(200);
            }
            catch (Exception e){
                citys.setFalge(0);
            }

            return citys;
        }

    @ResponseBody
    @RequestMapping("/findElem")
    public int findElem(@RequestParam("stationId") String stationId,
                          @RequestParam("stationName") String stationName){
        int flage=200;
        System.out.println("开始异步判断======>"+stationId+stationName+"是否存在！");
        try {
            flage = userService.findOneElem(stationId,stationName)>0?100:flage;
        }
        catch (Exception e){
            flage=0;
        }
        return flage;
    }

    @ResponseBody
    @RequestMapping("/addStation")
    public int addStation(HttpSession httpSession , @RequestParam("local") String local,
                                        @RequestParam("stationId") String stationId,
                                        @RequestParam("stationName") String stationName){
        int flage=200;
        System.out.println("开始插入======>"+stationId+":"+stationName+":"+local);
        try {
            flage =userService.addCity(stationId,stationName,local)>0?flage:100;
        }
        catch (Exception e){
            flage=0;
        }

        return flage;
    }
    //    <!--====新增列车信息时========================================================================================================-->
    @ResponseBody
    @RequestMapping("/findTrainType")
    public AjaxModel<String> findTrainType(){
        AjaxModel<String> model=new AjaxModel<String>();
        System.out.println("开始查询列车类型======>");
        try {
            model.setList(userService.findTrainType());
            model.setFalge(200);
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage()+"\n===>"+e.toString());
            model.setFalge(0);
        }
        return model;
    }

    @ResponseBody
    @RequestMapping("/judgeTrainId")
    public int judgeTrainId(@RequestParam("train_id") String data,HttpSession session){

        System.out.println("====>"+session.getAttribute("client_id")+",输入了列车的id后想知道id是否已经存在:");
        int flage=200;
        System.out.println("开始查询列车类型======>");
        try {
//            String s=data.substring(0,1)+data.substring(data.indexOf("*")+1,data.length());
            String s=splitStr(data);
            System.out.println("提交的列车id=================>"+s);
            flage=userService.judgeTrainId(s);
        }
        catch (Exception e){
            flage=0;
        }
        return flage;
    }
    public String splitStr(String data){
        String str=data.substring(0,1)+data.substring(data.indexOf("*")+1,data.length());
        return str;
    }
    @ResponseBody
    @RequestMapping("/findSeatType")
    public AjaxModel<String> findSeatType(@RequestParam("data") String traintype,HttpSession session){

        System.out.println("====>"+session.getAttribute("client_id")+",管理员查看了列车的全部座位类型:");
        traintype=traintype.substring(1,traintype.length());
        AjaxModel<String> types = new AjaxModel<String>();
        ArrayList<HashMap<Integer,String>> item = new ArrayList<HashMap<Integer,String>>();
        try{
            types.setList(userService.getSeatTypes());

//            <option value= " +val + ">" +val + "</option>
            types.setFalge(200);
        }
        catch (Exception e){
            types.setFalge(0);
        }
        return types;
    }

    //提交一趟新的列车信息
    @ResponseBody
    @RequestMapping("/submitTrains")
    public void submitTrains(@RequestParam("data") String data,HttpSession session){
        System.out.println("====>"+session.getAttribute("client_id")+",管理员提交了一份列车信息:");
         System.out.println("======>提交的数据："+data);
         String[] str= data.split("\\*");

         try {
             userService.addTrain(str[0].substring(0,1)+str[1],Integer.parseInt(str[2]),Integer.parseInt(str[3]));
         }
         catch (Exception e){}
//         System.out.println("==================================");
    }
    @ResponseBody
    @RequestMapping("/havaTrain")
    public int havaTrain(@RequestParam("train_id") String data,HttpSession session){
        System.out.println("====>"+session.getAttribute("client_id")+",输入的列车id是否已经存在:");
        int flage=200;
        System.out.println("开始查询列车类型======>");
        try {
//            String s=data.substring(0,1)+data.substring(data.indexOf("*")+1,data.length());
            String s=splitStr(data);
            System.out.println("提交的列车id=================>"+s);
            flage=userService.seachThisTrainHave(s);
            System.out.println(flage);
        }
        catch (Exception e){
            flage=0;
        }
        return flage;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    @ResponseBody
    @RequestMapping("/allTrainStation")
    public AjaxModel<String> allTrainStation(@RequestParam("data") String data,HttpSession session){

        System.out.println("====>"+session.getAttribute("client_id")+",管理员开始查找全部车站:");

        AjaxModel<String> request=new AjaxModel<String>();
        ArrayList<String> arr=new ArrayList<String>();
        ArrayList<String> resoult=new ArrayList<String>();
        try{
            System.out.println("==查询开始====================================>");
            if("1".equals(data)){
                arr=userService.findstation();
            }
            else if("2".equals(data)){
                arr=userService.findrailway();
            }

            request.setList(arr);

            System.out.println(request.getList()+":"+request.getFalge());
            request.setFalge(200);
            System.out.println(request.getList()+":"+request.getFalge());
        }
        catch (Exception e){
            System.out.println("error");
            System.out.println(e.getLocalizedMessage()+"\n===>"+e.toString());
            request.setFalge(0);
        }

        Date dt = new Date(); // 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dt);
        calendar.add(calendar.DATE, 1 ); // 把日期往后增加一天.整数往后推,负数往前移动
        dt = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
        String dateString = formatter.format(dt);

        request.setValue(dateString+"T00:00:00");
        System.out.println(request.getValue());

        System.out.println();
        return request;
    }
    @ResponseBody
    @RequestMapping("/getTimeNow")
    public String getTimeNow(HttpSession session){

        System.out.println("====>"+session.getAttribute("client_id")+",想要获取时间:");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar nowTime = Calendar.getInstance();
//        nowTime.add(Calendar.MINUTE, 10);// 把日期往后增加10分钟.

        String dateString = sdf.format(nowTime.getTime());

        System.out.println("=====>获取到时间："+dateString);
        System.out.println("开始发送====》");
        return dateString;
    }

    @ResponseBody
    @RequestMapping("/timeIsTrue")
    public int timeIsTrue(@RequestParam("time")String time,@RequestParam("trainId")String trainId,HttpSession session){
        System.out.println("====>"+session.getAttribute("client_id")+"管理员增加列车时输入了一个时间，想判断数据是否冲突:");
        try{
            ArrayList<HashMap<String,String>> map=userService.judgeTimeStation(trainId);
//            System.out.println(map);
//            　Map map = new HashMap();
            System.out.println("开始查询这个时间的这趟列车是否冲突========>"+time+":"+trainId);
            for (HashMap<String,String > item:map) {
                String star[]=new String[2];
                int i=0;
                for (String key : item.keySet()) {
                    star[i]=item.get(key);

                    System.out.println(star[i]);
                    i++;
                }
                if(!is_noProblem(star[0],star[1],time)){
                    return 100;
                }
            }
            return 200;
        }
        catch (Exception e){
            return 0;
        }
    }
    public boolean is_noProblem(String ago,String after,String time) throws ParseException {
        //0:相同、
        // 1:after比ago大、
        // 2：after比ago小
        int res=0;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //将字符串形式的时间转化为Date类型的时间
        Date a=sdf.parse(ago);
        Date b=sdf.parse(after);
        Date item=sdf.parse(time);
        //如果等于开始时间或者等于结束时间就返回fales,如果在开始时间和结束时间之间就返回false,其他表示不冲突返回true
        return (!item.equals(a) && !item.equals(b)) && (!item.after(a) || !item.before(b));
    }

    @ResponseBody
    @RequestMapping("/addTrainAndGetTrainNO")
    public int addTrainAndGetTrainNO(@RequestParam("train_id") String train_id,
                                     @RequestParam("start_station")String start_station,
                                     @RequestParam("end_station")String end_station,
                                     @RequestParam("start_time")String start_time,
                                     @RequestParam("end_time")String end_time,
                                     @RequestParam("distance")String distance,
                                     HttpSession session){
        System.out.println("====>"+session.getAttribute("client_id")+"管理员增加列车车次并准备获取这趟列车的唯一编号:");
        System.out.println("数据接收，准备写入数据库===>："+train_id+"-"+start_station+"-"+end_station+"-"+start_time+"-"+end_time+"-"+distance);
        try {
            int no=userService.insertTrainRaliway(train_id,
                    start_station,
                    end_station,
                    start_time,
                    end_time,
                    Float.parseFloat(distance));
            System.out.println("===>数据写入数据库，成功！id编号："+no);
            System.out.println("==================================");
            return no;
        }
        catch (Exception e){
            System.out.println("===>写入错误！"+e.toString()+e.getLocalizedMessage());
            System.out.println("==================================");
            return 0;
        }

    }
    @ResponseBody
    @RequestMapping("/addOnceOfAllTrains")
    public AjaxModel<String> addOnceOfAllTrains(@RequestParam("train_id") String train_id,
                                                @RequestParam("start_station")String start_station,
                                                @RequestParam("end_station")String end_station,
                                                @RequestParam("start_time")String start_time,
                                                @RequestParam("end_time")String end_time,
                                                @RequestParam("distance")String distance,
                                                HttpSession session){
        System.out.println("====>"+session.getAttribute("client_id")+"用户进入执行-增加列车的一个分段区间到数据库:");
        TrainList trainList=new TrainList(Integer.parseInt(train_id), start_station, end_station, start_time, end_time,Float.parseFloat( distance));
        return userService.insertAllRaliwayAsOnceString(trainList);
    }
    @ResponseBody
    @RequestMapping("/delData")
    public int delData(String attributeName,HttpSession httpSession){
        try {
            httpSession.removeAttribute(attributeName);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("/findTicket")
    public AjaxModel<ArrayList<String>> findTicket(@RequestParam("start_point") String start_point,
                                                   @RequestParam("end_point") String end_point,
                                                   @RequestParam("time") String time,
                                                   HttpSession session) {

        AjaxModel<ArrayList<String>> arr=new AjaxModel<ArrayList<String>>();
        ArrayList<ArrayList<String>> at=new ArrayList<ArrayList<String>>();
        System.out.println("====>"+session.getAttribute("client_id")+"用户进入查票:");
        try {

            ArrayList<Ticket> trainLists=userService.alltrain(start_point,end_point,time);
            // arr[0]="G2314";
            // arr[1]="南昌西";
            // arr[2]="2020-7-1 6:12:00";
            // arr[3]="上海虹桥";
            // arr[4]=" 2020-7-1 10:12:00";
            // arr[5]="20";商务座
            // arr[6]="56";软卧
            // arr[7]="无";硬卧
            // arr[8]="无";一等座
            // arr[9]="无";二等座
            // arr[10]="85";硬座
            // arr[11]="10";无座
            for (Ticket list:trainLists){
                ArrayList li=new ArrayList();
                li.add(list.getTrain_name());
                li.add(list.getStart_station());
                li.add(list.getStart_time());
                li.add(list.getEnd_station());
                li.add(list.getEnd_time());
                li.add(list.getShanwu_seat());
                li.add(list.getRaungwo_seat());
                li.add(list.getYingwo_seat());
                li.add(list.getSeat_1());
                li.add(list.getSeat_2());
                li.add(list.getYingzuo_seat());
                li.add(list.getNo_seat());
                li.add(list.getUser_strat());
                li.add(list.getUser_end());
                at.add(li);
            }
            System.out.println(start_point+":"+end_point+":"+time);

        arr.setList(at);
        arr.setFalge(200);
        }
        catch (Exception e){
            arr.setFalge(0);
            System.out.println(e.getLocalizedMessage());
        }
        return arr;
    }

    @ResponseBody
    @RequestMapping("/findPrice")
    public Float findPrice(@RequestParam("train_name") String train_name,
                           @RequestParam("seat_type") String seat_type,
                           @RequestParam("client_id") String client_id,
                           @RequestParam("start_point") String start_point,
                           @RequestParam("start_time") String start_time,
                           @RequestParam("end_point") String end_point,
                           HttpSession session){
        System.out.println("=============>用户:"+client_id+",查找了一次价格：");
        Float price=0.0f;
        try {
            price=userService.findTicketPriceAnySeatType(train_name, seat_type, client_id, start_point, start_time, end_point);
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("价格为："+price);
        return price;
    }
    @ResponseBody
    @RequestMapping("/findStationTimes")
    public AjaxModel<String> findStationTimes(@RequestParam("station_name") String station_name,
                         @RequestParam("start_time") String start_time,
                         @RequestParam("start_station") String start_station,
                         @RequestParam("end_station") String end_station,
                                              HttpSession session){
        System.out.println("##====>"+session.getAttribute("client_id")+"用户进入查找自己想要下单的列车车次的始发站和终点站的出发和到站时间:");
        AjaxModel<String> str=new AjaxModel<String>();
        System.out.println("=====>"+station_name+";"+start_time+";"+start_station+";"+end_station);
        try {

            System.out.println("====>"+start_time);
            System.out.println("=============>开始获取时间");
            ArrayList<String> item=new ArrayList<String>();

            String start=userService.findTrainIdByTreanNameAndStartTime(station_name,start_time,start_station);
            item.add(start);

            System.out.println("=============>start"+start);


            String end=userService.findTrainIdByTreanNameAndEndTime(station_name,start_time,end_station);
            item.add(end);

            System.out.println("==========>end"+end);
            str.setList(item);
            str.setFalge(200);
        }
        catch (Exception e){
            str.setFalge(0);
            System.out.println(e.getLocalizedMessage()+":::===>"+e.toString());
            return str;
        }
        return str;
    }

    @ResponseBody
    @RequestMapping("/userHasThisTicket")
    public int userHasThisTicket(@RequestParam("train_name") String train_name,
                                 @RequestParam("time") String time,
                                 @RequestParam("client_id")String client_id,
                                 HttpSession session) {
        String user_id=session.getAttribute("client_id").toString();
        System.out.println("正在判断用户"+user_id+"是否购买了这张票====>");
        try {
//            time=time.replace('T',' ');
            System.out.println(time);
            return userService.userHasThisTicket(train_name,time,client_id);
        }catch (Exception e){
            return 1;
        }
    }


    @ResponseBody
    @RequestMapping("/buyTicket")
    public int buyTicket(@RequestParam("train_name") String train_name,
                         @RequestParam("seat_type") String seat_type,
                         @RequestParam("client_id") String client_id,
                         @RequestParam("start_point") String start_point,
                         @RequestParam("start_time") String start_time,
                         @RequestParam("end_time") String end_time,
                         @RequestParam("end_point") String end_point,
                         HttpSession session){
        System.out.println("====>"+session.getAttribute("client_id")+"用户进入买票:");
        try {
             if(userService.clientBuyTicket(train_name, seat_type, client_id, start_point, start_time, end_time, end_point))
                    return 200;
             else{
                 return 0;
             }
        }
        catch (Exception e){
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("/getAllRaliwayByTime")
    @CrossOrigin
    public AjaxModel<ArrayList<String>> getAllRaliwayByTime(@RequestParam(value = "time")String time,HttpSession session){

        System.out.println("================管理员："+session.getAttribute("client_id")+"，管理员开始查看"+time+"的列车信息：");
        AjaxModel<ArrayList<String>> raliwways=new AjaxModel<ArrayList<String>>();
        System.out.println("====>time:"+time);

        try{
            ArrayList<Raliway> allRaliway=userService.getAllRaliwayByTime(time);
            ArrayList<ArrayList<String>> m=new ArrayList<ArrayList<String>>();
            for (Raliway ral:allRaliway) {
                ArrayList<String> msg=new ArrayList<String>();
                msg.add(ral.getTrain_name());
                msg.add(ral.getStart_time().replace("T","  "));
                msg.add(ral.getStart_point());
                msg.add(ral.getEnd_point());
                msg.add(ral.getAllTime());
                msg.add(""+ral.getTicket_sum());
                msg.add(""+ral.getTicket_cal());
                msg.add(ral.getType());

//                msg.add("G2"+i);
//                msg.add("2021-07-02&nbsp;&nbsp;12:32:59");
//                msg.add("上海虹桥站");
//                msg.add("上海虹桥站");
//                msg.add("两天28小时24分钟");
//                msg.add("1000");
//                msg.add("1000");
//                msg.add("已发出");
//                msg.add("color:green;");

                m.add(msg);
            }
            raliwways.setList(m);
            System.out.println("=======成功");
            raliwways.setFalge(200);

        }catch (Exception e){
            System.out.println("失败");
            System.out.println(e.getLocalizedMessage());
            raliwways.setFalge(0);
        }

        return raliwways;
    }
}
