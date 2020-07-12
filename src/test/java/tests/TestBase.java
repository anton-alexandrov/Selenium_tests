package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    //we need static here ^ to make app available for all classes and methods.
    protected WebDriver driver;

    @BeforeSuite //run browser one time for the whole suit
    public void setUp() {
        app.init();
    }


    @AfterSuite
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
