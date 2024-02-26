package Lab1.Entities.CommandHandler;

import Lab1.Entities.Account.CreditAccount;
import Lab1.Entities.Account.DebitAccount;
import Lab1.Entities.Account.DepositAccount;
import Lab1.Entities.Bank.Bank;
import Lab1.Models.Client.Client;
import Lab1.Services.SearchEngine;
import Lab1.Services.Validator;

import java.util.Scanner;

public class RegisterAccountCommandHandler extends CommandHandler{

    private final Bank bank;
    private final Scanner scanner;

    public RegisterAccountCommandHandler(Bank bank) {
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
        System.out.print("Введите имя клиента: ");
        String firstName = scanner.next();

        System.out.print("Введите фамилию клиента: ");
        String lastName = scanner.next();

        Client client = SearchEngine.findClient(firstName, lastName, bank);

        if (client == null) {
            System.out.println("Клиент не найден");
        } else {
            System.out.print("Выберите вид счёта:");
            System.out.print("1. Депозитный");
            System.out.print("2. Дебетовый");
            System.out.print("3. Кредитный");

            int accountChoice = scanner.nextInt();
            if (accountChoice == 1) {
                int initialAmount = 0;
                bank.addAccount(new DepositAccount(client, bank.getDepositInterestRate(), initialAmount));
            } else if (accountChoice == 2) {
                bank.addAccount(new DebitAccount(client, bank.getDebitInterestRate()));
            } else if (accountChoice == 3) {
                bank.addAccount(new CreditAccount(client, bank.getCreditLimit(), bank.getCreditCommission()));
            } else {
                System.out.println("Некорректный выбор!");
            }

        }
    }
}
