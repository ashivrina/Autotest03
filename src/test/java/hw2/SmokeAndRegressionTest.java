package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeAndRegressionTest {
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"smoke", "regression"})
    public void checkHeader() {
        WebElement header = driver.findElement(By.cssSelector(".main-title.text-center"));
        Assert.assertTrue(header.isDisplayed());
    }

    @Test(groups = {"smoke", "regression"})
    public void checkSubheader() {
        WebElement subHeader = driver.findElement(By.cssSelector(".main-txt.text-center"));
        Assert.assertTrue(subHeader.isDisplayed());
    }
}
