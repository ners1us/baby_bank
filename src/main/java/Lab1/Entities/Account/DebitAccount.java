package Lab1.Entities.Account;

import Lab1.Models.Client.Client;
import Lab1.Models.Transaction.Transaction;
import Lab1.Services.Validator;

import java.util.List;
public class DebitAccount extends Account {
    private double interestRate;

    public DebitAccount(Client owner, double interestRate, List<Transaction> transactions) {
        super(owner, transactions);
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
}
