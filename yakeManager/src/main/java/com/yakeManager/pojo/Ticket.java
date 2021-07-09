package com.yakeManager.pojo;

public class Ticket {
    Integer train_id;
    String start_station;
    String end_station;
    String start_time;
    String end_time;
    String train_name;

String user_strat;
String user_end;

    public String getUser_strat() {
        return user_strat;
    }

    public void setUser_strat(String user_strat) {
        this.user_strat = user_strat;
    }

    public String getUser_end() {
        return user_end;
    }

    public void setUser_end(String user_end) {
        this.user_end = user_end;
    }

    public Ticket(Integer train_id){
        this.train_id=train_id;
    }
    Ticket(){}
    public Ticket( String train_name, String start_station,  String start_time, String end_station,String end_time, int shanwu_seat,int raungwo_seat,  int yingwo_seat ,int seat_1, int seat_2,int yingzuo_seat, int no_seat,String user_star,String user_end) {
        this.start_station = start_station;
        this.end_station = end_station;
        this.start_time = start_time;
        this.end_time = end_time;
        this.train_name = train_name;
        this.seat_1 = seat_1;
        this.seat_2 = seat_2;
        this.shanwu_seat = shanwu_seat;
        this.raungwo_seat = raungwo_seat;
        this.yingwo_seat = yingwo_seat;
        this.yingzuo_seat = yingzuo_seat;
        this.no_seat = no_seat;
        this.user_strat=user_star;
        this.user_end=user_end;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    Float distance;

    int seat_1;
    int seat_2;
    int shanwu_seat;
    int raungwo_seat;
    int yingwo_seat;

    int yingzuo_seat;
    int no_seat;

    public Ticket(Integer train_id, String start_station, String end_station, String start_time, String end_time) {
        this.train_id = train_id;
        this.start_station = start_station;
        this.end_station = end_station;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Ticket(Integer train_id, String start_station, String end_station, String start_time, String end_time, Float distance) {
        this.train_id = train_id;
        this.start_station = start_station;
        this.end_station = end_station;
        this.start_time = start_time;
        this.end_time = end_time;
        this.distance = distance;
    }

    public Ticket(Integer train_id, String start_station, String end_station, String start_time, String end_time, Float distance, int seat_1, int seat_2, int shanwu_seat, int raungwo_seat, int yingwo_seat, int yingzuo_seat, int no_seat) {
        this.train_id = train_id;
        this.start_station = start_station;
        this.end_station = end_station;
        this.start_time = start_time;
        this.end_time = end_time;
        this.distance = distance;
        this.seat_1 = seat_1;
        this.seat_2 = seat_2;
        this.shanwu_seat = shanwu_seat;
        this.raungwo_seat = raungwo_seat;
        this.yingwo_seat = yingwo_seat;
        this.yingzuo_seat = yingzuo_seat;
        this.no_seat = no_seat;
    }

    public Integer getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Integer train_id) {
        this.train_id = train_id;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public int getSeat_1() {
        return seat_1;
    }

    public void setSeat_1(int seat_1) {
        this.seat_1 = seat_1;
    }

    public int getSeat_2() {
        return seat_2;
    }

    public void setSeat_2(int seat_2) {
        this.seat_2 = seat_2;
    }

    public int getShanwu_seat() {
        return shanwu_seat;
    }

    public void setShanwu_seat(int shanwu_seat) {
        this.shanwu_seat = shanwu_seat;
    }

    public int getRaungwo_seat() {
        return raungwo_seat;
    }

    public void setRaungwo_seat(int raungwo_seat) {
        this.raungwo_seat = raungwo_seat;
    }

    public int getYingwo_seat() {
        return yingwo_seat;
    }

    public void setYingwo_seat(int yingwo_seat) {
        this.yingwo_seat = yingwo_seat;
    }

    public int getYingzuo_seat() {
        return yingzuo_seat;
    }

    public void setYingzuo_seat(int yingzuo_seat) {
        this.yingzuo_seat = yingzuo_seat;
    }

    public int getNo_seat() {
        return no_seat;
    }

    public void setNo_seat(int no_seat) {
        this.no_seat = no_seat;
    }
}
