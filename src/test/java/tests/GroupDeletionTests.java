package tests;

import org.junit.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().submitGroupDeletion();
        app.getNavigationHelper().gotoGroupPage();
    }

}
