package Lab1.Entities.Account;

import Lab1.Models.Client.Client;
import Lab1.Models.Transaction.Transaction;

import java.util.List;

public class CreditAccount extends Account {
    private final double creditLimit;
    private double commission;

    public CreditAccount(Client owner,List<Transaction> transactions, double creditLimit, double commission) {
        super(owner, transactions);
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
        if (balance - amount >= -creditLimit) {
            balance -= amount;
            account.deposit(amount);
        }
    }

    public double getCommission() {
        return commission;
    }

    private void setCommission(double commission) {
        this.commission = commission;
    }
}
