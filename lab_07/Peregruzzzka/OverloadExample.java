package Peregruzzzka;

public class OverloadExample {
    public static void main(String[] args) {
        Plant p1 = new Plant();
        Plant p2 = new Plant("tulip", "red");
        Plant p3 = new Plant("cactus");
        p1.print();
        p2.print();
        p3.print();
        Plant p4 = new Plant("Flower", "orange", "Snowy mountains");
        Plant p5 = new Plant("grass", "yellow", true, "Tropics");
        p4.print();
        p5.print();
    }
}
