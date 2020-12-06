package com.example.homework.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Statictics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String countryName;
    private String date;
    private int totalCases;
    private int totalDeaths;
    private int newCases;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
