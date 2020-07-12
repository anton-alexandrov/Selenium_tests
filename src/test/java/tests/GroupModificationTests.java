package tests;

import model.GroupData;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions () {
        app.getNavigationHelper().gotoGroupPage();
        if (app.getGroupHelper().getGroupList().size()==0) {
            app.getGroupHelper().createGroup(new GroupData().withName("Group for modification"));
            app.getNavigationHelper().gotoGroupPage();
        }
    }

    @Test
    public void testGroupModification (){
        List<GroupData> before = app.getGroupHelper().getGroupList();
        int index = before.size()-1;
        GroupData group = new GroupData().withName("Modified_name").withHeader("Modified_header").withFooter("Modified_footer").withID(before.get(index).getGroupID());
        app.getGroupHelper().modifyGroup(index, group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        //how to compare new and initial list of groups?
        //option#1
        // after modification order could be changed and we can't predict where new element is
        //so we have to use Set, not List. But in Set all records with the same value will be grouped. It's not good for tests
        //to avoid this we have to use unique ID
        before.remove(index);
        before.add(group);
        //option#2
        Comparator<? super GroupData> byID = (g1, g2)->Integer.compare(g1.getGroupID(), g2.getGroupID());
        before.sort(byID);
        after.sort(byID);
        //assert fot option#1
        // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        //assert for option#2
        Assert.assertEquals(before, after);

        //another way, to sort collection
    }


}
