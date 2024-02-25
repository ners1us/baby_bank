package Lab1.Models.ValueObjects;

import Lab1.Services.Validator;

public final class Address {
    private final String value;
    public Address(String value) {
        Validator.checkIfNull(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
