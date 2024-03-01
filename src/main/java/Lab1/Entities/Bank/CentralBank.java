package Lab1.Entities.Bank;

import Lab1.Services.Validator;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private final List<Bank> banks;

    public CentralBank() {
        banks = new ArrayList<>();
    }
    public void registerBank(Bank bank) {
        Validator.checkIfNull(bank);

        banks.add(bank);
    }

    public void unregisterBank(Bank bank) {
        Validator.checkIfNull(bank);

        banks.remove(bank);
    }

    public void notifyBanks(String message) {
        for (Bank bank : banks) {
            bank.notifyClients(message);
        }
    }
}
