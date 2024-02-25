package Lab1.Entities.Bank;

import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private List<Bank> banks;

    public CentralBank() {
        banks = new ArrayList<>();
    }
    public void registerBank(Bank bank) {
        banks.add(bank);
    }

    public void unregisterBank(Bank bank) {
        banks.remove(bank);
    }

    public void notifyBanks(String message) {
        for (Bank bank : banks) {
            bank.notifyClients(message);
        }
    }
}
