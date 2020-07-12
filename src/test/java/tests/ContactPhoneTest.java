package tests;

import org.testng.annotations.Test;

public class ContactPhoneTest extends TestBase{

    @Test
    public void testPhoneNumbers (){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().getContacts();


    }

}
