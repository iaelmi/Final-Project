package com.example.homework.model;

import java.util.Map;

public class CovidData {
    private Integer status;
    private String type;
    private Map<String,Stats> data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Stats> getData() {
        return data;
    }

    public void setData(Map<String, Stats> data) {
        this.data = data;
    }
}
