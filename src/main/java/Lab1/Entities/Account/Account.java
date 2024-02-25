package Lab1.Entities.Account;

import Lab1.Models.Client.Client;
import Lab1.Models.Transaction.Transaction;

import java.util.List;

public abstract class Account {
    protected Client owner;
    protected double balance;

    private final List<Transaction> transactions;

    protected Account(Client owner, List<Transaction> transactions) {
        this.owner = owner;
        this.transactions = transactions;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void transfer(Account account, double amount);
    public void cancelTransaction(Transaction transaction) {
        if (transactions.contains(transaction)) {
            transaction.cancel();
            transactions.remove(transaction);
        }
    }

    public void executeTransaction(Transaction transaction) {
        transaction.execute();
        transactions.add(transaction);
    }


}
