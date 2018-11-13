package com.company;

public class Satellite {
    String name;
    Double radius;
    Double period;
    public Double getPeriod() {
        return period;
    }
    public Double getPeriodInDays(){
        return this.getPeriod()*365;
    }
    public void print(){
        System.out.println(this.name+" "+this.period+" "+this.getPeriodInDays()+" "+this.radius);
    }
    public Satellite(String name, Double radius, Double period){
        this.name = name;
        this.radius = radius;
        this.period = period;
    }
}

