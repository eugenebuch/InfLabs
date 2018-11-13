package com.company;

public class Planet {
    String name;
    Double radius;
    Double sunDistance;
    Satellite satellite;

    public Planet(String name, Double radius, Double sunDistance) {
        this.name = name;
        this.radius = radius;
        this.sunDistance = sunDistance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double toThousandKm(String param){
        double result = 0;
        switch (param){
            case "sunDistance":
                result = this.sunDistance / 1000;
            case "radius":
                result = this.radius / 1000;
        }
        return result;
    }
    public void getSatelliteInfo(Satellite satellite) {
        this.satellite = satellite;
        this.satellite.print();
    }
}