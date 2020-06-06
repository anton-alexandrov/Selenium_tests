package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void selectGroup() {
        click(By.name("selected[]"));

    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void submitGroupDeletion() {
        click(By.name("delete"));
    }

    public void submitGroupModification() {
        click(By.name(("update")));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void initGroupModification() {
        click(By.name(("edit")));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getGroupHeader());
        type(By.name("group_footer"), groupData.getGroupFooter());
    }


}
