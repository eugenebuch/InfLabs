package com.company;

public class Last {
    public static void hanoy(int i, int j, int n, int d) {//i - откуда перенести, j - куда, k и d - диски на i и j стержне
        if (n == 1) {
            System.out.println("Перенос верхнего диска с " + i + " на " + j + " стержень\n");
        }
        else {
            hanoy( i, 6-i-j, n-1, d+1 );
            System.out.println("Перенос верхнего диска с " + i + " на " + j + " стержень");
            hanoy( 6-i-j, j, n-1, d+1 );
        }
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Всего в этом Ханое " + n + " дисков");
        hanoy(1, 3, n, 0);//задача о Ханойских башнях
    }
}
