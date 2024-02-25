package Lab1;

import Lab1.Entities.Bank.Bank;
import Lab1.Entities.Bank.CentralBank;
import Lab1.Entities.ConsoleInterface.ConsoleInterface;
import Lab1.Models.ValueObjects.Name;

public class Program {
    public static void main(String[] args) {
        CentralBank centralBank = new CentralBank();
        Bank bank = new Bank(new Name("My Bank"), 0.5, 2.5, 1.0);
        centralBank.registerBank(bank);

        ConsoleInterface consoleInterface = new ConsoleInterface(bank);
        consoleInterface.run();
    }
}