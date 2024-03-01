package Lab1.Models.ValueObjects;

import Lab1.Services.Validator;

public final class Name {
    private final String value;
    public Name(String value) {
        Validator.checkIfNull(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
