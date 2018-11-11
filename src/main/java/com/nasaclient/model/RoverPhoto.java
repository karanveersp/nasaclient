package com.nasaclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoverPhoto {

    private String url;
    private String earthDate;
    private int sol;

    public RoverPhoto() {}

    public String getUrl() {
        return url;
    }

    @JsonSetter("img_src")
    public void setUrl(String url) {
        this.url = url;
    }

    public String getEarthDate() {
        return earthDate;
    }

    @JsonSetter("earth_date")
    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public int getSol() {
        return sol;
    }
    public void setSol(int sol) {
        this.sol = sol;
    }


}