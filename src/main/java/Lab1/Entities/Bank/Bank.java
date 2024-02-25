package Lab1.Entities.Bank;

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
    private final List<Client> clients;
    private final List<BankNotification> notifications;

    public Bank(Name name, double debitInterestRate, double depositInterestRate, double creditCommission) {
        this.name = name;
        this.debitInterestRate = debitInterestRate;
        this.depositInterestRate = depositInterestRate;
        this.creditCommission = creditCommission;
        clients = new ArrayList<>();
        notifications = new ArrayList<>();
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

    public void setName(Name name) {
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
}
