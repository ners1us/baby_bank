package com.baby_bank.Entities.CommandHandler;

import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Models.Client.Client;
import com.baby_bank.Models.ValueObjects.Name;
import com.baby_bank.Models.ValueObjects.Surname;
import com.baby_bank.Services.SearchEngine;
import com.baby_bank.Services.Validator;

import java.util.Scanner;

public class AddClientCommandHandler extends CommandHandler {
    private final Bank bank;
    private final Scanner scanner;

    public AddClientCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 1;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите имя клиента: ");
        String firstName = scanner.next();

        System.out.print("Введите фамилию клиента: ");
        String surName = scanner.next();

        Client client = new Client(new Name(firstName), new Surname(surName));

        if (SearchEngine.checkIfClientExists(client, bank)) {
            System.out.println("Такой клиент уже существует!");
        } else {
            bank.addClient(client);

            System.out.println("Клиент успешно добавлен");
        }
    }
}
