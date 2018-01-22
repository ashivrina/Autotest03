package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase {

    public static WebDriver driver;

    @BeforeSuite (alwaysRun = true)
    public void setUpTestSuite() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownTestSuite() {
        driver.close();
    }
}
