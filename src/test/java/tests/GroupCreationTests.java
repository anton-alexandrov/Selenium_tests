package tests;

import model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
            app.getNavigationHelper().gotoGroupPage();
            List<GroupData> before = app.getGroupHelper().getGroupList();
            app.getGroupHelper().createGroup(new GroupData("Test4_name", null, null));
            app.getNavigationHelper().gotoGroupPage();
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size() + 1);
    }

    @Test
    public void bulkGroupCreation() {
        for (int i = 0; i < 5; i++) {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().createGroup(new GroupData("Test" + i + "_name", "Test1_header", "Test1_footer"));
            app.getNavigationHelper().gotoGroupPage();

        }
    }
}
