package Lab1.Entities.Bank;

import Lab1.Entities.Account.Account;
import Lab1.Models.Client.Client;
import Lab1.Models.Notifications.BankNotification;
import Lab1.Models.ValueObjects.Name;
import Lab1.Services.Validator;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private Name name;
    private double debitInterestRate;
    private double depositInterestRate;
    private double creditCommission;
    private double creditLimit;
    private final List<Client> clients;
    private final List<BankNotification> notifications;
    private final List<Account> accounts;

    public Bank(Name name, double debitInterestRate, double depositInterestRate, double creditCommission, double creditLimit) {
        this.name = name;
        this.debitInterestRate = debitInterestRate;
        this.depositInterestRate = depositInterestRate;
        this.creditCommission = creditCommission;
        this.creditLimit = creditLimit;
        clients = new ArrayList<>();
        notifications = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public void setDebitInterestRate(double debitInterestRate) {
        this.debitInterestRate = debitInterestRate;
        notifyClients("Изменены проценты на дебетовые счета");
    }

    public void setDepositInterestRate(double depositInterestRate) {
        this.depositInterestRate = depositInterestRate;
        notifyClients("Изменены проценты на депозитные счета");
    }

    public void setCreditCommission(double creditCommission) {
        this.creditCommission = creditCommission;
        notifyClients("Изменена комиссия на кредитные счета");
    }
    public void subscribe(BankNotification notification) {
        notifications.add(notification);
    }

    public void unsubscribe(BankNotification notification) {
        notifications.remove(notification);
    }

    public void notifyClients(String message) {
        for (BankNotification notification : notifications) {
            notification.notify(message);
        }
    }

    public void addClient(Client client) {
        Validator.checkIfNull(client);

        clients.add(client);
    }

    public void addAccount(Account account){
        Validator.checkIfNull(account);

        accounts.add(account);
    }

    public void removeClient(Client client) {
        Validator.checkIfNull(client);

        clients.remove(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Name getName() {
        return name;
    }

    private void setName(Name name) {
        this.name = name;
    }

    public double getDebitInterestRate() {
        return debitInterestRate;
    }

    public double getDepositInterestRate() {
        return depositInterestRate;
    }

    public double getCreditCommission() {
        return creditCommission;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    private void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
