package com.example.homework.components;

import com.example.homework.controller.ViewsController;
import com.example.homework.objects.Country;
import com.example.homework.objects.Country_;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Configuration
public class AppStartUp {
    @Autowired
    private RestTemplate restTemplate;

    // method to fetch coutries names and keys when application is loaded.
    @PostConstruct
    public void getCountriesKeysAndNamesAtApplicationStartUp() {
        ViewsController.countries = new HashMap<>();
        Object object = restTemplate.getForObject("https://api.covid19tracking.narrativa.com/api/countries", Object.class);
        new HashMap<>();
        if (object != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Country data = objectMapper.convertValue(object, Country.class);
            for (Country_ country : data.getCountries()) {
                ViewsController.countries.put(country.getId(), country.getName());
            }
        }
    }
}
