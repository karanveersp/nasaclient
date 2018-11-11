package com.nasaclient.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NeoCollection {

    private int elementCount;
    private HashMap<String, NearEarthObject[]> nearEarthObjects;
    private String[] dates;

    public NeoCollection() {
        
    }

    public int getElementCount() {
        return elementCount;
    }

    
    @JsonSetter("element_count")
    public void setElementCount(int count) {
        elementCount = count;
    }

    public HashMap<String, NearEarthObject[]> getNearEarthObjects() {
        return nearEarthObjects;
    }

    @JsonSetter("near_earth_objects")
    public void setNearEarthObjects(HashMap<String, NearEarthObject[]> neos) {
        nearEarthObjects = neos;
        // Capture date strings which are keys to to the map
        dates = new String[nearEarthObjects.size()];
        dates = nearEarthObjects.keySet().toArray(dates);
    }

    public String[] getDates() {
        return dates;
    }
    
}