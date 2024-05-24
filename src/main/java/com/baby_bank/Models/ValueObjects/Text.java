package com.baby_bank.Models.ValueObjects;

import com.baby_bank.Services.Validator;

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
