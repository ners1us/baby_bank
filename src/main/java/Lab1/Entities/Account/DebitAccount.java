package Lab1.Entities.Account;

import Lab1.Models.Client.Client;
import Lab1.Services.Validator;

import java.util.Date;

public class DebitAccount extends Account {
    private double interestRate;

    public DebitAccount(Client owner, double interestRate) {
        super(owner);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    @Override
    public void transfer(Account account, double amount) {
        Validator.checkIfNull(account);

        if (balance >= amount) {
            balance -= amount;
            account.deposit(amount);
        }
    }
    @Override
    public void calculateInterestAndCommission(Date startDate, Date endDate) {
        long days = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        double interest = balance * interestRate / 36500 * days;
        setTotalInterest(getTotalInterest() + interest);

        double commissionAmount = balance * 0.25 / 100;
        setTotalCommission(getTotalCommission() + commissionAmount);
    }
    public double getInterestRate() {
        return interestRate;
    }

    private void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
