package Furniture;

public class InheritanceExample {
    public static void main(String[] args){
        Furniture furniture = new Furniture("wood",2.5);
        furniture.print();
        Chair chair = new Chair("aluminum", 1.3, "beige");
        chair.print();
        System.out.println("toString(): " + chair.toString());
    }
}