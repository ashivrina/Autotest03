package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RegressionTest {
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

    @Test(groups = {"regression"})
    public void checkImages() {
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement image : images) {
            Assert.assertTrue(image.isDisplayed());
        }
    }

    @Test(groups = {"regression"})
    public void checkTexts() {
        String expectedText1 = "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM projec";
        String expectedText2 = "To be flexible and\n" +
                "customizable";
        String expectedText3 = "To be multiplatform";
        String expectedText4 = "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…";
        List<WebElement> textUnderIcons = driver.findElements(By.className("benefit-txt"));

        for (WebElement text : textUnderIcons) {
            Assert.assertTrue(text.isDisplayed());
        }

        Assert.assertEquals(textUnderIcons.get(0).getText(), expectedText1);
        Assert.assertEquals(textUnderIcons.get(1).getText(), expectedText2);
        Assert.assertEquals(textUnderIcons.get(2).getText(), expectedText3);
        Assert.assertEquals(textUnderIcons.get(3).getText(), expectedText4);
    }
}
