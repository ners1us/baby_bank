package Lab1.Entities.CommandHandler;

import Lab1.Entities.Bank.Bank;

import java.util.Scanner;

public class UpdateDebitInterestCommandHandler extends CommandHandler {
    private final Bank bank;
    private final Scanner scanner;

    public UpdateDebitInterestCommandHandler(Bank bank) {
        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 3;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите новый процент на дебетовые счета: ");
        double interest = scanner.nextDouble();

        bank.setDebitInterestRate(interest);
        System.out.println("Процент на дебетовые счета обновлен");
    }
}
