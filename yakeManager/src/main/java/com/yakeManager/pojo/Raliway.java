package com.yakeManager.pojo;

public class Raliway {
    Long train_id;
    String train_name;
    String start_point;
    String end_point;
    String start_time;
    String end_time;

    public String getAllTime() {
        return allTime;
    }

    public void setAllTime(String allTime) {
        this.allTime = allTime;
    }

    @Override
    public String toString() {
        return "Raliway{" +
                "train_id=" + train_id +
                ", train_name='" + train_name + '\'' +
                ", start_point='" + start_point + '\'' +
                ", end_point='" + end_point + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", allTime='" + allTime + '\'' +
                ", ticket_sum=" + ticket_sum +
                ", ticket_cal=" + ticket_cal +
                ", type='" + type + '\'' +
                '}';
    }

    String allTime;
    int ticket_sum;
    int ticket_cal;
    String type;

    public Raliway() {
    }

    public Raliway(Long train_id, String train_name, String start_point, String end_point, String start_time, String end_time) {
        this.train_id = train_id;
        this.train_name = train_name;
        this.start_point = start_point;
        this.end_point = end_point;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Long getTrain_id() {
        return train_id;
    }

    public void setTrain_id(Long train_id) {
        this.train_id = train_id;
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

    public String getEnd_point() {
        return end_point;
    }

    public void setEnd_point(String end_point) {
        this.end_point = end_point;
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

    public int getTicket_sum() {
        return ticket_sum;
    }

    public void setTicket_sum(int ticket_sum) {
        this.ticket_sum = ticket_sum;
    }

    public int getTicket_cal() {
        return ticket_cal;
    }

    public void setTicket_cal(int ticket_cal) {
        this.ticket_cal = ticket_cal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
