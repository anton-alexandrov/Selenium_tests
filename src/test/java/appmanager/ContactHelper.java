package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }


    protected void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("address"), contactData.getFirstAddress());
        click(By.name("quickadd"));

        click(By.xpath("/html/body/div/div[4]/form/input[2]"));
        click(By.name("firstname"));
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getName());
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public List<WebElement> getAllContacts() {
        List<WebElement> list = driver.findElements(By.name("selected[]"));
        return list;
    }



    public List<WebElement> getAllRows() {

        String before = "//*[@id=\"maintable\"]/tbody/tr[";
        String after = "]/td[3]";
        String result = "";
        List<String> list = new ArrayList<>();
        List<WebElement> elements = new ArrayList<>();

        for (int i = 2; i < getAllContacts().size()+2; i++) {
            result = before + i + after;
            list.add(result);
        }

        for (String s:list){
            elements.add(driver.findElement(By.xpath(s)));
        }

        return elements;

    }

    public WebElement getOne () {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[3]"));
        return element;
    }


}
