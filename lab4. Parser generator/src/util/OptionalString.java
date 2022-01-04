package util;

import java.util.Objects;
import java.util.Optional;

@Deprecated
public class OptionalString {
    private final Optional<String> optString;

    public OptionalString(String optString) {
        if (Objects.isNull(optString)) {
            throw new IllegalStateException("The parameter in the constructor is null");
        }
        this.optString = Optional.of(optString);
    }

    public OptionalString() {
        this.optString = Optional.empty();
    }

    public String get() {
        return optString.get();
    }

    public boolean isPresent() {
        return optString.isPresent();
    }
}
