package Functional2Imperative.Type;

import Functional2Imperative.Type.Type;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalType implements Type {

    public List<Type> types;

    public FunctionalType(List<Type> types) {
        this.types = types;
    }

    @Override
    public String getType() {
        String type =  types.stream().map(Type::getType).collect(Collectors.joining(" -> "));
        return '(' + type + ')';
    }
}
