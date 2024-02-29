package Lab1.Entities.Account;

import Lab1.Models.Client.Client;
import Lab1.Models.Transaction.Transaction;
import Lab1.Services.Validator;

import java.util.Date;
import java.util.List;

public class DepositAccount extends Account {
    private double interestRate;
    private double initialAmount;

    public DepositAccount(Client owner, double interestRate, double initialAmount) {
        super(owner);
        this.interestRate = interestRate;
        this.initialAmount = initialAmount;
        balance = initialAmount;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Доступ к счету запрещен до окончания срока депозита");
    }

    @Override
    public void transfer(Account account, double amount) {
        Validator.checkIfNull(account);

        System.out.println("Доступ к счету запрещен до окончания срока депозита");
    }

    @Override
    public void calculateInterestAndCommission(Date startDate, Date endDate) {
        long days = (endDate.getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000);
        double interest = balance *  interestRate / 36500 * days;
        setTotalInterest(getTotalInterest() + interest);

        double commissionAmount = balance * 0.1 / 100;
        setTotalCommission(getTotalCommission() + commissionAmount);
    }

    public double getInterestRate() {
        return interestRate;
    }

    private void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInitialAmount() {
        return initialAmount;
    }

    private void setInitialAmount(double initialAmount) {
        this.initialAmount = initialAmount;
    }
}
