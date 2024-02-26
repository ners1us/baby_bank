package Lab1.Services;

public class Validator {
    public static void checkIfNull(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Value shouldn't be null!");
    }

    public static void checkIfBelowZero(Object object) {
        if (object instanceof Integer) {
            int intObject = (Integer) object;
            if (intObject < 0)
                throw new IllegalArgumentException("Value shouldn't be below zero!");

        } else if (object instanceof Double) {
            double doubleObject = (Double) object;
            if (doubleObject < 0)
                throw new IllegalArgumentException("Value shouldn't be below zero!");
        }

    }
}
