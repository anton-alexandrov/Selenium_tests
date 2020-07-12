package model;

public class ContactData {
   //private final String firstAddress;
   //private final String name;
   //private final String lastName;
   //private final String address;
   //private final String email;


    private String firstAddress;
    private String name;
    private String lastName;
    private String address;
    private String email;

 //  public ContactData(String firstAddress, String name, String LastName, String Address, String email) {
 //      this.firstAddress = firstAddress;
 //      this.name = name;
 //      lastName = LastName;
 //      address = Address;
 //      this.email = email;
 //  }

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

    public ContactData withName (String name){
        this.name = name;
        return this;
    }

    public ContactData withLastName (String lastName){
        this.lastName = lastName;
        return this;
    }

    public ContactData withAddress (String address){
        this.address = address;
        return this;
    }

    public ContactData withMail (String email){
        this.email = email;
        return this;
    }

    public ContactData withFirstAddress (String firstAddress){
        this.firstAddress = firstAddress;
        return this;
    }


}
