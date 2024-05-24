package com.baby_bank.Entities.Bank;

import com.baby_bank.Entities.Account.Account;
import com.baby_bank.Models.Client.Client;
import com.baby_bank.Models.Notifications.BankNotification;
import com.baby_bank.Models.ValueObjects.Name;
import com.baby_bank.Services.Validator;

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

    private void setDebitInterestRate(double debitInterestRate) {
        this.debitInterestRate = debitInterestRate;
    }

    private void setDepositInterestRate(double depositInterestRate) {
        this.depositInterestRate = depositInterestRate;
    }

    private void setCreditCommission(double creditCommission) {
        this.creditCommission = creditCommission;
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
