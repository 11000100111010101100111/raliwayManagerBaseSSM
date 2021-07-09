package com.yakeManager.service.serviceInterface;

import com.yakeManager.pojo.Client;
import com.yakeManager.pojo.User;
import com.yakeManager.pojo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public interface UserService {
    public List<String> findProvince();
    public ArrayList<String> findCity(String province);
    public User findUserById(String uid);
//    public List<String> findTrainByProvinceCity(String province,String city);
public int hasUser(Long client_id);
    public Client getClientMdg(Long client_id);
    public int register(Long client_id,
                        Long client_phone,
                        String client_email,
                        String client_name,
                        String client_ic,
                        String client_type,
                        String signature
    );
    public int hasUserById(Long client_id);

    public int modifyPwd( Long client_id,String password);

//<!--====新增车站信息时========================================================================================================-->
    public ArrayList<String> findAllProvince();
    public ArrayList<String> findAllCityOfProvince(String province);
    public int findOneElem(String stationId,String stationName);
    public int addCity(String stationId,String stationName,String local);

    boolean login(String client_id,String password);


//    <!--====新增列车信息时========================================================================================================-->
//<!--    查询所有可选择的列车类型和编号，(如：高铁G),为输入列车基本信息的列车类型提供选项-->
    public ArrayList<String> findTrainType();

    //<!--根据列车的编号查询此列车编号是否存在，异步判断输入列车编号时输入内容是否可行-->
    public int judgeTrainId(String trainId);
    //<!--    查询所有与选定列车类型相关的座位类型，-->
    public ArrayList<String> getSeatTypes();

    //    <!--增加这列火车到数据库-->
    public int addTrain(String train_id,Integer carrage_type_id,Integer carrage_no);
    //    <!--    执行插入操作后查看插入是否成功，返回被插入的行数-->
    public int seachThisTrainHave(String train_id);


    //<!--====新增列车车次信息时========================================================================================================-->
//    <!--//查询所有火车站名称集-->
    public ArrayList<String> findstation();
    //    <!--//查询所有列车名称集-->
    public ArrayList<String> findrailway();
    //<!--    返回异步查询结果，判断当前时间当前列车是否在运行，主要关注的是当日，一趟列车一日只能发车一次-->
    public ArrayList<HashMap<String ,String>> judgeTimeStation(String trainId);
    //    <!--    把一条列车始发站和终点站进行插入，并返回本次主键-->
    public int insertTrainRaliway(String train_name,String start_point,String terminal,String start_time,String vore_time,Float distance);
    //<!--    插入一条分段班次到turned_trains表中-->
    public AjaxModel<String> insertAllRaliwayAsOnceString(TrainList trainList);
//    public int insertAllRaliwayAsOnceString (Integer train_id,String start_station,String end_station,String start_time,String end_time,Float distance);


    public AjaxModel<Ticket> findTicket(String startpoint, String endPoint, String time);

//    public ArrayList<HashMap> find_startEndStation(Integer train_id);

    //等到符合查找条件的列车列表
    public ArrayList<Ticket> alltrain(String startpoint, String endPoint, String time);

//    //获得一趟列车的出票与余票情况
//    public ArrayList<String> getOnceTrainMsg();

    //===用户买票时=================================================================================================================================

    //判断用户是否已经购买了这张票
    public Integer userHasThisTicket(String client_id,String train_name, String time);

    //    <!--    查询符合当前提交的座位类型和对应列车车次，查询所有车厢编号-->
//    public int findOverScalTicketByTrainIdAndSeatType(@Param("train_name") String train_name,@Param("seat_type") String seat_type);
//
//    //        <!--查询符合当前提交的座位类型和对应列车车次，查询所有车厢编号后，分别计算不同车厢对应的售票情况，以下查询语句为一节车厢的查询结果-->
//    public int getScalTicketOfReaoultByOnceCarrage(@Param("train_name")String train_name,@Param("carrage_id") Integer carrage_id);
//
//    //<!--    向列车售出的票表中加入一条买票记录-->
//    public int addCattageTicket(@Param("carrage_id") Integer carrage_id,
//                                @Param("order_time") String order_time,
//                                @Param("seat_num") Integer seat_num,
//                                @Param("train_id") String train_id);
//    //<!--    向用户买的票表计入这条购买记录-->
//    public int addClientTickets(
//            @Param("carrage_id") Integer carrage_id,
//            @Param("order_time")String order_time,
//            @Param("client_id") String client_id,
//            @Param("start_point") Integer start_point,
//            @Param("start_time") String start_time,
//            @Param("end_time") Integer end_time,
//            @Param("end_point") String end_point,
//            @Param("price") Float price,
//            @Param("ticket_state") String ticket_state
//    );

    public String findTrainIdByTreanNameAndStartTime( String station_name,String start_time,String start_station);

    //        <select id="findTrainIdByTreanNameAndStartTime" resultType="java.lang.String">
    public String findTrainIdByTreanNameAndEndTime(String station_name, String start_time,String end_station);

    public boolean clientBuyTicket(String train_name,
                                             String seat_type,
                                             String client_id,
                                             String start_point,
                                             String start_time,
                                             String end_time,
                                             String end_point);

    //    查询账号为client_id的用户的所有购票信息
    public ArrayList<ClientTicket> findClientTicket(String client_id);

    public int backetTicket(String staet_type,Long ticket_id);

    //查找购买对应座位类型的价格
    public Float findTicketPriceAnySeatType(String train_name,
                                            String seat_type,
                                            String client_id,
                                            String start_point,
                                            String start_time,
                                            String end_point);

    public ArrayList<Raliway> getAllRaliwayByTime(String time);
}
