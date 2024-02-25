package Lab1.Entities.CommandHandler;

import Lab1.Entities.Bank.Bank;

import java.util.Scanner;

public class UpdateDepositInterestCommandHandler extends CommandHandler {
    private final Bank bank;
    private final Scanner scanner;

    public UpdateDepositInterestCommandHandler(Bank bank) {
        this.bank = bank;
        scanner = new Scanner(System.in);
    }

    @Override
    public boolean canHandleCommand(int choice) {
        return choice == 4;
    }

    @Override
    public void processCommand(int choice) {
        System.out.print("Введите новый процент на депозитные счета: ");
        double interest = scanner.nextDouble();

        bank.setDepositInterestRate(interest);
        System.out.println("Процент на депозитные счета обновлен");
    }
}
