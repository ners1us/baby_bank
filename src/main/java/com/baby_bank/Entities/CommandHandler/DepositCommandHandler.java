package com.baby_bank.Entities.CommandHandler;

import com.baby_bank.Entities.Account.Account;
import com.baby_bank.Entities.Account.DepositAccount;
import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Models.Client.Client;
import com.baby_bank.Models.Transaction.DepositTransaction;
import com.baby_bank.Services.SearchEngine;
import com.baby_bank.Services.Validator;

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
            DepositTransaction depositTransaction = new DepositTransaction(account, depositAmount);
            account.executeDepositTransaction(depositTransaction);
            System.out.println("Депозит успешно совершен");

        } else {
            System.out.println("Некорректный вид счёта!");
        }
    }
}
