package com.yakeManager.service.serviceImpl;

import com.yakeManager.pojo.Client;
import com.yakeManager.pojo.User;
import com.yakeManager.dao.managerDao.ManagerRaliway;
import com.yakeManager.pojo.*;
import com.yakeManager.service.serviceInterface.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource(name = "managerRaliway")
    ManagerRaliway managerRaliway;

    @Override
    public List<String> findProvince() {
        return managerRaliway.findDistinctProvince();
    }

    @Override
    public ArrayList<String> findCity(@Param("province") String province) {
        return  managerRaliway.findCity(province);
    }
    @Override
    public Client getClientMdg(Long client_id){
        return managerRaliway.getClientMdg(client_id);
    }

    @Override
    public int register(Long client_id, Long client_phone, String client_email, String client_name, String client_ic, String client_type, String signature) {
        if(signature.equals("")){
            signature="这个人什么也没有写...";
        }
        if(managerRaliway.register(client_id, client_phone, client_email, client_name, client_ic, client_type, signature)>0){
            managerRaliway.addLoginMsg(client_id);
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public int hasUserById(Long client_id) {
        return managerRaliway.hasUserById(client_id);
    }

    @Override
    public int modifyPwd( Long client_id,String password){
        return managerRaliway.modifyPwd(client_id, password);
    }

    public int hasUser(Long client_id){
        return managerRaliway.hasUser(client_id);
    }
    @Override
    public User findUserById(String uid) {
        try{
            return managerRaliway.findById(Long.parseLong(uid));
        }
        catch (Exception e){
            return new User();
        }
    }

//    @Override
//    public List<String> findTrainByProvinceCity( @Param("province")String province,  @Param("city")String city) {
//        return managerRaliway.findTrainByProvinceCity(province,city);
//    }
//<!--====新增车站信息时========================================================================================================-->
    @Override
    public ArrayList<String> findAllProvince() {
        return managerRaliway.findProvince();
    }

    @Override
    public ArrayList<String> findAllCityOfProvince(String province) {
        return managerRaliway.findAllCityOfProvince(province);
    }

    @Override
    public int findOneElem(String stationId, String stationName) {
        return managerRaliway.findOneElem(stationId,stationName);
    }

    @Override
    public int addCity(String stationId, String stationName, String local) {
        return managerRaliway.addCity(stationId,stationName,local);
    }


    public boolean login(String client_id,String password){
        return findUserById(client_id).getPassword().equals(password);
    }

//    <!--====新增列车信息时========================================================================================================-->
//<!--    查询所有可选择的列车类型和编号，(如：高铁G),为输入列车基本信息的列车类型提供选项-->
    @Override
    public ArrayList<String> findTrainType() {

        ArrayList<Map<String,String>> resoult=managerRaliway.findTrainType();

        ArrayList<String> trains=new ArrayList<String>();

        System.out.println("======>列车类型查找结果：");

        for (int i=0;i<resoult.size();i++){
            String it=resoult.get(i).get("train_code")+resoult.get(i).get("train_type");

            trains.add(it);

            System.out.println(it);
        }

        System.out.println("=======>以上是查找的全部列车类型信息！");

        return trains;
    }

    //<!--根据列车的编号查询此列车编号是否存在，异步判断输入列车编号时输入内容是否可行-->
    @Override
    public int judgeTrainId(String trainId) {
//        查询对象存在则表示错误，返回100，小于0则查询结果为正确
        return managerRaliway.judgeTrainId(trainId)>0?100:200;
    }
    //<!--    查询所有与选定列车类型相关的座位类型，-->
    @Override
    public ArrayList<String> getSeatTypes() {
        ArrayList<String> arr=new ArrayList<String>();

        System.out.println("==========>开始查询座位类型：");
        ArrayList<SeatModel> seats=managerRaliway.getSeatTypes();
        for (SeatModel s:seats) {
//            HashMap item =new HashMap<Integer,String >();
//
//            item.put(s.getSeat_id(),s.getSeat_type()+"+"+s.getSeat_cap()+"+"+s.getUnit_price_km()+"/km");
//            String val=s.getSeat_id()+":"+s.getSeat_type()+" + "+s.getSeat_cap()+"座 + "+s.getUnit_price_km();
            String str=" <option value= " +s.getSeat_id() + ">" +s.getSeat_type()+" + "+s.getSeat_cap()+"座 + "+s.getUnit_price_km()+"/km"+ "</option>";
            arr.add(str);
//            item.clear();
            System.out.println("==>"+s.getSeat_id()+":"+s.getSeat_type()+"+"+s.getSeat_cap()+"+"+s.getUnit_price_km()+"/km");
        }
        System.out.println("===============>查询结束");
        return arr;
    }

    //    <!--增加这列火车到数据库-->
    @Override
    public int addTrain(String train_id, Integer carrage_type_id, Integer carrage_no) {
        return managerRaliway.addTrain(train_id,carrage_type_id,carrage_no);
    }

    //    <!--    执行插入操作后查看插入是否成功，返回被插入的行数-->
    @Override
    public int seachThisTrainHave(String train_id) {
        return managerRaliway.judgeTrainId(train_id);
    }

    //<!--====新增列车车次信息时========================================================================================================-->
//    <!--//查询所有火车站名称集-->
    @Override
    public ArrayList<String> findstation() {
        return managerRaliway.findstation();
    }
    //    <!--//查询所有列车名称集-->
    @Override
    public ArrayList<String> findrailway() {
        return managerRaliway.findrailway();
    }
    //<!--    返回异步查询结果，判断当前时间当前列车是否在运行，主要关注的是当日，一趟列车一日只能发车一次-->
    @Override
    public ArrayList<HashMap<String ,String>> judgeTimeStation(String trainId){
        return managerRaliway.judgeTimeStation(trainId);
    }

    //    <!--    把一条列车始发站和终点站进行插入，并返回本次主键-->
    @Override
    public int insertTrainRaliway(String train_name, String start_point, String terminal, String start_time, String vore_time, Float distance) {

        TrainList trainList=new TrainList(train_name, start_point, terminal, start_time, vore_time, distance);

        managerRaliway.insertTrainRaliway(trainList);

        return trainList.getId();
    }

    //<!--    插入一条分段班次到turned_trains表中-->
//    Integer train_id, String start_station, String end_station, String start_time, String end_time, Float distance
    @Override
    public AjaxModel<String> insertAllRaliwayAsOnceString(TrainList train) {

//        TrainList trainList=new TrainList(train_id, start_station, end_station, start_time, end_time, distance);

        System.out.println("插入一条分段班次到turned_trains表中==================================");
        AjaxModel<String> request =new AjaxModel<String>();
        ArrayList<String> arr=new ArrayList<String>();
        try {
            System.out.println("数据接收，准备写入数据库===>"+train.getId()+"-"+train.getStart_point()+"-"+train.getTremial()+"-"+train.getStart_time()+"-"+train.getVore_time()+"-"+train.getDistance());

            train.setStart_time(train.getStart_time().replace("T"," "));
            train.setVore_time(train.getVore_time().replace("T" ," "));

//            managerRaliway.insertAllRaliwayAsOnceString(Integer.parseInt(train_id),
//                    start_station,
//                    end_station,
//                    start_time,
//                    end_time,
//                    Float.parseFloat(distance));
            managerRaliway.insertAllRaliwayAsOnce(train);

            arr.add(train.getStart_point());

            System.out.println(arr);

            System.out.println("=====>成功插入了一条数据");

            SimpleDateFormat simpleFormat =new SimpleDateFormat("yyyy-MM-dd hh:mm");
            Date start = simpleFormat.parse(train.getStart_time());
            Date end = simpleFormat.parse(train.getVore_time());
            long startT = start.getTime();
            long endT = end.getTime();
            int minutes = (int) ((endT - startT) / (1000 * 60));
            System.out.println("4");
            int H=minutes/60;
            int M=minutes%60;
            int D=H/24;
            H=H%24;

            //当天数不大于0，去除天数，当天数和小时数都不大于于0去除这些0，当分钟不大于0,去除分钟数
            String time= (D>0? D+"天"+H+"小时": H>0? H+"小时" : "")+ (M>0? M+"分钟":"") ;

            arr.add(time);

            arr.add(train.getTremial());

            System.out.println("====》返回数据到客户端：" +train.getStart_point()+"-"+time+"-"+train.getTremial());
            request.setList(arr);
            request.setFalge(200);
        }catch (Exception e){
            request.setFalge(0);
            System.out.println("===>写入错误！"+e.toString()+e.getLocalizedMessage());
        }
        System.out.println("==================================");
        return request;
    }


    @Override
    public AjaxModel<Ticket> findTicket(String startpoint, String endPoint, String time) {
        AjaxModel<Ticket> res=new AjaxModel<Ticket>();

//        SimpleDateFormat simpleFormat =new SimpleDateFormat("yyyy-MM-dd");
//        Date start = simpleFormat.parse(time);
//
//        time=simpleFormat.format(start);
//        System.out.println(time);
//        try {
//
//            ArrayList<Ticket> ts=new  ArrayList<Ticket>();
//
////            managerRaliway.findTicket(startpoint, endPoint, time);
//
//            Ticket tk=managerRaliway.findTicket(startpoint, endPoint, time);
//            ts.add(tk);
//
//            res.setList(ts);
//            System.out.println(res.getList());
//            res.setFalge(200);
//        }
//        catch (Exception e){
//            res.setFalge(0);
//        }
        return res;
    }

//    @Override
//    public ArrayList<HashMap> find_startEndStation(Integer train_id) {
//        return null;
//    }

    public String deleteStr(String item,String str){
        if(item.substring(item.length()-1).equals(str)){
            item=item.substring(0,item.length()-1);
        }

        return item;
    }

    @Override
    public ArrayList<Ticket> alltrain(String startpoint, String endPoint, String time){
        ArrayList<Integer > allTrain=new ArrayList<Integer>();
        SimpleDateFormat simpleFormat =new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;

        try {
            start = simpleFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        time=simpleFormat.format(start);

//        System.out.println(time);

        ArrayList<Integer> canChioseTrain=new ArrayList<Integer>();

        ArrayList<Ticket> tickets=new ArrayList<Ticket>();

        System.out.println(deleteStr(startpoint,"站")+ deleteStr(endPoint,"站"));
//        模糊筛查合适的列车车次、、
        allTrain=managerRaliway.findTicketNO(deleteStr(startpoint,"站"), deleteStr(endPoint,"站"), time);
        System.out.println(startpoint+"=+=+="+endPoint);
        for (Integer trainId:allTrain){
//          对查到的列车车次进行筛选
            String station=judgeTrain(trainId,startpoint,endPoint);
            if(!station .equals("") && station != null){

                //判断发车时间是否超出了当前时间，如果超出直接忽略这张票
                if(isOverNow(managerRaliway.findTrain_time(trainId))){
                    System.out.println("检测到超时票，执行---丢弃");
                    continue;
                }
                System.out.println("======>"+trainId+"符合结果！");
//                筛选结果保存在链表里
                canChioseTrain.add(trainId);


////                根据总票情况进行计算余票余票

                HashMap<String,Integer> reaoult=new HashMap<String,Integer>();

                TrainList itemTicket=new TrainList();

                reaoult =  findOneTicketSeatTypes(trainId);
                itemTicket=findTrainList(trainId);

                String[] user_station=station.split("=");
                tickets.add(new Ticket(
                        itemTicket.getTrain_name(),
                        managerRaliway.findAStationName(itemTicket.getStart_point()),
                        itemTicket.getStart_time(),
                        managerRaliway.findAStationName(itemTicket.getTremial()),
                        itemTicket.getVore_time(),
                        reaoult.get("商务座")==null?0:reaoult.get("商务座"),
                        reaoult.get("软卧")==null?0:reaoult.get("软卧"),
                        reaoult.get("硬卧")==null?0:reaoult.get("硬卧"),
                        reaoult.get("一等座")==null?0:reaoult.get("一等座"),
                        reaoult.get("二等座")==null?0:reaoult.get("二等座"),
                        reaoult.get("硬座")==null?0:reaoult.get("硬座"),
                        reaoult.get("无座")==null?0:reaoult.get("无座"),
                        user_station[0],
                        user_station[1]
                ));
                System.out.println(itemTicket.getTrain_name()+
                        managerRaliway.findAStationName(itemTicket.getStart_point())+
                        itemTicket.getStart_time()+
                        managerRaliway.findAStationName(itemTicket.getTremial())+
                        itemTicket.getVore_time()+""+
                        reaoult.get("商务座")==null?0:reaoult.get("商务座")+""+
                        reaoult.get("软卧")==null?0:reaoult.get("软卧")+""+
                        reaoult.get("硬卧")==null?0:reaoult.get("硬卧")+""+
                        reaoult.get("一等座")==null?0:reaoult.get("一等座")+""+
                        reaoult.get("二等座")==null?0:reaoult.get("二等座")+""+
                        reaoult.get("硬座")==null?0:reaoult.get("硬座")+""+
                        reaoult.get("无座")==null?0:reaoult.get("无座")+"=>"+
                        user_station[0]+"=>"+
                        user_station[1]);
            }
        }
        return tickets;
    }

    //判断用户是否已经购买了这张票
    @Override
    public Integer userHasThisTicket(String client_id,String train_name, String time) {
        System.out.println(client_id+"<==>"+train_name+"<==>"+time);
        Integer ticket_num=managerRaliway.userHasThisTicket(client_id,train_name, time);
        System.out.println("用户购买了"+ticket_num+"张！"+(ticket_num>0?"不符合要求，提示用户此票不能买了！":"符合要求，用户可以下单！")+"");
        return ticket_num;
    }


    public boolean isOverNow(String time){
            if(time.length()<=16)
                time = time+":00";

            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String da = dateFormat.format(date);

//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Calendar nowTime = Calendar.getInstance();
//
//            String now = sdf.format(nowTime.getTime());

            //将字符串形式的时间转化为Date类型的时间
            Date item=new Date();
            try {
                System.out.println(time);
                item=dateFormat.parse(time.replace('T',' '));
                System.out.println(item);
                date=dateFormat.parse(da);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        System.out.println("当前时间："+date.getTime()+"对照时间："+time+",是否超出时间："+item.before(date));
            return item.before(date);
        }

    //    根据列车id找出列车对应所有车厢具备的不同座位类型的数目，以及卖出的所有不同类型座位的车票，并返回不同类型座位的剩余车票情况
    public HashMap<String,Integer> findOneTicketSeatTypes(Integer trainId){
        ArrayList<TrainList> allTypeTickets=managerRaliway.getTrainSeatTypeAndNum(trainId);

        System.out.println("=====>计算这个合适列车的各类座位的总票数1"+allTypeTickets);

        HashMap<String,Integer> allTickets_01=sortSeats(allTypeTickets);

        System.out.println("=====>计算这个合适列车的各类座位的总票数2"+allTickets_01);

//                计算这列合适列车的各类座位的售票数
        ArrayList<String> allScalTickets=managerRaliway.getScalTicket(trainId);
        System.out.println("=====>计算这列合适列车的各类座位的售票数1"+allScalTickets);

        HashMap<String,Integer> allTickets_02 = sortSeatArray(allScalTickets);
        System.out.println("=====>计算这列合适列车的各类座位的售票数2"+allTickets_02);


//                根据总票情况进行计算余票余票
        Set set=allTickets_01.keySet();
        Object[] arr=set.toArray();

        HashMap<String,Integer> reaoult=new HashMap<String,Integer>();
        for(Object key:arr){
            System.out.println(""+key.toString()+"=="+(allTickets_01.get(key)-allTickets_02.get(key)));
            reaoult.put(key.toString(),allTickets_01.get(key)-allTickets_02.get(key));
        }

        return reaoult;
    }
//    根据列车id查询对应车次和始发、终点站以及分别对应的到站时间
    public TrainList findTrainList(Integer trainId){
        TrainList itemTicket=new TrainList();
        try{
            itemTicket=managerRaliway.selectOneTrainById(trainId);
            System.out.println("=======================>"+itemTicket);}
        catch (Exception e){
            System.out.println(e.getLocalizedMessage()+"=="+e.toString());
        }
        return itemTicket;
    }
//    public
    public HashMap<String,Integer> sortSeats(ArrayList<TrainList> arrayList){
        HashMap<String ,Integer > seatType=new HashMap<String,Integer>();
        ArrayList<SeatModel> seatTypes=managerRaliway.getSeatTypes();
        for (TrainList list:arrayList){
            if(seatType.containsKey(list.getTrain_name())){
                seatType.replace(list.getTrain_name(),seatType.get(list.getTrain_name())+list.getIs_run());
            }
            else{
                seatType.put(list.getTrain_name(),list.getIs_run());
            }
        }
        for (SeatModel model:seatTypes){
            if(!seatType.containsKey(model.getSeat_type())){
                seatType.put(model.getSeat_type(),0);
            }
        }
        return sortMap(seatType);
    }
    public HashMap<String,Integer> sortSeatArray(ArrayList<String> arrayList){
        HashMap<String ,Integer > seatType=new HashMap<String,Integer>();
        ArrayList<SeatModel> seatTypes=managerRaliway.getSeatTypes();
        for (String str:arrayList){
            if(seatType.containsKey(str)){
                seatType.replace(str,seatType.get(str)+1);
            }
            else{
                seatType.put(str,1);
            }
        }
        for (SeatModel model:seatTypes){
            if(!seatType.containsKey(model.getSeat_type())){
                seatType.put(model.getSeat_type(),0);
            }
        }
        return sortMap(seatType);
}
    public HashMap<String,Integer> sortMap(HashMap<String,Integer> map){
        Set set=map.keySet();
        HashMap<String,Integer> item=new HashMap<String,Integer>();
        Object[] arr=set.toArray();
        Arrays.sort(arr);
        for(Object key:arr){
            item.put(key.toString(),map.get(key));
        }
        return map;
    }

    //    判断列车是否处于所给区间
    public String judgeTrain(Integer train_id ,String strat_station,String end_Station){

        ArrayList<HashMap> trains = managerRaliway.find_startEndStation(train_id);

        System.out.println("=================>查找到了这些列车区间："+trains);

//        System.out.println(strat_station+":"+end_Station);
        boolean a=false,b = false;
        ArrayList<String> s=new ArrayList<String>();
        for(int i=0;i<trains.size();i++){

            System.out.println(
                    managerRaliway.findAStationName(trains.get(i).get("start_station").toString())+
                            "<===>"+
                            managerRaliway.findAStationName(trains.get(i).get("end_station").toString())
            );

            if(!a && ( managerRaliway.findAStationName(trains.get(i).get("start_station").toString() ).startsWith(strat_station) ) ){
                a=true;
                strat_station = managerRaliway.findAStationName(trains.get(i).get("start_station").toString());
            }
            if(a && (managerRaliway.findAStationName(trains.get(i).get("end_station").toString() ).startsWith(end_Station))){
                b=true;
                end_Station=managerRaliway.findAStationName(trains.get(i).get("end_station").toString() );
                break;
            }
        }
        System.out.println(a&&b?"找到了"+strat_station+"<==>"+end_Station:"没有找到合适的列车区间！");
        return a&&b?strat_station+"="+end_Station:"";
    }


    @Override
    public boolean clientBuyTicket(String train_name,
                                             String seat_type,
                                             String client_id,
                                             String start_point,
                                             String start_time,
                                             String end_time,
                                             String end_point) {
        ArrayList<Integer> carrage_lists=managerRaliway.findOverScalTicketByTrainIdAndSeatType(train_name, seat_type);

        boolean succed=false;

        System.out.println("=====>开始"+carrage_lists);

        System.out.println(train_name+"=="+seat_type+"=="+client_id+"=="+start_point+"=="+start_time+"=="+end_time+"=="+end_point);

        for (Integer carrage_id:carrage_lists){
            Integer nums = managerRaliway.getScalTicketOfReaoultByOnceCarrage(train_name,carrage_id);
            if(nums<managerRaliway.findSeatTypeOfNums(seat_type)){
                //<!--    向列车售出的票表中加入一条买票记录-->

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Calendar nowTime = Calendar.getInstance();

                String now = sdf.format(nowTime.getTime());

                System.out.println("下单时间："+now);
                Integer train_id=managerRaliway.selectTrainByTrainNameAndTime(train_name,start_time.substring(0,10));
               int ni= managerRaliway.addCattageTicket(carrage_id,
                                                now,
                                                nums+1,
                                                train_id);
//                                                managerRaliway.selectSeatTypeIdBySeatName(seat_type));
//                                                managerRaliway.selectTrainByTrainName(train_name));
//sout
                //查出当前列车所有区间站的出发站和到达站以及对应的距离的集合
                ArrayList<TrainList> tr=new ArrayList<TrainList>();

//                String time=start_time.substring(0,10);
                tr=managerRaliway.getDistanceAndSort(train_id);
                boolean a=false;
                Float distance=0.0f;
                for(TrainList t:tr){
                    if(!a && ( start_point.equals( t.getStart_point()) ) ){
                        a=true;
                    }
                    if(a){
                        distance += t.getDistance();
                        if( end_point.equals( t.getTremial()) ){
                            break;
                        }
                    }
                }
                System.out.println("旅途路程是："+distance);
                TrainList ts=managerRaliway.findRateAndUnitPrice(Long.parseLong(client_id),seat_type);
                Float price=ts.getUnit_price()*ts.getDistance()*distance;

                System.out.println("用户购买需要花费的价格是："+distance);

                price = Float.parseFloat(String.format("%.2f", price));

                System.out.println("保存到售出票的表："+ni);
               int ni1= managerRaliway.addClientTickets(carrage_id,
                                                now,
                                                client_id,
                                                start_point,
                                                start_time,
                                                end_time,
                                                end_point,
                                                price,
                                    "正常"
                                                );
                System.out.println("保存到用户购买票的表："+ni1);
                succed=true;
                System.out.println("=======>下单转态"+succed);
                break;
////<!--    向用户买的票表计入这条购买记录-->
//                public int addClientTickets(
//                        @Param("carrage_id") Integer carrage_id,
//                        @Param("order_time")String order_time,
//                        @Param("client_id") String client_id,
//                        @Param("start_point") Integer start_point,
//                        @Param("start_time") String start_time,
//                        @Param("end_time") Integer end_time,
//                        @Param("end_point") String end_point,
//                        @Param("price") Float price,
//                        @Param("ticket_state") String ticket_state
//    );
            }
        }
        return succed;
    }

    @Override
    public Float findTicketPriceAnySeatType(String train_name,
                                   String seat_type,
                                   String client_id,
                                   String start_point,
                                   String start_time,
                                   String end_point) {


        System.out.println("=====>开始查找价格：");

        System.out.println(train_name+"=="+seat_type+"=="+client_id+"=="+start_point+"=="+start_time+"=="+"=="+end_point);

        Float price=0.0f;

        Integer train_id=managerRaliway.selectTrainByTrainNameAndTime(train_name,start_time.substring(0,10));

        //查出当前列车所有区间站的出发站和到达站以及对应的距离的集合
        ArrayList<TrainList> tr=new ArrayList<TrainList>();

        tr=managerRaliway.getDistanceAndSort(train_id);
        boolean a=false;
        Float distance=0.0f;
        for(TrainList t:tr){
            if(!a && ( start_point.equals( t.getStart_point()) ) ){
                a=true;
            }
            if(a){
                distance += t.getDistance();
                if( end_point.equals( t.getTremial()) ){
                    break;
                }
            }
        }
        System.out.println("旅途路程是："+distance);
        TrainList ts=managerRaliway.findRateAndUnitPrice(Long.parseLong(client_id),seat_type);
        price=(ts.getUnit_price()*ts.getDistance()*distance);

        price = Float.parseFloat(String.format("%.2f", price));

        System.out.println("用户购买需要花费的价格是："+ts.getUnit_price()+"*"+ts.getDistance()+"*"+distance+"="+price);

        return price;
    }

    @Override
    public String findTrainIdByTreanNameAndStartTime(String station_name, String start_time, String start_station) {
        return managerRaliway.findTrainIdByTreanNameAndStartTime(station_name, start_time, start_station);
    }

    @Override
    public String findTrainIdByTreanNameAndEndTime(String station_name, String start_time, String end_station) {
        return managerRaliway.findTrainIdByTreanNameAndEndTime(station_name, start_time, end_station);
    }

    //    查询账号为client_id的用户的所有购票信息
    @Override
    public ArrayList<ClientTicket> findClientTicket(String client_id) {
        return managerRaliway.findClientTicket(client_id);
    }

    @Override
    public int backetTicket(String staet_type, Long ticket_id) {
        int re=-1;
        if(managerRaliway.backTicket(ticket_id)>0){
            re=1;
            try {
                managerRaliway.updateClientTicket(ticket_id,staet_type);
                re=2;
            }
            catch (Exception e){
                System.out.println(e.getLocalizedMessage());
                re=-1;
            }
        }
        return re;
    }



    @Override
    public ArrayList<Raliway> getAllRaliwayByTime(String time) {
        ArrayList<Raliway> rals=new ArrayList<Raliway>();
        try {
            rals=managerRaliway.getAllRaliwayByTime(time);
            for (Raliway r:rals) {
                r.setTicket_sum(managerRaliway.getRaliwaySeatSum(r.getTrain_name()));
                r.setTicket_cal(managerRaliway.getRaliwayTickets(r.getTrain_id()));

                Date d1=new Date();
                SimpleDateFormat simpleFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm");

                Date start = simpleFormat.parse(r.getStart_time().replace("T"," "));
                Date end = simpleFormat.parse(r.getEnd_time().replace("T"," "));

                Date now =new Date();
//                      d1=  df.format(r.getStart_time());
                if(start.before(now) && end.after(now)){
                    r.setType("正在运行");
                }else if(end.before(now)){
                    r.setType("已停用");
                }else{
                    r.setType("未发车");
                }
                long startT = start.getTime();
                long endT = end.getTime();
                int minutes = (int) ((endT - startT) / (1000 * 60));
                int H=minutes/60;
                int M=minutes%60;
                int D=H/24;
                H=H%24;

                //当天数不大于0，去除天数，当天数和小时数都不大于于0去除这些0，当分钟不大于0,去除分钟数
                r.setAllTime((D>0? D+"天"+H+"小时": H>0? H+"小时" : "")+ (M>0? M+"分钟":""));
            }

            for (Raliway r:rals) {
                System.out.println(r.toString());
            }
        }catch (Exception e){
            System.out.println("异常："+e.getMessage()+e.getLocalizedMessage());
        }
        return rals;
    }

}
