package Dictionary;

import java.util.HashMap;

public class ToUkrainian implements Dict {
    HashMap<String, String> hash = new HashMap<String, String>();
    public ToUkrainian() {
        System.out.println("\n");
        hash.put("Дверь", "Дверi");
        hash.put("Мир", "Свiт");
        hash.put("Мяч", "М'яч");
    }
    @Override
    public void canITranslate(String word) {
        String translate = hash.get(word);
        if(translate != null) {
            System.out.println(word + " на украинском будет " + translate);
        }
        else {
            System.out.println("Я не могу перевести слово " + word + " :(");
        }
    }
}
