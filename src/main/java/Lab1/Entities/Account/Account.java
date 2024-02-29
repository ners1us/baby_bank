package Lab1.Entities.Account;

import Lab1.Models.Client.Client;
import Lab1.Models.Transaction.Transaction;
import Lab1.Services.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account {
    protected Client owner;
    protected double balance;
    private double totalInterest;
    private double totalCommission;

    private final List<Transaction> transactions;

    protected Account(Client owner) {
        Validator.checkIfNull(owner);

        this.owner = owner;
        this.transactions = new ArrayList<>();
        this.totalInterest = 0;
        this.totalCommission = 0;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void transfer(Account account, double amount);

    public abstract void calculateInterestAndCommission(Date startDate, Date endDate);
    public void cancelDepositTransaction(Transaction transaction) {
        Validator.checkIfNull(transaction);

        if (transactions.contains(transaction)) {
            transaction.cancel();
            transactions.remove(transaction);
        }
    }

    public void executeDepositTransaction(Transaction transaction) {
        Validator.checkIfNull(transaction);

        transaction.execute();
        transactions.add(transaction);
    }

    public Client getClient() {
        return owner;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    protected void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    protected void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }
}
