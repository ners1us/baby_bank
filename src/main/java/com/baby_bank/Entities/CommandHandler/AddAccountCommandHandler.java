package com.baby_bank.Entities.CommandHandler;

import com.baby_bank.Entities.Account.Account;
import com.baby_bank.Entities.Account.CreditAccount;
import com.baby_bank.Entities.Account.DebitAccount;
import com.baby_bank.Entities.Account.DepositAccount;
import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Models.Client.Client;
import com.baby_bank.Services.SearchEngine;
import com.baby_bank.Services.Validator;

import java.util.Scanner;

public class AddAccountCommandHandler extends CommandHandler{

    private final Bank bank;
    private final Scanner scanner;

    public AddAccountCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }
    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 3;
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
            System.out.println("Выберите вид счёта:");
            System.out.println("1. Депозитный");
            System.out.println("2. Дебетовый");
            System.out.println("3. Кредитный");

            int accountChoice = scanner.nextInt();
            if (accountChoice == 1) {
                int initialAmount = 0;
                Account newAccount = new DepositAccount(client, bank.getDepositInterestRate(), initialAmount);

                if (SearchEngine.checkIfAccountExists(newAccount, bank)) {
                    System.out.println("Такой аккаунт уже существует!");
                } else {
                    bank.addAccount(newAccount);
                    System.out.println("Аккаунт успешно добавлен");
                }
            } else if (accountChoice == 2) {
                Account newAccount = new DebitAccount(client, bank.getDebitInterestRate());
                if (SearchEngine.checkIfAccountExists(newAccount, bank)) {
                    System.out.println("Такой аккаунт уже существует!");
                } else {
                    bank.addAccount(newAccount);
                    System.out.println("Аккаунт успешно добавлен");
                }
            } else if (accountChoice == 3) {
                Account newAccount = new CreditAccount(client, bank.getCreditLimit(), bank.getCreditCommission());
                if (SearchEngine.checkIfAccountExists(newAccount, bank)) {
                    System.out.println("Такой аккаунт уже существует!");
                } else {
                    bank.addAccount(newAccount);
                    System.out.println("Аккаунт успешно добавлен");
                }
            } else {
                System.out.println("Некорректный выбор!");
            }

        }
    }
}
