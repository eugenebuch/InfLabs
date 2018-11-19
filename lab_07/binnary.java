public class binnary {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5};
        int s = 10;

        int length = (int) Math.pow(2, w.length);
        for (int i = 0; i < length; i++) {
            StringBuilder x = new StringBuilder(Integer.toBinaryString(i));
            while (x.length() < w.length) x.insert(0, "0"); //Подгон к длине w
            int sum = 0;
            for (int j = 0; j < w.length; j++) {
                sum += (x.charAt(j) == '1') ? w[j] : 0; //Реализация сигмы
            }
            if (s == sum) {
                System.out.println(x);
                break;
            }
        }
    }

}