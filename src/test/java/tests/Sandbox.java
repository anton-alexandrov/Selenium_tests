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
            System.out.println("E: " + e.getText());
        }


        List<WebElement> list = app.getContactHelper().getAllContactsByXpath();
        for (WebElement element : list){
            System.out.println("Text: " + element.getText());
         }


    }

    @Test
    public void one() {
        app.getNavigationHelper().gotoHomePage();
        System.out.println(app.getContactHelper().getOne().getText());
    }
}
