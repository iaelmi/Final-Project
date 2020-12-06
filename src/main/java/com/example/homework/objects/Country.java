package com.example.homework.objects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Country {
    private List<Country_> countries = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Country_> getCountries() {
        return countries;
    }

    public void setCountries(List<Country_> countries) {
        this.countries = countries;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
