package com.yakeManager.pojo;

public class TrainList {
    Integer id;
    String train_name;
    String start_point;
    String terminal;
    String start_time;
    String vore_time;
    Float distance;
    Float unit_price;

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Float unit_price) {
        this.unit_price = unit_price;
    }

    public TrainList(Float distance, Float unit_price) {
        this.distance = distance;
        this.unit_price = unit_price;
    }

    int is_run;

    public TrainList(String seatType,int seat_num){
        this.train_name=seatType;
        this.is_run=seat_num;
    }
    public TrainList() {
    }

    public TrainList(String start_point, String terminal, Float distance) {
        this.start_point = start_point;
        this.terminal = terminal;
        this.distance = distance;
    }

    public TrainList(String train_name, String start_point, String tremial, String start_time, String vore_time, Float distance) {
        this.train_name = train_name;
        this.start_point = start_point;
        this.terminal = tremial;
        this.start_time = start_time;
        this.vore_time = vore_time;
        this.distance = distance;
    }

    public TrainList( Integer id, String start_point, String tremial, String start_time, String vore_time, Float distance) {
        this.id = id;
        this.start_point = start_point;
        this.terminal = tremial;
        this.start_time = start_time;
        this.vore_time = vore_time;
        this.distance = distance;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getStart_point() {
        return start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public String getTremial() {
        return terminal;
    }

    public void setTremial(String tremial) {
        this.terminal = tremial;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getVore_time() {
        return vore_time;
    }

    public void setVore_time(String vore_time) {
        this.vore_time = vore_time;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public int getIs_run() {
        return is_run;
    }

    public void setIs_run(int is_run) {
        this.is_run = is_run;
    }
}
