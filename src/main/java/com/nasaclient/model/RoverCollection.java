package com.nasaclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoverCollection {
    private RoverPhoto[] photos;

    public RoverCollection() {}

    public RoverPhoto[] getPhotos(){
        return photos;
    }
    public void setPhotos(RoverPhoto[] photos){
        this.photos = photos;
    }
}