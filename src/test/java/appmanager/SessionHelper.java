package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.get("http://localhost/addressbook/index.php");
        driver.manage().window().setSize(new Dimension(1920, 977));
        type(By.name("user"),username);
        type(By.name("pass"), password);
        click(By.xpath("/html/body/div/div[4]/form/input[3]"));
    }
}
