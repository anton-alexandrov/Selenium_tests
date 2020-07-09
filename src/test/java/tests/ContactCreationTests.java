package tests;

import model.ContactData;
import org.junit.Test;


public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {

        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Test address", "Test Name", "Test Lastname", "Test address", "test@test.com"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();

    }
}
