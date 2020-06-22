package model;

public class ContactData {
    private final String firstAddress;
    private final String name;
    private final String lastName;
    private final String address;
    private final String email;

    public ContactData(String firstAddress, String name, String LastName, String Address, String email) {
        this.firstAddress = firstAddress;
        this.name = name;
        lastName = LastName;
        address = Address;
        this.email = email;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }
}
