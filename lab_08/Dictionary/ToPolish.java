package Dictionary;

import java.util.HashMap;

public class ToPolish implements Dict {
    HashMap<String, String> hash = new HashMap<String, String>();
    public ToPolish() {
        System.out.println("\n");
        hash.put("Дверь", "Drzwi");
        hash.put("Мир", "Świat");
        hash.put("Мяч", "Piłka");
    }
    @Override
    public void canITranslate(String word) {
        String translate = hash.get(word);
        if(translate != null) {
            System.out.println(word + " на польском будет " + translate);
        }
        else {
            System.out.println("Я не могу перевести слово " + word + " :(");
        }
    }
}
