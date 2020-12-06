package com.example.homework.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class StatsMainWrapper {
    private Map<String,CountryWrapper> dates;
    private Object metadata;
    private TotalStats total;
    @JsonProperty("updated_at")
    private String updatedAt;


    public Map<String, CountryWrapper> getDates() {
        return dates;
    }

    public void setDates(Map<String, CountryWrapper> dates) {
        this.dates = dates;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public TotalStats getTotal() {
        return total;
    }

    public void setTotal(TotalStats total) {
        this.total = total;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
