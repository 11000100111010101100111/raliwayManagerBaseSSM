package com.yakeManager.pojo;

public class SeatModel {
    private int seat_id;
    private String seat_type;
    private int seat_cap;
    private float unit_price_km;

    public SeatModel() {
    }

    public SeatModel(int seat_id, String seat_type, int seat_cap, float unit_price_km) {
        this.seat_id = seat_id;
        this.seat_type = seat_type;
        this.seat_cap = seat_cap;
        this.unit_price_km = unit_price_km;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public int getSeat_cap() {
        return seat_cap;
    }

    public void setSeat_cap(int seat_cap) {
        this.seat_cap = seat_cap;
    }

    public float getUnit_price_km() {
        return unit_price_km;
    }

    public void setUnit_price_km(float unit_price_km) {
        this.unit_price_km = unit_price_km;
    }
}
