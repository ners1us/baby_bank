package Lab1.Models.ValueObjects;

import Lab1.Services.Validator;

public final class PassportNumber {
    private final int value;
    public PassportNumber(int value) {
        Validator.checkIfBelowZero(value);

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
