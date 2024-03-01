package Lab1.Models.ValueObjects;

import Lab1.Services.Validator;

public class Text {
    private final String value;
    public Text(String value) {
        Validator.checkIfNull(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
