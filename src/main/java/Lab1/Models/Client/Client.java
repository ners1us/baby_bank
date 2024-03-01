package Lab1.Models.Client;

import Lab1.Models.ValueObjects.Address;
import Lab1.Models.ValueObjects.Name;
import Lab1.Models.ValueObjects.PassportNumber;
import Lab1.Models.ValueObjects.Surname;
import Lab1.Services.Validator;

public class Client {
    private Name firstName;
    private Surname surName;
    private Address address;
    private PassportNumber passportNumber;

    public Client(Name firstName, Surname surName) {
        Validator.checkIfNull(firstName);
        Validator.checkIfNull(surName);

        this.firstName = firstName;
        this.surName = surName;
    }
    private void setAddress(Address address) {
        this.address = address;
    }

    private void setPassportNumber(PassportNumber passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Name getFirstName() {
        return firstName;
    }

    private void setFirstName(Name firstName) {
        this.firstName = firstName;
    }

    public Surname getSurName() {
        return surName;
    }

    private void setSurName(Surname surName) {
        this.surName = surName;
    }

    public Address getAddress() {
        return address;
    }

    public PassportNumber getPassportNumber() {
        return passportNumber;
    }
}
