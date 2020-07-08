package tests;

import model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
            app.getNavigationHelper().gotoGroupPage();
            List<GroupData> before = app.getGroupHelper().getGroupList();
            GroupData group = new GroupData("Test4_name", null, null);
            app.getGroupHelper().createGroup(group);
            app.getNavigationHelper().gotoGroupPage();
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size() + 1);

            before.add(group);
            // we assume that groupID is unique and increases each time we create a group.
            // so newly created group will have maximum ID
            int max = 0;
        for (GroupData g: after) {
            if (g.getGroupID()>max){
                max = g.getGroupID();
            }
        }
        group.setGroupID(max);
            Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
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
