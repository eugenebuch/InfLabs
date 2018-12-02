package Devices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListCheck {
    /**
     * Printing list of elements with specific index
     *
     * Method is executed in {@link #main(String[])}
     *
     * @link printList - printing {@param list} in console
     * @link checkElement - cheking element of List, if elemnt of List % {@param num} == 0 > {@return true}
     * @return a list with a specific index defined in {@link #checkElement}
     */
    public static void printList(List<Device> list) {
        System.out.println("Array contains that:");
        for (int i = 0; i < list.size(); i++) {
            if (checkElement(list, list.get(i), 5)) {
                System.out.println("\t[" + i + "] element:\n" + list.get(i).string);
            }
        }
    }
    public static void printListWithIterator(List<Device> list) {
        Iterator iterator = list.iterator();
        System.out.println("\tWITH ITERATOR\nArray contains that:");
        while(iterator.hasNext()) {
            if (checkElement(list, (Device)iterator.next(), 5)) {
                System.out.println("\tElement:\n" + ((Device)iterator.next()).string);
            }
        }
    }
    public static boolean checkElement(List<Device> list, Device elem, Integer num) {
        if (list.get(list.indexOf(elem)).string == null) {
            System.out.println("THERE IS NULL ELEMENT IN ARRAY ON POS [" + list.indexOf(elem) + "]!!!\n");
            return false;
        }
        if (list.indexOf(elem)%num == 0) { return true; }
        else { return false; }
    }
    public static void main(String[] args) {
        List<Device> arrayList = new ArrayList<>();
        List<Device> linkedList = new LinkedList<>();
        for(int i = 0; i < 50; i++) {
            double x = i;
            if (i == 40) {
                Device dev = new Device(null, null);
                arrayList.add(dev);
                linkedList.add(dev);
            }
            else {
                Device dev = new Device(i + 255, x);
                arrayList.add(dev);
                linkedList.add(dev);
            }
        }
        printList(arrayList);
        printList(linkedList);
        System.out.println("----------------------------------------------------");
        printListWithIterator(arrayList);
        printListWithIterator(linkedList);
    }
}
/* copyright BuchEE */