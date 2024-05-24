package com.baby_bank.Entities.Account;

import com.baby_bank.Models.Client.Client;
import com.baby_bank.Services.Validator;

import java.util.Date;

public class CreditAccount extends Account {
    private final double creditLimit;
    private double commission;

    public CreditAccount(Client owner, double creditLimit, double commission) {
        super(owner);
        this.creditLimit = creditLimit;
        this.commission = commission;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -creditLimit) {
            balance -= amount;
        }
    }

    @Override
    public void transfer(Account account, double amount) {
        Validator.checkIfNull(account);

        if (balance - amount >= -creditLimit) {
            balance -= amount;
            account.deposit(amount);
        }
    }

    @Override
    public void calculateInterestAndCommission(Date startDate, Date endDate) {
        long days = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        double interest = balance *  0.5 / 36500 * days;
        setTotalInterest(getTotalInterest() + interest);

        double commissionAmount = balance * getCommission() / 100;
        setTotalCommission(getTotalCommission() + commissionAmount);
    }

    public double getCommission() {
        return commission;
    }
    private void setCommission(double commission) {
        this.commission = commission;
    }
}
