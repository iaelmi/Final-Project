package com.example.homework.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryDetail {
    public String date;
    public String id;
    public List<Object> links;
    public List<Object> regions;
    public String name;

    @JsonProperty("name_es")
    private String nameEs;
    @JsonProperty("name_it")
    private String nameIt;
    public String source;
    @JsonProperty("today_confirmed")
    private Integer todayConfirmed;
    @JsonProperty("today_deaths")
    private Integer todayDeaths;
    @JsonProperty("today_new_confirmed")
    private Integer todayNewConfirmed;
    @JsonProperty("today_new_deaths")
    private Integer todayNewDeaths;
    @JsonProperty("today_new_open_cases")
    private Integer todayNewOpenCases;
    @JsonProperty("today_new_recovered")
    private Integer todayNewRecovered;
    @JsonProperty("today_open_cases")
    private Integer todayOpenCases;
    @JsonProperty("today_recovered")
    private Integer todayRecovered;
    @JsonProperty("today_vs_yesterday_confirmed")
    private Double todayVsYesterdayConfirmed;
    @JsonProperty("today_vs_yesterday_deaths")
    private Double todayVsYesterdayDeaths;
    @JsonProperty("today_vs_yesterday_open_cases")
    private Double todayVsYesterdayOpenCases;
    @JsonProperty("today_vs_yesterday_recovered")
    private Double todayVsYesterdayRecovered;
    @JsonProperty("yesterday_confirmed")
    private Integer yesterdayConfirmed;
    @JsonProperty("yesterday_deaths")
    private Integer yesterdayDeaths;
    @JsonProperty("yesterday_open_cases")
    private Integer yesterdayOpenCases;
    @JsonProperty("yesterday_recovered")
    private Integer yesterdayRecovered;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public List<Object> getRegions() {
        return regions;
    }

    public void setRegions(List<Object> regions) {
        this.regions = regions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEs() {
        return nameEs;
    }

    public void setNameEs(String nameEs) {
        this.nameEs = nameEs;
    }

    public String getNameIt() {
        return nameIt;
    }

    public void setNameIt(String nameIt) {
        this.nameIt = nameIt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getTodayConfirmed() {
        return todayConfirmed;
    }

    public void setTodayConfirmed(Integer todayConfirmed) {
        this.todayConfirmed = todayConfirmed;
    }

    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Integer getTodayNewConfirmed() {
        return todayNewConfirmed;
    }

    public void setTodayNewConfirmed(Integer todayNewConfirmed) {
        this.todayNewConfirmed = todayNewConfirmed;
    }

    public Integer getTodayNewDeaths() {
        return todayNewDeaths;
    }

    public void setTodayNewDeaths(Integer todayNewDeaths) {
        this.todayNewDeaths = todayNewDeaths;
    }

    public Integer getTodayNewOpenCases() {
        return todayNewOpenCases;
    }

    public void setTodayNewOpenCases(Integer todayNewOpenCases) {
        this.todayNewOpenCases = todayNewOpenCases;
    }

    public Integer getTodayNewRecovered() {
        return todayNewRecovered;
    }

    public void setTodayNewRecovered(Integer todayNewRecovered) {
        this.todayNewRecovered = todayNewRecovered;
    }

    public Integer getTodayOpenCases() {
        return todayOpenCases;
    }

    public void setTodayOpenCases(Integer todayOpenCases) {
        this.todayOpenCases = todayOpenCases;
    }

    public Integer getTodayRecovered() {
        return todayRecovered;
    }

    public void setTodayRecovered(Integer todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    public Double getTodayVsYesterdayConfirmed() {
        return todayVsYesterdayConfirmed;
    }

    public void setTodayVsYesterdayConfirmed(Double todayVsYesterdayConfirmed) {
        this.todayVsYesterdayConfirmed = todayVsYesterdayConfirmed;
    }

    public Double getTodayVsYesterdayDeaths() {
        return todayVsYesterdayDeaths;
    }

    public void setTodayVsYesterdayDeaths(Double todayVsYesterdayDeaths) {
        this.todayVsYesterdayDeaths = todayVsYesterdayDeaths;
    }

    public Double getTodayVsYesterdayOpenCases() {
        return todayVsYesterdayOpenCases;
    }

    public void setTodayVsYesterdayOpenCases(Double todayVsYesterdayOpenCases) {
        this.todayVsYesterdayOpenCases = todayVsYesterdayOpenCases;
    }

    public Double getTodayVsYesterdayRecovered() {
        return todayVsYesterdayRecovered;
    }

    public void setTodayVsYesterdayRecovered(Double todayVsYesterdayRecovered) {
        this.todayVsYesterdayRecovered = todayVsYesterdayRecovered;
    }

    public Integer getYesterdayConfirmed() {
        return yesterdayConfirmed;
    }

    public void setYesterdayConfirmed(Integer yesterdayConfirmed) {
        this.yesterdayConfirmed = yesterdayConfirmed;
    }

    public Integer getYesterdayDeaths() {
        return yesterdayDeaths;
    }

    public void setYesterdayDeaths(Integer yesterdayDeaths) {
        this.yesterdayDeaths = yesterdayDeaths;
    }

    public Integer getYesterdayOpenCases() {
        return yesterdayOpenCases;
    }

    public void setYesterdayOpenCases(Integer yesterdayOpenCases) {
        this.yesterdayOpenCases = yesterdayOpenCases;
    }

    public Integer getYesterdayRecovered() {
        return yesterdayRecovered;
    }

    public void setYesterdayRecovered(Integer yesterdayRecovered) {
        this.yesterdayRecovered = yesterdayRecovered;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
