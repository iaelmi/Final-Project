package com.example.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
    @JsonProperty("total_cases")
    private Integer totalCases;
    private Integer deaths;
    private Integer recovered;
    private Integer critical;
    private Integer tested;
    @JsonProperty("death_ratio")
    private Double deathRatio;
    @JsonProperty("recovery_ratio")
    private Double recoveryRatio;

    public Integer getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getTested() {
        return tested;
    }

    public void setTested(Integer tested) {
        this.tested = tested;
    }

    public Double getDeathRatio() {
        return deathRatio;
    }

    public void setDeathRatio(Double deathRatio) {
        this.deathRatio = deathRatio;
    }

    public Double getRecoveryRatio() {
        return recoveryRatio;
    }

    public void setRecoveryRatio(Double recoveryRatio) {
        this.recoveryRatio = recoveryRatio;
    }
}
