package com.baby_bank.Models.ValueObjects;

import com.baby_bank.Services.Validator;

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
