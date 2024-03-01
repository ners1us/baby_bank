package Lab1.Entities.Account;

import Lab1.Models.Client.Client;
import Lab1.Models.Transaction.DepositTransaction;
import Lab1.Services.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Account {
    protected Client owner;
    protected double balance;
    private double totalInterest;
    private double totalCommission;

    private final List<DepositTransaction> depositTransactions;

    protected Account(Client owner) {
        Validator.checkIfNull(owner);

        this.owner = owner;
        this.depositTransactions = new ArrayList<>();
        this.totalInterest = 0;
        this.totalCommission = 0;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void transfer(Account account, double amount);

    public abstract void calculateInterestAndCommission(Date startDate, Date endDate);
    public void cancelDepositTransaction(DepositTransaction depositTransaction) {
        Validator.checkIfNull(depositTransaction);

        if (depositTransactions.contains(depositTransaction)) {
            depositTransaction.cancel();
            depositTransactions.remove(depositTransaction);
        }
    }

    public void executeDepositTransaction(DepositTransaction depositTransaction) {
        Validator.checkIfNull(depositTransaction);

        depositTransaction.execute();
        depositTransactions.add(depositTransaction);
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
