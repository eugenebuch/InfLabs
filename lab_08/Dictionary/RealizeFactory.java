package Dictionary;

public class RealizeFactory {
    public static void workWithDict(DictFactory di) {
        Dict dict = di.getDict();
        dict.canITranslate("Дверь");
        dict.canITranslate("Мяч");
        dict.canITranslate("Мир");
        dict.canITranslate("Намеренная ошибка словаря");
    }
    public static void main(String[] args) {
        workWithDict(new ToEnglishFactory());
        workWithDict(new ToPolishFactory());
        workWithDict(new ToUkrainianFactory());
    }
}
