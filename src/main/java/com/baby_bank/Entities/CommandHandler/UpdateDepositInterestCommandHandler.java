package com.baby_bank.Entities.CommandHandler;

import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Services.Validator;

import java.util.Scanner;

public class UpdateDepositInterestCommandHandler extends CommandHandler {
    private Bank bank;
    private final Scanner scanner;

    public UpdateDepositInterestCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 5;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите новый процент на депозитные счета: ");
        double interest = scanner.nextDouble();

        bank = new Bank(bank.getName(), bank.getDebitInterestRate(), interest, bank.getCreditCommission(), bank.getCreditLimit());
        bank.notifyClients("Изменены проценты на депозитные счета");

        System.out.println("Процент на депозитные счета обновлен");
    }
}
