package TRIANGLE;

public class StaticExample {
    static int result; // статичный параметр
    public static void main(String[] args){
        int[] array = {-3, 20, 5, 16, 27};
        // итерация по объектам коллекции
        for (int value: array) {
            // тернарный оператор
            result = (value % 4 == 0) ? 1 : 0;
            System.out.println(result);
        }
        Triangle t1 = new Triangle(3);
        Triangle t2 = new Triangle(4);
        Triangle.checkTriangles(t1,t2);
    }
}
