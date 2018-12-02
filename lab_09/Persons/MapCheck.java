package Persons;

import java.util.*;

public class MapCheck {
    public Map setMap(List<Person> list, Map<Integer, ArrayList<Person>> map) {
        for (int i=0; i<list.size(); i++) {
            if (map.containsKey(list.get(i).getBirthday().get(Calendar.YEAR))) {
                map.get(list.get(i).getBirthday().get(Calendar.YEAR)).add(list.get(i));
            }
            else {
                ArrayList<Person> array = new ArrayList<>();
                array.add(list.get(i));
                map.put(list.get(i).getBirthday().get(Calendar.YEAR), array);
            }
        }
        return map;
    }
    public void compareMaps(Map<Integer, ArrayList<Person>> hash,
                            Map<Integer, ArrayList<Person>> tree,
                            Map<Integer,ArrayList<Person>> linked) {
        for (Map.Entry entry: hash.entrySet()) {
            System.out.println("\n-----------------\n\tPEOPLE WHO BORN IN YEAR " + entry.getKey());
            System.out.println("----------------\n\t\tHashMap\t\t|\t\tTreeMap\t\t|\t\tLinkedHashMap");
            for (int i=0; i < hash.get(entry.getKey()).size(); i++) {
                System.out.println("\t"+hash.get(entry.getKey()).get(i).getFIO()+"\t|\t"+tree.get(entry.getKey()).get(i).getFIO()+
                        "\t|\t"+linked.get(entry.getKey()).get(i).getFIO());
            }
        }
    }
    public static void main(String[] args) {
        MapCheck mapper = new MapCheck();
        ArrayList<Person> persons = new ArrayList<>();
        Map<Integer,ArrayList<Person>> hashMap = new HashMap<>();
        Map<Integer,ArrayList<Person>> treeMap = new TreeMap<>();
        Map<Integer,ArrayList<Person>> linkedHashMap=new LinkedHashMap<>();
        Calendar bd1 = new GregorianCalendar(1980, 5, 23);
        Calendar bd2 = new GregorianCalendar(1989, 5, 10);
        Calendar bd3 = new GregorianCalendar(2000, 11, 17);

        Person guy1 = new Person();
        guy1.setFirstname("Aleksey");
        guy1.setLastname("Navalny");
        guy1.setMiddlename("Anatolevich");
        guy1.setBirthday(bd1);
        persons.add(guy1);
        Person guy2 = new Person();
        guy2.setFirstname("Alexander");
        guy2.setLastname("Moskovcev");
        guy2.setMiddlename("Grigorevich");
        guy2.setBirthday(bd1);
        persons.add(guy2);
        Person guy3 = new Person();
        guy3.setFirstname("Boris");
        guy3.setLastname("Koblevich");
        guy3.setMiddlename("Anatolevich");
        guy3.setBirthday(bd1);
        persons.add(guy3);

        Person guy4 = new Person();
        guy4.setFirstname("Oleg");
        guy4.setLastname("Nevskiy");
        guy4.setMiddlename("Nikolaevich");
        guy4.setBirthday(bd2);
        persons.add(guy4);
        Person guy5 = new Person();
        guy5.setFirstname("Gennadiy");
        guy5.setLastname("Buchenkov");
        guy5.setMiddlename("Evgenevich");
        guy5.setBirthday(bd2);
        persons.add(guy5);
        Person guy6 = new Person();
        guy6.setFirstname("Ilya");
        guy6.setLastname("Maddyson");
        guy6.setMiddlename("Korolevich");
        guy6.setBirthday(bd2);
        persons.add(guy6);

        Person guy7 = new Person();
        guy7.setFirstname("Vyacheslav");
        guy7.setLastname("Orbitovsky");
        guy7.setMiddlename("Olegovich");
        guy7.setBirthday(bd3);
        persons.add(guy7);
        Person guy8 = new Person();
        guy8.setFirstname("Mikhail");
        guy8.setLastname("Smolnikov");
        guy8.setMiddlename("Borisovich");
        guy8.setBirthday(bd3);
        persons.add(guy8);
        Person guy9 = new Person();
        guy9.setFirstname("Evgenii");
        guy9.setLastname("Buchenkov");
        guy9.setMiddlename("Evgenevich");
        guy9.setBirthday(bd3);
        persons.add(guy9);

        mapper.compareMaps(mapper.setMap(persons, hashMap), mapper.setMap(persons, treeMap), mapper.setMap(persons, linkedHashMap));
    }
}
/* copyright BuchEE */