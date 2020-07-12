package tests;

import model.GroupData;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions () {
        app.getNavigationHelper().gotoGroupPage();
        if (app.getGroupHelper().getGroupList().size()==0) {
            app.getGroupHelper().createGroup(new GroupData().withName("Group for deletion"));
            app.getNavigationHelper().gotoGroupPage();
        }
    }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size()-1;
        app.getGroupHelper().deleteGroup(index);
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(index);
        Assert.assertEquals(before, after);

    }



}
