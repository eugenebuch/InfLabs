import javax.swing.plaf.synth.SynthScrollBarUI;
import java.util.*;

public class Research {
    public static class Sample {
        private static int id;
        public Sample(int id) { Sample.id = id; }
        /** Переопределяет метод Object.toString()
         * Возвращает информацию об объекте в формате
         id:..,
         * где вместо многоточия подставляется уникальный
         id
         * текущего объекта, в строковом виде.
         */
        public String toString(){ return "id: " + Sample.id; }
    }
    public static class Lists {
        private Integer size;
        private String type;
        public Lists(Integer size, String type) {
            this.size = size;
            this.type = type;
        }
        public void append(List<String> list) {
            long startTime = System.currentTimeMillis();
            for (int i=0; i<size; i++) {
                Sample elem = new Sample(i);
                list.add("id: " + i);
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\nappend(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void insert(List<String> list) {
            long startTime = System.currentTimeMillis();
            System.out.println("Inserting 5 elements in the middle of list");
            for (int i=0; i<5; i++) {
                list.add(size/2, "id: " + i);
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\ninsert(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void firstElem(List<String> list) {
            long startTime = System.currentTimeMillis();
            System.out.println("FirstElem: " + list.get(0));
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\nfirstElem(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void middleElem(List<String> list) {
            long startTime = System.currentTimeMillis();
            System.out.println("MiddleElem: " + list.get(size/2 - 1));
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\nmiddleElem(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void lastElem(List<String> list) {
            long startTime = System.currentTimeMillis();
            System.out.println("LastElem: " + list.get(size-1));
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\nlastElem(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void contains(List<String> list) {
            long startTime = System.currentTimeMillis();
            int random = (int) (Math.random() * (size*2));
            System.out.println("List contains elem: " + random + "? ");
            String answ = "No";
            for (String aList : list) {
                if (aList.equals("id: " + random)) {
                    answ = "Yes";
                }
            }
            System.out.print(answ);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println("\n" + size + " elements (" + type + ")\ncontains(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void print(List<String> list) {
            long startTime = System.currentTimeMillis();
            System.out.println("List contains that:\n-------------");
            for (String aList : list) {
                System.out.println(aList);
            }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\nprint(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void delByIndex(List<String> list) {
            long startTime = System.currentTimeMillis();
            System.out.println("Deleting element with value 'id: 3'");
            list.remove(list.get(2));
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\ndelByIndex(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void delFirst(List<String> list) {
            long startTime = System.currentTimeMillis();
            list.remove(0);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\ndelFirst(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void delMid(List<String> list) {
            long startTime = System.currentTimeMillis();
            list.remove(size/2 - 1);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\ndelMid(List<Integer> list): "+elapsedTime+" ms\n");
        }
        public void delLast(List<String> list) {
            long startTime = System.currentTimeMillis();
            list.remove(size-1);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(list.size() + " elements (" + type + ")\ndelLast(List<Integer> list): "+elapsedTime+" ms\n");
        }
    }
    public static class Sets {
        private Integer size;
        private String type;
        public Sets(Integer size, String type) {
            this.size = size;
            this.type = type;
        }
        public void append(Set<String> set) {
            long startTime = System.currentTimeMillis();
            for (int i=0; i < size; i++) { set.add("id: " + i); }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(set.size() + " elements (" + type + ")\nappend(Set<String> set): " +elapsedTime+" ms\n");
        }
        public void appendList(Set<String> set, List<String> arrayList) {
            long startTime = System.currentTimeMillis();
            set.addAll(arrayList);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(set.size() + " elements (" + type + ")\nappendList(Set<String> set, List<String> arrayList): " +elapsedTime+" ms\n");
        }
        public void contains(Set<String> set) {
            long startTime = System.currentTimeMillis();
            int random = (int) (Math.random() * (size*2));
            System.out.println("Set contains elem: " + random + "? ");
            String answ = "No";
            for (int i = 0; i < set.size(); i++) {
                if (set.iterator().next().equals("id: " + random)) { answ = "Yes"; }
            }
            System.out.print(answ);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(set.size() + " elements (" + type + ")\ncontains(Set<String> set): " +elapsedTime+" ms\n");
        }
        public void delByValue(Set<String> set) {
            long startTime = System.currentTimeMillis();
            set.remove("id: 7");
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(set.size() + " elements (" + type + ")\ndelByValue(Set<String> set): " +elapsedTime+" ms\n");
        }
        public void delCollection(Set<String> set, List<String> arrayList) {
            long startTime = System.currentTimeMillis();
            set.removeAll(arrayList);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(set.size() + " elements (" + type + ")\ndelCollection(Set<String> set, List<String> arrayList): " +elapsedTime+" ms\n");
        }
        public void print(Set<String> set) {
            long startTime = System.currentTimeMillis();
            System.out.println("Set contains that:\n-------------");
            for (int i = 0; i < set.toArray().length; i++)
                System.out.print( (set.toArray()[i]) + "\n" );
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(set.size() + " elements (" + type + ")\nprint(Set<String> set): " +elapsedTime+" ms\n");
        }
    }
    public static class Maps {
        private Integer size;
        private String type;
        public Maps(Integer size, String type) {
            this.size = size;
            this.type = type;
        }
        public void putter(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            for (int i=0; i < size; i++) { map.put(i, "id: " + i); }
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\nputter(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
        public void listPutter(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            HashMap<Integer, String> addMap = new HashMap<>();
            addMap.put(1000, "id: 9");
            addMap.put(10000, "id: 231");
            map.putAll(addMap);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\nlistPutter(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
        public void getValue(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            System.out.println("Value in map with key '3': " + map.get(3));
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\ngetValue(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
        public void keyContains(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            System.out.println("Is map contains key '6'? " + map.containsKey(6));
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\nkeyContains(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
        public void valueContains(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            System.out.println("Is map contains value 'id: 5'? " + map.containsValue("id: 5"));
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\nvalueContains(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
        public void deleteElem(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            map.remove(9, "id: 8");
            System.out.println("Element ([9], 'id: 8') was deleted from map");
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\ndeleteElem(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
        public void getKeysSet(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            System.out.println(map.keySet());
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\ngetKeysSet(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
        public void getValuesSet(Map<Integer, String> map) {
            long startTime = System.currentTimeMillis();
            System.out.println(map.values());
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(map.size() + " elements (" + type + ")\ngetValuesSet(Map<Integer, String> map): " +elapsedTime+" ms\n");
        }
    }
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Lists arrayListResearch10 = new Lists(10, "ArrayList");
        arrayListResearch10.append(arrayList);
        arrayListResearch10.insert(arrayList);
        arrayListResearch10.firstElem(arrayList);
        arrayListResearch10.middleElem(arrayList);
        arrayListResearch10.lastElem(arrayList);
        arrayListResearch10.contains(arrayList);
        arrayListResearch10.print(arrayList);
        arrayListResearch10.delByIndex(arrayList);
        arrayListResearch10.delFirst(arrayList);
        arrayListResearch10.delMid(arrayList);
        arrayListResearch10.delLast(arrayList);
        System.out.println("------------------------------------");
        LinkedList<String> linkedList = new LinkedList<>();
        Lists linkedListResearch10 = new Lists(10, "LinkedList");
        linkedListResearch10.append(linkedList);
        linkedListResearch10.insert(linkedList);
        linkedListResearch10.firstElem(linkedList);
        linkedListResearch10.middleElem(linkedList);
        linkedListResearch10.lastElem(linkedList);
        linkedListResearch10.contains(linkedList);
        linkedListResearch10.print(linkedList);
        linkedListResearch10.delByIndex(linkedList);
        linkedListResearch10.delFirst(linkedList);
        linkedListResearch10.delMid(linkedList);
        linkedListResearch10.delLast(linkedList);
        System.out.println("------------------------------------");
        ArrayList<String> array = new ArrayList<>();
        array.add("id: 4");
        array.add("id: 7");
        HashSet<String> hashSet = new HashSet<>();
        Sets hashSetResearch10 = new Sets(10, "HashSet");
        hashSetResearch10.append(hashSet);
        hashSetResearch10.appendList(hashSet, array);
        hashSetResearch10.contains(hashSet);
        hashSetResearch10.delByValue(hashSet);
        hashSetResearch10.delCollection(hashSet, array);
        hashSetResearch10.print(hashSet);
        System.out.println("------------------------------------");
        TreeSet<String> treeSet = new TreeSet<>();
        Sets treeSetResearch10 = new Sets(10, "TreeSet");
        treeSetResearch10.append(treeSet);
        treeSetResearch10.appendList(treeSet, array);
        treeSetResearch10.contains(treeSet);
        treeSetResearch10.delByValue(treeSet);
        treeSetResearch10.delCollection(treeSet, array);
        treeSetResearch10.print(treeSet);
        System.out.println("------------------------------------");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        Sets linkSetResearch10 = new Sets(10, "LinkedHashSet");
        linkSetResearch10.append(linkedHashSet);
        linkSetResearch10.appendList(linkedHashSet, array);
        linkSetResearch10.contains(linkedHashSet);
        linkSetResearch10.delByValue(linkedHashSet);
        linkSetResearch10.delCollection(linkedHashSet, array);
        linkSetResearch10.print(linkedHashSet);
        System.out.println("------------------------------------");
        HashMap<Integer, String> hashMap = new HashMap<>();
        Maps hashMapResearch10 = new Maps(10, "HashMap");
        hashMapResearch10.putter(hashMap);
        hashMapResearch10.listPutter(hashMap);
        hashMapResearch10.getValue(hashMap);
        hashMapResearch10.keyContains(hashMap);
        hashMapResearch10.valueContains(hashMap);
        hashMapResearch10.deleteElem(hashMap);
        hashMapResearch10.getKeysSet(hashMap);
        hashMapResearch10.getValuesSet(hashMap);
        System.out.println("------------------------------------");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        Maps treeMapResearch10 = new Maps(10, "TreeMap");
        treeMapResearch10.putter(treeMap);
        treeMapResearch10.listPutter(treeMap);
        treeMapResearch10.getValue(treeMap);
        treeMapResearch10.keyContains(treeMap);
        treeMapResearch10.valueContains(treeMap);
        treeMapResearch10.deleteElem(treeMap);
        treeMapResearch10.getKeysSet(treeMap);
        treeMapResearch10.getValuesSet(treeMap);
        System.out.println("------------------------------------");
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Maps linkedHashMapResearch10 = new Maps(10, "LinkedHashMap");
        linkedHashMapResearch10.putter(linkedHashMap);
        linkedHashMapResearch10.listPutter(linkedHashMap);
        linkedHashMapResearch10.getValue(linkedHashMap);
        linkedHashMapResearch10.keyContains(linkedHashMap);
        linkedHashMapResearch10.valueContains(linkedHashMap);
        linkedHashMapResearch10.deleteElem(linkedHashMap);
        linkedHashMapResearch10.getKeysSet(linkedHashMap);
        linkedHashMapResearch10.getValuesSet(linkedHashMap);
        System.out.println("\n\n\t\tEND OF RESEARCH");
    }
}
