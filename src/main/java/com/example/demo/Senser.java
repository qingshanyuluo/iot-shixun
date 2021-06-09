package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Senser {

    private String name;

    private double data;

    private String unit;

    private List<Double> historyData = new ArrayList<>();

    public List<Double> history() {
        int length = this.historyData.size();
        if (length < 20) {
            return this.historyData;
        }
        return this.historyData.subList(length - 20, length - 1);
    }

    public Senser(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void record() {
        this.historyData.add(this.data);
    }
}
