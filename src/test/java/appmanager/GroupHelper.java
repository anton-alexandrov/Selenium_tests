package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void selectGroup(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();

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


    public int getGroupCount() {
       return driver.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.name("selected[]"));
        System.out.println("Size: "+elements.size());
        for (WebElement element : elements){
            String name = element.getText();
            int groupID = Integer.parseInt(element.getAttribute("value"));
            System.out.println(element.getText());
            GroupData group = new GroupData().withName(name).withID(groupID);
            groups.add(group);
        }
        return groups;
    }

    public void createGroup(GroupData group) {
      initGroupCreation();
      fillGroupForm(group);
      submitGroupCreation();
    }

    public boolean isThereAGroup(By by) {
    //   try {
    //       driver.findElement(by);
    //       return true;
    //   } catch (WebDriverException e) {
    //       return false;
    //   }

        if (driver.findElements(by).size()==0){
            return false;
        } else
        return true;
    }

    public List<GroupData> getGroupListByXPath() {
        String before = "/html/body/div/div[4]/form/input[";
        String after = "]";
        String result = "";
        List<String> listOfXPathes = new ArrayList<>();
        int n = driver.findElements(By.name("selected[]")).size();
        System.out.println("Number of elements:" + n);
        for (int i = 4; i <= n+3; i++) {
            result = before + i + after;
            System.out.println("Xpath: "+ result);
            listOfXPathes.add(result);
        }

        List<WebElement> elements = new ArrayList<>();
        for (String s:listOfXPathes){
            elements.add(driver.findElement(By.xpath(s)));
        }


        List<GroupData> groups = new ArrayList<GroupData>();
        for (WebElement element : elements){

            System.out.println("Is Displayed: "+ element.isDisplayed());
            System.out.println("Is Enabled: " + element.isEnabled());
            System.out.println("getText" + element.getText());
            System.out.println("innerText: "+element.getAttribute("innerText"));
            System.out.println("Attribute Text: "+element.getAttribute("text"));
            System.out.println("innerHTML: "+element.getAttribute("innerHTML"));
            System.out.println("textContent: "+element.getAttribute("textContent"));
            System.out.println("value: "+element.getAttribute("value"));
            System.out.println("title: "+element.getAttribute("title"));
            System.out.println("data: "+element.getAttribute("data"));
            System.out.println("Node Value: "+element.getAttribute("nodeValue"));
            System.out.println("wholeText: "+element.getAttribute("wholeText"));
            System.out.println(element.getCssValue("nodeValue"));
            System.out.println(element.getCssValue("data"));
            System.out.println(element.getCssValue("wholeText"));

            String name = element.getAttribute("textContent");
            int groupID = Integer.parseInt(element.getAttribute("value"));
            System.out.println("ID: " + groupID);

            GroupData group = new GroupData().withName(name).withID(groupID);

            groups.add(group);
        }
        return groups;

    }

    public void modifyGroup(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
    }

    public void deleteGroup(int index) {
        selectGroup(index);
        submitGroupDeletion();

    }

    public void getGroupByXPath() {
        driver.findElements(By.xpath("/html/body/div/div[4]/form/input[4]"));
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();


        List<WebElement> elements = driver.findElements(By.name("selected[]"));
        System.out.println("Size: "+elements.size());
        for (WebElement element : elements){
            String name = element.getText();
            int groupID = Integer.parseInt(element.getAttribute("value"));
            System.out.println(element.getText());
            GroupData group = new GroupData().withName(name).withID(groupID);
            groups.add(group);
        }
        return groups;
    }

}
