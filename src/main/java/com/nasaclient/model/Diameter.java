package com.nasaclient.model;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Diameter {
    private double min;
    private double max;

    public double getMin() {
        return min;
    }

    @JsonSetter("estimated_diameter_min")
    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    @JsonSetter("estimated_diameter_max")
    public void setMax(double max) {
        this.max = max;
    }
}