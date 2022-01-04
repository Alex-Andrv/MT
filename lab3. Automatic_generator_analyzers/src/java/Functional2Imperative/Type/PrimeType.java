package Functional2Imperative.Type;

public class PrimeType implements Type {
    public String type;

    public PrimeType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
