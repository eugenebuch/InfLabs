package com.company;
import java.util.*;

public class ThirdClass {
    public static void main(String[] args) {
        double[] arr = {0.5, 1.3, 2.7, 0.2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[2]);
        System.out.println(arr.length);
        String[] stringArray = "Peter Piper picked a peck of pickled peppers".split(" ");
        System.out.println(Arrays.toString(stringArray));
        System.out.println(stringArray[5]);
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));
        System.out.println("peppers in stringArray: " + Arrays.asList(stringArray).indexOf("peppers"));
    }
}
