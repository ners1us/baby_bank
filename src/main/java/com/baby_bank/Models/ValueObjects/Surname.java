package com.baby_bank.Models.ValueObjects;

import com.baby_bank.Services.Validator;

public final class Surname {
    private final String value;
    public Surname(String value) {
        Validator.checkIfNull(value);

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
