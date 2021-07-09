package com.yakeManager.dao.managerDao;

import com.yakeManager.pojo.Client;
import com.yakeManager.pojo.User;
import com.yakeManager.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("managerRaliway")
public interface ManagerRaliway {
    public User findById(Long client_id);
    public int hasUser(Long client_id);
    public List<String> findDistinctProvince();

//       <select id="getClientMdg" parameterType="java.lang.String" resultType="com.yakeManager.pojo.Client">
//    select * from yake_client where client_id = #{client_id}
//    </select>
    public Client getClientMdg(@Param("client_id")Long client_id);
    public ArrayList<String> findCity( String province);
//    public List<String> findTrainByProvinceCity(@Param("province") String province,
//

    public int register(@Param("client_id") Long client_id,
                        @Param("client_phone") Long client_phone,
                        @Param("client_email") String client_email,
                        @Param("client_name") String client_name,
                        @Param("client_ic") String client_ic,
                        @Param("client_type") String client_type,
                        @Param("signature") String signature
                         );
    public int addLoginMsg(@Param("client_id") Long client_id);

    public int hasUserById(@Param("client_id") Long client_id);

//     <update id="modifyPwd" >
//    UPDATE client_login SET  client_login.password = #{password} WHERE client_login.client_id = #{client_id}
//    </update>
    public int modifyPwd(@Param("client_id") Long client_id,@Param("password") String password);

//<!--====新增车站信息时========================================================================================================-->
//    <!--    查找所有省份，为管理员在增加车站信息是提供省份选项-->
    public ArrayList<String> findProvince();
//    <!--    根据省份查找当前省份存在的市区及其下属地区-->
    public ArrayList<String> findAllCityOfProvince(@Param("province") String province);
//<!--    根据车站名称或者id查询此车站是否存在，由于异步判断新增车站时输入内容是否可行-->
    public int findOneElem(@Param("stationId") String stationId,@Param("stationName") String stationName);
//    <!--    增加一个车站信息-->
    public int addCity(@Param("stationId") String stationId,@Param("stationName") String stationName,@Param("local") String local);


//<!--====新增列车信息时========================================================================================================-->
//<!--    查询所有可选择的列车类型和编号，(如：高铁G),为输入列车基本信息的列车类型提供选项-->
    public ArrayList<Map<String,String>> findTrainType();

//<!--根据列车的编号查询此列车编号是否存在，异步判断输入列车编号时输入内容是否可行-->
    public int judgeTrainId(@Param("train_id")String trainId);
//<!--    查询所有与选定列车类型相关的座位类型，-->
    public ArrayList<SeatModel> getSeatTypes();
//    <!--增加这列火车到数据库-->
    public int addTrain(@Param("train_id") String train_id,@Param("carrage_type_id") Integer carrage_type_id,@Param("carrage_no")Integer carrage_no);
//    <!--    执行插入操作后查看插入是否成功，返回被插入的行数-->
    public int seachThisTrainHave(@Param("train_id") String train_id);

//<!--====新增列车车次信息时========================================================================================================-->
//    <!--//查询所有火车站名称集-->
public ArrayList<String> findstation();
//    <!--//查询所有列车名称集-->
public ArrayList<String> findrailway();
//<!--    返回异步查询结果，判断当前时间当前列车是否在运行，主要关注的是当日，一趟列车一日只能发车一次-->
    public ArrayList<HashMap<String ,String>> judgeTimeStation(@Param("trainId")String trainId);

//    <!--    把一条列车始发站和终点站进行插入，并返回本次主键-->
    public int insertTrainRaliway(TrainList trainList);
//    public int insertTrainRaliway(@Param("train_name") String train_name,
//                                  @Param("start_point") String start_point,
//                                  @Param("terminal") String terminal,
//                                  @Param("start_time")String start_time,
//                                  @Param("vore_time")String vore_time,
//                                  @Param("distance")Float distance,
//                                  @Param("falge") Integer falge);

//    insert into `train_list` (`train_name`,`start_point`,`terminal`,`start_time`,`vore_time`,`distance`)
//    values (#{train_name},(select `station_id` from `raliwaystation` where `station_name` = #{start_point}),
//            (select `station_id` from `raliwaystation` where `station_name` =  #{terminal}),#{start_time},#{vore_time},#{distance})

