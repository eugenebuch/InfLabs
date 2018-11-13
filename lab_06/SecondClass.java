package com.company;

public class SecondClass {
    public static void main(String[] args) {
        String s = "13.7";
        Double a = new Double(s);
        char c = "qwe".charAt(2); // символ со 2 позиции
        System.out.println(a);
        System.out.println(c);
        int is = new Integer("135");
        System.out.println(is);
        is = Integer.parseInt("135");
        System.out.println(is);
        s = "Java is one of the best languages!";
        System.out.println("Символ на 5й позиции: " + s.charAt(5));
        System.out.println("Сравнение строк: " + (s == "Java is one of the most beautifull languages!"));
        System.out.println("Поиск слова 'best': " + s.indexOf("best"));
    }
}
