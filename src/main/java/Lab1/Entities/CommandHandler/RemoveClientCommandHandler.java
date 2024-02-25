package Lab1.Entities.CommandHandler;

import Lab1.Entities.Bank.Bank;
import Lab1.Models.Client.Client;
import Lab1.Services.Validator;

import java.util.Scanner;

public class RemoveClientCommandHandler extends CommandHandler{
    private final Bank bank;
    private final Scanner scanner;

    public RemoveClientCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 2;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите имя клиента: ");
        String firstName = scanner.next();

        System.out.print("Введите фамилию клиента: ");
        String lastName = scanner.next();

        Client client = findClient(firstName, lastName);

        if (client == null) {
            System.out.println("Клиент не найден");
        } else {
            bank.removeClient(client);
            System.out.println("Клиент удален");
        }
    }

    private Client findClient(String firstName, String lastName) {
        for (Client client : bank.getClients()) {
            if (client.getFirstName().getValue().equals(firstName) && client.getSurName().getValue().equals(lastName)) {
                return client;
            }
        }
        return null;
    }
}