    //<!--    插入一条分段班次到turned_trains表中-->
    public int insertAllRaliwayAsOnce(TrainList trainList);
//    public int insertAllRaliwayAsOnce(@Param("train_id") Integer train_id,
//                                      @Param("start_station") String start_station,
//                                      @Param("end_station") String end_station,
//                                      @Param("start_time")String start_time,
//                                      @Param("end_time")String end_time,
//                                      @Param("distance")Float distance);
//        <insert id="insertAllRaliwayAsOnce" >
//    insert into `turned_trains` (`train_id`,`start_station`,`end_station`,`start_time`,`end_time`,`distance`)
//    values (#{train_id},(select `station_id` from `raliwaystation` where `station_name` = #{start_station}),
//            (select `station_id` from `raliwaystation` where `station_name` =  #{end_station}),#{start_time},#{end_time},#{distance})
//    </insert>

//查询相似车站
    public ArrayList<Integer> findTicketNO(@Param("startPoint") String startpoint, @Param("endPoint") String endPoint, @Param("time") String time);

//    查询一趟车经过的站
    public ArrayList<HashMap> find_startEndStation(@Param("train_id")Integer train_id);

//    根据车站编号返回基本信息
    public ArrayList<String> findTicketNO(@Param("train_id") String train_id);

    public ArrayList<String> getOnceTrainMsg(@Param("train_id") String train_id);

//<!--    查找某列火车卖出的票的集合，返回每张票的座位类型集，计算售票数-->
    public ArrayList<String> getScalTicket(@Param("train_id") int train_id);

    //    查找一趟列车各车厢对应座位类型的以及数量
    //    TrainList(String seatType,int seat_num)
    //    this.train_name=seatType;this.is_run=seat_num;
    public ArrayList<TrainList> getTrainSeatTypeAndNum(@Param("train_id") int train_id);

//    <select id="selectTrainById" resultMap="trainMsg">
    public TrainList selectOneTrainById(@Param("train_id") Integer train_id);

//        <select id="findAStationName" parameterType="java.lang.String" resultType="java.lang.String">
//    select station_name from railwaystation where station_id= #{station_id}
//    </select>
    public String findAStationName(@Param("station_id")String station_id);
//    //    查找一趟列车对应某一座位类型的票的总数量
//    public Integer getOnceTicketNums(@Param("train_id") String train_id,@Param("carrage_type") int carrage_type);


   public String findTrain_time(@Param("train_id")Integer train_id);

//        <select id="findTrainIdByTreanNameAndStartTime" resultType="java.lang.String">
    public String findTrainIdByTreanNameAndStartTime(  @Param("station_name") String station_name,
                                                       @Param("start_time") String start_time,
                                                       @Param("start_station") String start_station);

    //        <select id="findTrainIdByTreanNameAndStartTime" resultType="java.lang.String">
    public String findTrainIdByTreanNameAndEndTime(  @Param("station_name") String station_name,
                                                       @Param("start_time") String start_time,
                                                       @Param("end_station") String end_station);

    ///用户买票///////////////////////////////////////////////////////////////////////////////////////////////////////
//    <!--    判断用户是否已经购买了这张票-->
//    <select id="userHasThisTicket" resultType="int" parameterType="java.lang.String">
//    SELECT COUNT(*) FROM client_ticket WHERE client_ticket.ticket_state = '正常' AND (client_ticket.tickets_id IN (
//            SELECT carrage_ticket.ticket_id FROM carrage_ticket WHERE carrage_ticket.train_id IN (
//            SELECT train_list.train_id FROM train_list WHERE train_list.train_name = #{train_name} AND train_list.start_time LIKE concat(#{time},'%') ) ) );
//    </select>
    public Integer userHasThisTicket(@Param("client_id")String client_id,@Param("train_name")String train_name,@Param("time")String time);
//    <!--    查询符合当前提交的座位类型和对应列车车次，查询所有车厢编号-->
    public ArrayList<Integer> findOverScalTicketByTrainIdAndSeatType(@Param("train_name") String train_name,@Param("seat_type") String seat_type);

// <!--查询符合当前提交的座位类型和对应列车车次，查询所有车厢编号后，分别计算不同车厢对应的售票情况，以下查询语句为一节车厢的查询结果-->
    public int getScalTicketOfReaoultByOnceCarrage(@Param("train_name")String train_name,@Param("carrage_id") Integer carrage_id);

    public int selectTrainByTrainName(@Param("train_name")String train_name);

    public int selectTrainByTrainNameAndTime(@Param("train_name")String train_name,@Param("time")String time);

