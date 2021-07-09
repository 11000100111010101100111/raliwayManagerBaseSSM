package com.yakeManager.pojo;

public class ClientTicket {
    String client_ic;
    String client_name;
    String train_id;
    String seat_type;
    String start_point;
    String end_point;
    String ticket_state;
    String start_time;
    Long ticket_id;
    Float price;

    public ClientTicket(String client_ic, String client_name, String train_id, String seat_type, String start_point, String end_point, String ticket_state, String start_time, Long ticket_id, Float price) {
        this.client_ic = client_ic;
        this.client_name = client_name;
        this.train_id = train_id;
        this.seat_type = seat_type;
        this.start_point = start_point;
        this.end_point = end_point;
        this.ticket_state = ticket_state;
        this.start_time = start_time;
        this.ticket_id = ticket_id;
        this.price = price;
    }

    public ClientTicket() {
    }

    public String getClient_ic() {
        return client_ic;
    }

    public void setClient_ic(String client_ic) {
        this.client_ic = client_ic;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
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

    public String getTicket_state() {
        return ticket_state;
    }

    public void setTicket_state(String ticket_state) {
        this.ticket_state = ticket_state;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
