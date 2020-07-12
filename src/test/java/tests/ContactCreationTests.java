package tests;

import model.ContactData;
import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {


    @Test //(enabled = false)
    public void testContactCreation() {

        app.getNavigationHelper().gotoContactPage();
        ContactData contact = new ContactData().
                withAddress("Test address").withName("Test Name").withLastName("Test Lastname").withAddress("Test address").withMail("test@test.com");
        System.out.println("Address: "+contact.getAddress());
        System.out.println("Name: "+contact.getName());
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();

    }
}
