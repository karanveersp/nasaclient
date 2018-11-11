package com.nasaclient.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearEarthObject {
    
    private long id;
    private long refId;
    private String name;
    private double absoluteMagnitudeH;
    private Map<String, Diameter> estimatedDiameter;
    private boolean isPotentiallyHazardous;
    private boolean isSentryObject;

    public NearEarthObject() {
    }

    public Map<String, Diameter> getEstimatedDiameter() {
        return estimatedDiameter;
    }

    @JsonSetter("estimated_diameter")
    public void setEstimatedDiameter(Map<String, Diameter> estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNeoRefId() {
        return refId;
    }

    @JsonSetter("neo_reference_id")
    public void setNeoRefId(long neoId) {
        this.refId = neoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getAbsoluteMagnitude() {
        return absoluteMagnitudeH;
    }
    
    @JsonSetter("absolute_magnitude_h")
    public void setAbsoluteMagnitude(double absoluteMagnitudeH) {
        this.absoluteMagnitudeH = absoluteMagnitudeH;
    }

    public boolean getIsPotentiallyHazardous() {
        return isPotentiallyHazardous;
    }

    @JsonSetter("is_potentially_hazardous_asteroid")
    public void setIsPotentiallyHazardous(boolean isPotentiallyHazardous) {
        this.isPotentiallyHazardous = isPotentiallyHazardous;
    }

    
    public boolean getIsSentryObject() {
        return isSentryObject;
    }

    @JsonSetter("is_sentry_object")
    public void setIsSentryObject(boolean isSentry) {
        isSentryObject = isSentry;
    }


    @Override
    public String toString() {
        String str = "id: " + id;
        str += "\n" + "Ref id: " + refId;
        str += "\n" + "Name: " + name;
        str += "\n" + "Potentially Hazardous? " + isPotentiallyHazardous;
        str += "\n" + "Sentry object? " + isSentryObject;
        str += "\n" + "Absolute Magnitude H: " + absoluteMagnitudeH;
        return str;
    }
}