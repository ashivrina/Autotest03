package hw2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeAndRegressionTest extends TestBase {

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
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
