package CUBE;

public class AccessExample {
    public static void main(String[] args) {
        // обращение к полям с разными режимами доступа
        Cube c = new Cube(5,4,3);
        c.print();
        System.out.println(c.width);
        System.out.println(c.depth);
    }
}