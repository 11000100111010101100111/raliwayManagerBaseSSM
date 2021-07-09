package com.yakeManager.pojo;

import java.util.ArrayList;

public class AjaxModel<T> {
    int falge;
    String value;
    ArrayList<T> list;

    public AjaxModel() {
    }

    public AjaxModel(int falge, String value) {
        this.falge = falge;
        this.value = value;
    }

    public AjaxModel(int falge, String value, ArrayList<T> list) {
        this.falge = falge;
        this.value = value;
        this.list = list;
    }

    public AjaxModel(int falge) {
        this.falge = falge;
    }

    public int getFalge() {
        return falge;
    }

    public void setFalge(int falge) {
        this.falge = falge;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }
}
