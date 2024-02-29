package Lab1.Entities.CommandHandler;

import Lab1.Entities.Account.Account;
import Lab1.Entities.Account.CreditAccount;
import Lab1.Entities.Account.DebitAccount;
import Lab1.Entities.Account.DepositAccount;
import Lab1.Entities.Bank.Bank;
import Lab1.Models.Client.Client;
import Lab1.Services.SearchEngine;
import Lab1.Services.Validator;

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
