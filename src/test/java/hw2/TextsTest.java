package hw2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TextsTest extends TestBase {

    @DataProvider(parallel = true)
    public Object[][] correctTexts() {
        return new Object[][]{
                {0, "To include good practices and ideas from successful EPAM projec"},
                {1, "To be flexible and customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base (about 20 internal and some external projects), wish to get more…"}
        };
    }

    @Test(dataProvider = "correctTexts")
    public void testTexts(int textNumber, String s) {
        driver.navigate().to("https://jdi-framework.github.io/tests");
        List<WebElement> textUnderIcons = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(textUnderIcons.get(textNumber).getText().replaceAll("\n", " "), s);
    }
}
