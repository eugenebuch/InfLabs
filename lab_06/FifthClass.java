package com.company;

public class FifthClass {
    public static void main(String[] args) {
        Planet planet = new Planet("Uranus", 303.3, 5324.5);
        System.out.println(planet.getName());
        planet.setName("Mars");
        System.out.println(planet.getName());
        System.out.println(planet.toThousandKm("sunDistance"));
        System.out.println(planet.toThousandKm("radius"));
        Satellite satellite = new Satellite("Phobos", 123.4, 542.1);
        planet.getSatelliteInfo(satellite);
        System.out.println("Satellite's period: " + satellite.getPeriod());
        System.out.println("In days: " + satellite.getPeriodInDays() + " days");
        satellite.print();
    }
}
