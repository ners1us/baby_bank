package Lab1.Entities.CommandHandler;

import Lab1.Entities.Account.Account;
import Lab1.Entities.Account.CreditAccount;
import Lab1.Entities.Account.DepositAccount;
import Lab1.Entities.Bank.Bank;
import Lab1.Models.Client.Client;
import Lab1.Models.Transaction.Transaction;
import Lab1.Models.ValueObjects.Name;
import Lab1.Models.ValueObjects.Surname;
import Lab1.Services.SearchEngine;
import Lab1.Services.Validator;

import java.util.Scanner;

public class DepositCommandHandler extends CommandHandler{
    private final Bank bank;
    private final Scanner scanner;

    public DepositCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 7;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите имя клиента, куда вы хотите положить деньги: ");
        String firstName = scanner.next();

        System.out.print("Введите фамилию клиента: ");
        String surName = scanner.next();
        Client client = SearchEngine.findClient(firstName, surName, bank);
        Account account = SearchEngine.findAccount(client, bank);

        if (account instanceof DepositAccount) {
            System.out.print("Введите, сколько денег вы хотите положить: ");
            int depositAmount = scanner.nextInt();
            Transaction transaction = new Transaction(account, depositAmount);
            transaction.execute();
            System.out.println("Депозит успешно совершен");

        } else {
            System.out.println("Счет не является депозитным");
        }
    }
}
