package tests;

import model.GroupData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification (){
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData("Modified_name", "Modified_header", "Modified_footer", before.get(before.size()-1).getGroupID());
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        //how to compare new and initial list of groups?
        //option#1
        // after modification order could be changed and we can't predict where new element is
        //so we have to use Set, not List. But in Set all records with the same value will be grouped. It's not good for tests
        //to avoid this we have to use unique ID
        before.remove(before.size()-1);
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
