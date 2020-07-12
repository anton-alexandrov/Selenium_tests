package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
    @Test//(enabled = false)

    public void testContactCreation() {

        //app.getNavigationHelper().gotoContactPage();
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectAnyContact();

        ContactData modifiedContact = new ContactData().
                withAddress("Modified Test address").withName("Modified Test Name").withLastName("Modified Test Lastname").withMail("newtest@test.com");

        app.getContactHelper().modify(modifiedContact);
       // app.getContactHelper().fillContactForm(modifiedContact);
        //app.getContactHelper().submitContactCreation();
        app.getContactHelper().update();
        app.getNavigationHelper().gotoHomePage();

    }
}
