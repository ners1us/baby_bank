package com.baby_bank.Models.Transaction;

import com.baby_bank.Entities.Account.Account;
import com.baby_bank.Services.Validator;

public class DepositTransaction {
    private final Account account;
    private double amount;
    private boolean isExecuted;

    public DepositTransaction(Account account, double amount) {
        Validator.checkIfNull(account);
        Validator.checkIfBelowZero(amount);

        this.account = account;
        this.amount = amount;
        this.isExecuted = false;
    }

    public void cancel() {
        if (isExecuted) {
            account.withdraw(amount);
            isExecuted = false;
        }
    }

    public void execute() {
        account.deposit(amount);
        isExecuted = true;
    }

    public double getAmount() {
        return amount;
    }
    private void setAmount(double amount) {
        this.amount = amount;
    }
}
