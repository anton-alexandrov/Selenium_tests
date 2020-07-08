package tests;

import model.ContactData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Sandbox extends TestBase {

    @Test
    public void getListOfContactsByXpath (){
        app.getNavigationHelper().gotoHomePage();
        List <WebElement> list1 = app.getContactHelper().getAllRows();
        for (WebElement e: list1){
            System.out.println("Name: " + e.getText());
            System.out.println("getAttribute accept" + e.getAttribute("accept"));

        }

    }

    @Test
    public void one() {
        app.getNavigationHelper().gotoHomePage();
        System.out.println(app.getContactHelper().getOne().getText());
    }

    @Test
    public void getListOfGroups(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().getGroupListByXPath();

    }




}
