package com.company;

public class FourthClass {
    public static void main(String[] args) {
        int p = 0;
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                double d = (double) i / 4;
                System.out.print(d+"; "); // вывод в одну строку
            }
        }
        System.out.println();
        int year = 2016;
        switch (year) {
            case 2014:
                System.out.println("You're 3rd year student");
                break;
            case 2015:
                System.out.println("You're 2nd year student");
                break;
            case 2016:
                System.out.println("You're 1st year student");
                break;
        }
        int x2 = 0;
        int x3 = 0;
        int s = 0;
        System.out.println("x1\tx2\tx3\tx1˄x2˅¬x3");
        for (int x1 = 0; x1 < 2; x1++) {
            while (x2 < 2) {
                do {
                    switch(x3) {
                        case 0:
                            s = x1*x2 + 1;
                            break;
                        case 1:
                            s = x1*x2 + 0;
                            break;
                    }
                    if (s > 1) {s = 1;}
                    System.out.println(x1 + "\t" + x2 + "\t" + x3 + "\t\t" + s);
                    x3++;
                } while (x3 < 2);
                x2++;
                x3 = 0;
            }
            x2 = 0;
        }
        System.out.println("\n\n");
        for (int i=7; i > 0; i += 7) {
            if (i > 23 * 3) {break;}
            if (i < 130) {System.out.println(i);}
        }
    }
}
