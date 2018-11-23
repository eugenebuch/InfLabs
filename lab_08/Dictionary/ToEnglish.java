package Dictionary;
import java.util.HashMap;

public class ToEnglish implements Dict {
    HashMap<String, String> hash = new HashMap<String, String>();
    public ToEnglish() {
        System.out.println("\n");
        hash.put("Дверь", "Door");
        hash.put("Мир", "Peace");
        hash.put("Мяч", "Ball");
    }
    @Override
    public void canITranslate(String word) {
        String translate = hash.get(word);
        if(translate != null) {
            System.out.println(word + " на английском будет " + translate);
        }
        else {
            System.out.println("Я не могу перевести слово " + word + " :(");
        }
    }
}
