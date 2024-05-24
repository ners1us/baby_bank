package com.baby_bank;

import com.baby_bank.Entities.Bank.Bank;
import com.baby_bank.Entities.Bank.CentralBank;
import com.baby_bank.Entities.ConsoleInterface.ConsoleInterface;
import com.baby_bank.Models.ValueObjects.Name;

public class Program {
    public static void main(String[] args) {
        CentralBank centralBank = new CentralBank();
        Bank bank = new Bank(new Name("My Bank"), 0.5, 2.5, 1.0, 5000);
        centralBank.registerBank(bank);

        ConsoleInterface consoleInterface = new ConsoleInterface(bank);
        consoleInterface.run();
    }
}