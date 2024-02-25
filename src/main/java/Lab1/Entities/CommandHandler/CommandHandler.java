package Lab1.Entities.CommandHandler;

import Lab1.Services.Validator;

public abstract class CommandHandler {
    private CommandHandler nextHandler;

    public void setNextHandler(CommandHandler handler) {
        this.nextHandler = handler;
    }

    public void handleCommand(int choice){
        Validator.checkIfBelowZero(choice);

        if (canHandleCommand(choice)) {
            processCommand(choice);
        } else if (nextHandler != null) {
            nextHandler.handleCommand(choice);
        } else {
            System.out.println("Некорректный выбор");
        }
    }

    public abstract boolean canHandleCommand(int choice);

    public abstract void processCommand(int choice);
}
