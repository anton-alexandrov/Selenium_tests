package tests;

import model.GroupData;
import org.junit.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification (){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("Modified_name", "Modified_header", "Modified_footer"));
        app.getGroupHelper().submitGroupModification();
    }
}
