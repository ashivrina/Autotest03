package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TextsTest {
    @DataProvider(parallel = true)
    public Object[][] correctTexts() {
        return new Object[][] {
                {0, "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM projec"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
                };
    }

    @Test(dataProvider = "correctTexts")
    public void testTexts(int textNumber, String s) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        List<WebElement> textUnderIcons = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(textUnderIcons.get(textNumber).getText(), s);
        driver.close();
    }
}
