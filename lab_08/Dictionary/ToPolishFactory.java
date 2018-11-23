package Dictionary;

public class ToPolishFactory implements DictFactory {
    @Override
    public Dict getDict() {
        return new ToPolish();
    }
}
