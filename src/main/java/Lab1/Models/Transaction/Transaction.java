package Lab1.Models.Transaction;

import Lab1.Entities.Account.Account;
import Lab1.Services.Validator;

public class Transaction {
    private final Account fromIAccount;
    private final Account toIAccount;
    private double amount;
    private boolean isExecuted;

    public Transaction(Account fromAccount, Account toAccount, double amount) {
        Validator.checkIfNull(fromAccount);
        Validator.checkIfNull(toAccount);
        Validator.checkIfBelowZero(amount);

        this.fromIAccount = fromAccount;
        this.toIAccount = toAccount;
        this.amount = amount;
        this.isExecuted = false;
    }

    public void cancel() {
        if (isExecuted) {
            fromIAccount.deposit(amount);
            toIAccount.withdraw(amount);
            isExecuted = false;
        }
    }

    public void execute() {
        fromIAccount.withdraw(amount);
        toIAccount.deposit(amount);
        isExecuted = true;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
