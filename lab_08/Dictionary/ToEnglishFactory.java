package Dictionary;

public class ToEnglishFactory implements DictFactory {
    @Override
    public Dict getDict() {
        return new ToEnglish();
    }
}
