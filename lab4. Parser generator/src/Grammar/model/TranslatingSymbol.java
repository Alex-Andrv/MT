package grammar.model;

public class TranslatingSymbol implements Symbol {

    String code;

    public TranslatingSymbol(String code) {
        this.code = code;
    }

    @Override
    public String genCode() {
        return null;
    }
}
