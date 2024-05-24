package com.baby_bank.Entities.CommandHandler;

import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Models.Client.Client;
import com.baby_bank.Services.SearchEngine;
import com.baby_bank.Services.Validator;

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

        Client client = SearchEngine.findClient(firstName, lastName, bank);

        if (client == null) {
            System.out.println("Клиент не найден");
        } else {
            bank.removeClient(client);
            System.out.println("Клиент удален");
        }
    }


}
