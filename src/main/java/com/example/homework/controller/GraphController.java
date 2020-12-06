package com.example.homework.controller;

import com.example.homework.service.CanvasjsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/canvasjschart")
public class GraphController {
    @Autowired
    private CanvasjsChartService canvasjsChartService;

    public static String countryName;
    // this method retruns the graphical view of stats stored in the database by country name and user 
    @RequestMapping(method = RequestMethod.GET)
    public String getGraphDataAndView(ModelMap modelMap, @RequestParam(value="country",required = false) String country) {
        List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData(country);
        modelMap.addAttribute("dataPointsList", canvasjsDataList);
        modelMap.addAttribute("countries", canvasjsChartService.getAllSavedCoutriesNames());
        modelMap.addAttribute("country",countryName);
        System.out.println("COuntry : "+country);
        return "chartsView";
    }
}
