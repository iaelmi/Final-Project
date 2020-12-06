package com.example.homework.components;

import com.example.homework.objects.CountryDetail;
import com.example.homework.objects.CountryWrapper;
import com.example.homework.objects.StatsMainWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RestTemplateUtils {
    @Autowired
    private RestTemplate restTemplate;

    public CountryDetail getStats(String country, String date) {
        if (!date.isEmpty() && !country.isEmpty()) {
            Object object = restTemplate.getForObject("https://api.covid19tracking.narrativa.com/api/" + date + "/country/" + country, Object.class);
            if (object != null) {
                ObjectMapper mapper = new ObjectMapper();
                StatsMainWrapper mainStats = mapper.convertValue(object, StatsMainWrapper.class);
                for (Map.Entry<String, CountryWrapper> map : mainStats.getDates().entrySet())
                    for (Map.Entry<String, CountryDetail> map1 : map.getValue().getCountries().entrySet()) {
                        return map1.getValue();
                    }
            }
        }
        return null;
    }
}
