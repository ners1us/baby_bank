package com.baby_bank.Entities.CommandHandler;

import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Services.Validator;

import java.util.Scanner;

public class UpdateDebitInterestCommandHandler extends CommandHandler {
    private Bank bank;
    private final Scanner scanner;

    public UpdateDebitInterestCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 4;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите новый процент на дебетовые счета: ");
        double interest = scanner.nextDouble();

        bank = new Bank(bank.getName(), interest, bank.getDepositInterestRate(), bank.getCreditCommission(), bank.getCreditLimit());
        bank.notifyClients("Изменены проценты на дебетовые счета");

        System.out.println("Процент на дебетовые счета обновлен");
    }
}
