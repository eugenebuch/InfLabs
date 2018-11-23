package Dictionary;

public class ToUkrainianFactory implements DictFactory {
    @Override
    public Dict getDict() {
        return new ToUkrainian();
    }
}
