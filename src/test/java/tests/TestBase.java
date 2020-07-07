package tests;

import appmanager.ApplicationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.GroupData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    protected WebDriver driver;

    @Before
    public void setUp() {
        app.init();
    }


    @After
    public void tearDown() {
        app.stop();
    }


    protected void login() {
        driver.get("http://localhost/addressbook/index.php");
        driver.manage().window().setSize(new Dimension(1920, 977));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("/html/body/div/div[4]/form/input[3]")).click();
    }



}
