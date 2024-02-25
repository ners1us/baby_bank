package Lab1.Entities.CommandHandler;

import Lab1.Entities.Bank.Bank;
import Lab1.Services.Validator;

import java.util.Scanner;

public class UpdateCreditCommissionCommandHandler extends CommandHandler {
    private final Bank bank;
    private final Scanner scanner;

    public UpdateCreditCommissionCommandHandler(Bank bank) {
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
        System.out.print("Введите новую комиссию на кредитные счета: ");
        double commission = scanner.nextDouble();

        bank.setCreditCommission(commission);
        System.out.println("Комиссия на кредитные счета обновлена");
    }
}
