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
        GroupData group = new GroupData("Test4_name", null, null);
        app.getGroupHelper().createGroup(group);
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        // we assume that groupID is unique and increases each time we create a group.
        // so newly created group will have maximum ID

        //option#1 with loop
        //       int max = 0;
        //   for (GroupData g: after) {
        //       if (g.getGroupID()>max){
        //           max = g.getGroupID();
        //       }
        //   }

        //option#2 with Stream
      // Comparator<? super GroupData> byID = new Comparator<GroupData>() {
      //     @Override
      //     public int compare(GroupData o1, GroupData o2) {
      //         return Integer.compare(o1.getGroupID(), o2.getGroupID());
      //     }
      // };

       // int max = after.stream().max(byID).get().getGroupID(); //convert List to Stream, than find max GroupID using Comparator; get element with Max group ID and get its GroupID
        
        //option#2 with lamda
        //group.setGroupID(after.stream().max((o1, o2) -> Integer.compare(o1.getGroupID(), o2.getGroupID())).get().getGroupID());
        //before.add(group);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
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
