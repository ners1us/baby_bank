package com.baby_bank.Entities.ConsoleInterface;

import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Entities.CommandHandler.*;
import com.baby_bank.Models.Notifications.BankNotification;
import com.baby_bank.Services.Validator;

import java.util.Scanner;

public class ConsoleInterface implements BankNotification {
    private final Bank bank;

    private final Scanner scanner;
    private final CommandHandler commandHandler;

    public ConsoleInterface(Bank bank) {
        Validator.checkIfNull(bank);

        this.bank = bank;
        scanner = new Scanner(System.in);
        commandHandler = buildCommandChain();
        bank.subscribe(this);

    }
    @Override
    public void notify(String message) {
        System.out.println("Уведомление от банка: " + message);
    }
    public void run() {
        while (true) {
            System.out.println("1. Добавить клиента");
            System.out.println("2. Удалить клиента");
            System.out.println("3. Добавить аккаунт");
            System.out.println("4. Изменить проценты на дебетовые счета");
            System.out.println("5. Изменить проценты на депозитные счета");
            System.out.println("6. Изменить комиссию на кредитные счета");
            System.out.println("7. Сделать депозит");
            System.out.println("8. Посмотреть свою будущую комиссию и проценты");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("До свидания!");
                break;
            }

            commandHandler.handleCommand(choice);


        }
    }

    private CommandHandler buildCommandChain() {
        CommandHandler addClientHandler = new AddClientCommandHandler(bank);
        CommandHandler removeClientHandler = new RemoveClientCommandHandler(bank);
        CommandHandler updateDebitInterestHandler = new UpdateDebitInterestCommandHandler(bank);
        CommandHandler updateDepositInterestHandler = new UpdateDepositInterestCommandHandler(bank);
        CommandHandler updateCreditCommissionHandler = new UpdateCreditCommissionCommandHandler(bank);
        CommandHandler addAccountCommandHandler = new AddAccountCommandHandler(bank);
        CommandHandler depositCommandHandler = new DepositCommandHandler(bank);
        CommandHandler calculateInterestRateAndCommissionHandler = new CalculateInterestRateAndCommissionHandler(bank);

        addClientHandler.setNextHandler(removeClientHandler);
        removeClientHandler.setNextHandler(updateDebitInterestHandler);
        updateDebitInterestHandler.setNextHandler(updateDepositInterestHandler);
        updateDepositInterestHandler.setNextHandler(updateCreditCommissionHandler);
        updateCreditCommissionHandler.setNextHandler(addAccountCommandHandler);
        addAccountCommandHandler.setNextHandler(depositCommandHandler);
        depositCommandHandler.setNextHandler(calculateInterestRateAndCommissionHandler);

        return addClientHandler;
    }

}
