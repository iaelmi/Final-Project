/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.homework.components.RestTemplateUtils;
import com.example.homework.components.ServiceComponent;
import com.example.homework.model.Statictics;
import com.example.homework.model.User;
import com.example.homework.objects.*;
import com.example.homework.repository.StatisticsRepo;
import com.example.homework.repository.UserRepo;
import com.example.homework.security.UserDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;


@Controller
public class ViewsController {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplateUtils restUtils;

    @Autowired
    private ServiceComponent service;

    public static Map<String, String> countries;


    // main entry point when user gets authenticated
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView indexView(

    ) {
        ModelAndView model = new ModelAndView("index");
        model.addObject("countries", countries);
        return model;
    }

    // this method fetched data about a country by date and displays in jsp view
    @GetMapping(value = "/stats")
    public ModelAndView countryStatisticsFromOpenAPIs(
            @RequestParam("date") String date,
            @RequestParam("country") String country

    ) {
        ModelAndView model = new ModelAndView("index");
        model.addObject("countries", countries);
        CountryDetail detail = restUtils.getStats(country, date);
        if (detail != null) {
            model.addObject("stats", detail);
            model.addObject("countryName", countries.get(country));
        }
        return model;
    }

    // this method returns login page
    @GetMapping("/loginView")
    public ModelAndView login() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("login", "user", user);
        return modelAndView;
    }

    // this method saves stats data into database
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStatsDB(
            @RequestParam("countryName") String countryName,
            @RequestParam("date") String date,
            @RequestParam("totalCases") Integer totalCases,
            @RequestParam("totalDeaths") Integer totalDeaths,
            @RequestParam("newCases") Integer newCases
    ) {

        service.saveSnippetToDB(countryName, date, totalCases, totalDeaths, newCases);
        return "redirect:/";
    }

    // this method returns jsp page of user management 
    @RequestMapping("/user/manage")
    public ModelAndView userManagementView() {
        ModelAndView model = new ModelAndView("userManage");
        model.addObject("users", userRepo.findAll());
        return model;
    }

    // this method is used to create new user if provided username doesn't exists
    @PostMapping("/create/user")
    public String createUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role
    ) {
        service.createUser(username, password, role);
        return "redirect:/user/manage";
    }

    // this method deletes user from DB
    @PostMapping("/delete/user")
    public String deleteUser(
            @RequestParam("userId") int id
    ) {
        service.deleteUser(id);
        return "redirect:/user/manage";
    }

    // this method returns view of stats management page
    @GetMapping("/manage/stats")
    public ModelAndView manageStatistics() {
        ModelAndView model = new ModelAndView("stats");
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetail.getUsername();
        Optional<User> user = userRepo.findByName(name);
        model.addObject("role", user.get().getRole());
        if (user.isPresent()) {
            List<Statictics> stats = service.getAllStats(user.get());
            if (stats != null && stats.size() > 0) {
                model.addObject("stats", stats);
            }
        }
        return model;
    }

    // this end point is used to update stats data changed by admin
    @PostMapping("/update/stat")
    public String updateStatistics(
            @RequestParam("countryName") String countryName,
            @RequestParam("totalCases") int totalCases,
            @RequestParam("totalDeaths") int totalDeaths,
            @RequestParam("newCases") int newCases,
            @RequestParam("statId") int statId
    ) {
        service.updateSnippetInDB(countryName, totalCases, totalDeaths, newCases, statId);
        return "redirect:/manage/stats";
    }

    // this end point deletes stats record form database
    @GetMapping("/delete/stat")
    public String deleteStatistics(
            @RequestParam("statId") int id
    ) {
        service.deleteSnippeFromDB(id);
        return "redirect:/manage/stats";
    }

}