    public int selectSeatTypeIdBySeatName(@Param("seat_type")String seat_type);

//    根据座位类型查找这种座位类型对应一节车厢多少位
    public int findSeatTypeOfNums(@Param("seat_type")String seat_type);
//<!--    向列车售出的票表中加入一条买票记录-->
    public int addCattageTicket(@Param("carrage_id") Integer carrage_id,
                                @Param("order_time") String order_time,
                                @Param("seat_num") Integer seat_num,
                                @Param("train_id") Integer train_id);
//<!--    向用户买的票表计入这条购买记录-->
    public int addClientTickets(
            @Param("carrage_id") Integer carrage_id,
            @Param("order_time")String order_time,
            @Param("client_id") String client_id,
            @Param("start_point") String start_point,
            @Param("start_time") String start_time,
            @Param("end_time") String end_time,
            @Param("end_point") String end_point,
            @Param("price") Float price,
            @Param("ticket_state") String ticket_state
    );

//     <select id="findClientTicket" resultType="com.yakeManager.pojo.ClientTicket" parameterType="java.lang.String">
//    查询账号为client_id的用户的所有购票信息
    public ArrayList<ClientTicket> findClientTicket(@Param("client_id") String client_id);

//        <delete id="backTicket" >
//    DELETE FROM carrage_ticket WHERE ticket_id IN (SELECT tickets_id FROM client_ticket WHERE ticket_id = #{ticket_id})
//    </delete>
//
//    <!--    执行退票后先删除列车售出的票，在修改用户购票记录表中票状态为退票-->
    public int backTicket(@Param("ticket_id")Long ticket_id);
//    <update id="updateClientTicket" parameterType="java.lang.String">
//    UPDATE client_ticket SET ticket_state = #{staet_type} WHERE ticket_id = #{ticket_id}
//    </update>
    public int updateClientTicket(@Param("ticket_id")Long ticket_id,@Param("seat_type")String seat_type);


//     <resultMap id="distanceSortByTime" type="com.yakeManager.pojo.TrainList">
//        <result property="start_point" column="s_name" />
//        <result property="terminal" column="e_name" />
//        <result property="distance" column="distance" />
//    </resultMap>
//    <select id="getDistanceAndSort" parameterType="java.lang.Long" resultMap="distanceSortByTime">
//    SELECT
//            (SELECT station_name FROM railwaystation WHERE station_id = start_station) as s_name,
//         (SELECT station_name FROM railwaystation WHERE station_id = end_station) as e_name,
//            distance
//    FROM turned_trains WHERE train_id = #{train_id} ORDER BY ISNULL(star_time),star_time;
//    </select>

    public ArrayList<TrainList> getDistanceAndSort(@Param("train_id") Integer train_id);

//     <select id="findRateAndUnitPrice" resultType="">
//    SELECT seattype.unit_price_km AS unit_price,client_discount.discount_rate AS rate FROM client_discount,seattype
//    WHERE client_discount.client_type = (SELECT client_type FROM yake_client WHERE client_id = #{client_id}) AND
//    client_discount.seat_type = #{seat_type} AND
//    seattype.seat_type = #{seat_type}
//    </select>
    public TrainList findRateAndUnitPrice(@Param("client_id") Long client_id,@Param("seat_type")String seat_type);


//        <select id="getAllRaliwayByTime" resultMap="ral" parameterType="java.lang.String">
//    SELECT train_list.train_id AS train_id,
//    train_list.train_name AS train_name,
//            (SELECT railwaystation.station_name FROM railwaystation WHERE railwaystation.station_id=train_list.start_point) AS start_point,
//            (SELECT railwaystation.station_name FROM railwaystation WHERE railwaystation.station_id=train_list.terminal) AS end_point,
//    train_list.start_time AS start_time,
//    train_list.vore_time AS end_time
//    FROM train_list,railwaystation,carrage_ticket WHERE start_time LIKE '2021-07-06%';
//    </select>
//    <select id="getRaliwaySeatSum" resultType="int" parameterType="java.lang.String">
//    SELECT SUM(seat_cap) FROM seattype WHERE seat_id IN (SELECT carrage_no FROM carrage WHERE train_id= #{train_name})
//    </select>
//    <select id="getRaliwayTickets" resultType="int" parameterType="java.lang.Long">
//    SELECT COUNT(*) FROM carrage_ticket WHERE train_id = #{train_id}
//    </select>

    public ArrayList<Raliway> getAllRaliwayByTime(@Param("time") String time);
    public int getRaliwaySeatSum(@Param("train_name") String train_name);
    public int getRaliwayTickets(@Param("train_id")Long train_id);
 }
