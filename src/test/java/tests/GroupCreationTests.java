package tests;

import model.GroupData;
import org.junit.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Test1_name", "Test1_header", "Test1_footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().gotoGroupPage();
    }

}
