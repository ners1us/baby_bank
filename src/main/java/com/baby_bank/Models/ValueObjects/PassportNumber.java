package com.baby_bank.Models.ValueObjects;

import com.baby_bank.Services.Validator;

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
