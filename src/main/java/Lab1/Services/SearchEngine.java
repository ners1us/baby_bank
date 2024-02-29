package Lab1.Services;

import Lab1.Entities.Account.Account;
import Lab1.Entities.Bank.Bank;
import Lab1.Models.Client.Client;
import Lab1.Models.ValueObjects.Name;
import Lab1.Models.ValueObjects.Surname;

public class SearchEngine {
    public static Client findClient(String firstName, String lastName, Bank bank) {
        for (Client client : bank.getClients()) {
            if (client.getFirstName().getValue().equals(firstName) && client.getSurName().getValue().equals(lastName)) {
                return client;
            }
        }
        return null;
    }
    public static Account findAccount(Client client, Bank bank) {
        for (Account account : bank.getAccounts()) {
            if (client.getFirstName().getValue().equals(account.getClient().getFirstName().getValue()) && client.getSurName().getValue().equals(account.getClient().getSurName().getValue())) {
                return account;
            }
        }
        return null;
    }
    public static boolean checkIfClientExists(Client client, Bank bank) {
        return bank.getClients().contains(client);
    }
    public static boolean checkIfAccountExists(Account account, Bank bank) {
        return bank.getAccounts().contains(account);
    }
}
