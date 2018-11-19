package Static;

public class StaticCheck {
    public static void main(String[] args) {
        while (true) {
            StaticContainer.operation();
            if (StaticContainer.counter > 100) {
                System.out.print(StaticContainer.counter);
                break;
            }
        }
    }
}
