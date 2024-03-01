package Lab1.Entities.CommandHandler;

import Lab1.Entities.Account.Account;
import Lab1.Entities.Bank.Bank;
import Lab1.Models.Client.Client;
import Lab1.Services.SearchEngine;
import Lab1.Services.Validator;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalculateInterestRateAndCommissionHandler extends CommandHandler {
    private final Bank bank;
    private final Scanner scanner;

    public CalculateInterestRateAndCommissionHandler(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 8;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите имя клиента: ");
        String firstName = scanner.next();

        System.out.print("Введите фамилию клиента: ");
        String surName = scanner.next();
        Client client = SearchEngine.findClient(firstName, surName, bank);
        Account account = SearchEngine.findAccount(client, bank);
        Validator.checkIfNull(account);

        Date startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, 10);
        Date endDate = calendar.getTime();

        account.calculateInterestAndCommission(startDate, endDate);
        System.out.println("Итоговая комиссия: " + account.getTotalCommission());
        System.out.println("Итоговый процент " + account.getTotalInterest());
    }
}
