package com.baby_bank.Entities.CommandHandler;

import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Services.Validator;

import java.util.Scanner;

public class UpdateCreditCommissionCommandHandler extends CommandHandler {
    private Bank bank;
    private final Scanner scanner;

    public UpdateCreditCommissionCommandHandler(Bank bank) {
        Validator.checkIfNull(bank);
        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 6;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите новую комиссию на кредитные счета: ");
        double commission = scanner.nextDouble();

        bank = new Bank(bank.getName(), bank.getDebitInterestRate(), bank.getDepositInterestRate(), commission, bank.getCreditLimit());
        bank.notifyClients("Изменена комиссия на кредитные счета");

        System.out.println("Комиссия на кредитные счета обновлена");
    }
}
