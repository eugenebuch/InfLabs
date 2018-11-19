package Peregruzzzka;

public class Plant {
    private String type;
    private String color;
    private String existenceArea;
    private boolean rare;
    public Plant() {}
    public Plant(String type, String color) {
        this.type = type;
        this.color = color;
    }
    public Plant(String type) {
        this.type = type;
    }
    public Plant(String type, String color, boolean rare, String existenceArea) {
        this.type = type;
        this.color = color;
        this.rare = rare;
        this.existenceArea = existenceArea;
    }
    public Plant(String type, String color, String existenceArea) {
        this.type = type;
        this.color = color;
        this.existenceArea = existenceArea;
    }
    public void print(){
        System.out.println("\ntype: " + this.type + "\ncolor: " + this.color
        + "\nrarity: " + this.rare + "\nArea: " + this.existenceArea);
    }
}