package hw2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegressionTest extends TestBase {

    @BeforeTest(alwaysRun = true)
    public void setup() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
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
        String[] correctTexts = {"To include good practices and ideas from successful EPAM projec",
                "To be flexible and customizable",
                "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"};

        List<WebElement> textUnderIcons = driver.findElements(By.cssSelector(".benefit-txt"));
        for (WebElement text : textUnderIcons) {
            assertTrue(text.isDisplayed());
        }
        for (int i = 0; i < textUnderIcons.size(); i++) {
            assertEquals(textUnderIcons.get(i).getText().replaceAll("\n", " "), correctTexts[i]);
        }
    }
}
