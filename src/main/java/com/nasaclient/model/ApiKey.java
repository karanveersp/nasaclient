package com.nasaclient.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ApiKey{
    private String key;

    /**
     * Default constructor sets key to NASA's DEMO_KEY
     * This is set when no config file is provided with a
     * developer specific api key.
     */
    public ApiKey(){
        key = "DEMO_KEY";
    }

    public String getKey() {
        return key;
    }
    @JsonSetter("api_key")
    public void setKey(String key) {
        this.key = key;
    }
}