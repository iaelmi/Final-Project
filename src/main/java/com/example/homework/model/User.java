package com.example.homework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Statictics> statictics;
    public int getId() {
        return id;
    }

    public List<Statictics> getStatictics() {
        return statictics;
    }

    public void setStatictics(List<Statictics> statictics) {
        this.statictics = statictics;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
