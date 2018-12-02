import java.util.*;

public class SetCheck {
    public static void setFromString(String str, Set set) {
        set.addAll(Arrays.asList(str.split(" ")));
    }
    public static void printSet(Set set) {
        Iterator iter = set.iterator();
        System.out.println("\nElements in set:\n-----------------");
        while(iter.hasNext()) {
            System.out.println(iter.next().toString());
        }
    }
    public static Set union(Set set1, Set set2) {
        Set<String> set = new HashSet<>();
        set.addAll(set1);
        set.addAll(set2);
        return set;
    }
    public static Set intersection(Set set1, Set set2) {
        Set<String> set = new HashSet<>();
        Set<String> set0 = new HashSet<>();
        set.addAll(set1);
        set0.addAll(set1);
        set.removeAll(set2);
        set0.removeAll(set);
        return set0;
    }
    public static Set subtraction(Set set1, Set set2) {
        Set<String> set = new HashSet<>();
        Set<String> set01 = new HashSet<>();
        Set<String> set02 = new HashSet<>();
        set01.addAll(set1);
        set02.addAll(set2);
        set.addAll(intersection(set1, set2));
        set01.removeAll(set);
        set02.removeAll(set);
        set01.addAll(set02);
        return set01;
    }
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        String input1 = "A computer's memory can be viewed as a list of cells into which";
        String input2 = "numbers can be placed or read. Each cell has a numbered address";
        setFromString(input1, hashSet);
        setFromString(input2, treeSet);
        System.out.println("-----------------\nSource set 1");
        printSet(hashSet);
        System.out.println("-----------------\nSource set 2");
        printSet(treeSet);
        System.out.println("-----------------\nUnion");
        printSet(union(hashSet, treeSet));
        System.out.println("-----------------\nIntersection");
        printSet(intersection(hashSet, treeSet));
        System.out.println("-----------------\nSubtraction");
        printSet(subtraction(hashSet, treeSet));
    }
}
/* copyright BuchEE */