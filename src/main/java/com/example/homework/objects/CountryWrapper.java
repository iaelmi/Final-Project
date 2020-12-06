package com.example.homework.objects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class CountryWrapper {
    private Map<String,CountryDetail> countries;
    private Object info;

    public Map<String, CountryDetail> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, CountryDetail> countries) {
        this.countries = countries;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
