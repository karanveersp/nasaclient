package com.nasaclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Apod {

    private String date;
    private String explanation;
    private String hdurl;
    private String title;
    private String url;
    private String mediaType;

    public String getMediaType() {
        return mediaType;
    }
    @JsonSetter("media_type")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getExplanation() {
        return explanation;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getHdurl() {
        return hdurl;
    }
    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }
}