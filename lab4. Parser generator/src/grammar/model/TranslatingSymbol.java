package grammar.model;

public class TranslatingSymbol implements Symbol {

    public String code;

    public TranslatingSymbol(String code) {
        this.code = code;
    }

    public void normalize(String lexerVar) {
        StringBuilder normalize = new StringBuilder();
        boolean in = false;
        int i = -1;
        while (++i < code.length()) {
            if (code.charAt(i) == '$' && !in) {
                normalize.append(lexerVar + ".");
            } else {
                normalize.append(code.charAt(i));
                if (code.charAt(i) == '"') {
                    in = !in;
                }
            }
        }
        code = normalize.toString();
    }
}
