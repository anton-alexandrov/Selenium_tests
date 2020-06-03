import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GroupDelete {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        driver.get("http://localhost/addressbook/index.php");
        driver.manage().window().setSize(new Dimension(1920, 977));
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div/div[4]/form/input[3]")).click();
    }

    @Test
    public void testGroupDeletion() {
        gotoGroupPage();
        initGroupDeletion();
        gotoGroupPage();
    }


    private void initGroupDeletion() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
    }

    private void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
