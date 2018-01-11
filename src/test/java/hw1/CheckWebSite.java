package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static java.lang.System.setProperty;

public class CheckWebSite {
    private WebDriver driver;

    @Test
    public void testTitle() {
        //Open website by URL
        {
            setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().fullscreen();
            driver.navigate().to("https://jdi-framework.github.io/tests");
        }

        //Checking the browser title
        {
            Assert.assertEquals(driver.getTitle(), "Index Page");
        }

        //logging in to website
        {
            WebElement profilePicture = driver.findElement(By.className("uui-profile-menu"));
            profilePicture.click();

            WebElement loginField = driver.findElement(By.id("Login"));
            loginField.click();
            loginField.sendKeys("epam");

            WebElement passwordField = driver.findElement(By.id("Password"));
            passwordField.click();
            passwordField.sendKeys("1234");

            WebElement enterButton = driver.findElement(By.className("fa-sign-in"));
            enterButton.click();
        }

        //Checking username
        {
            WebElement userName = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/span"));
            Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
        }

        //Checking the browser title...again
        {
            Assert.assertEquals(driver.getTitle(), "Index Page");
        }

        //Checking that there are 4 images and they are displayed
        {
            List<WebElement> images = driver.findElements(By.className("benefit-icon"));
            Assert.assertEquals(images.size(), 4);
            for (WebElement image : images) {
                Assert.assertTrue(image.isDisplayed());
            }
        }

        //Checking that texts below images are expected
        {
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

        //Checking the header and subheader are displayed
        {
            WebElement header = driver.findElement(By.cssSelector(".main-title.text-center"));
            Assert.assertTrue(header.isDisplayed());

            WebElement subHeader = driver.findElement(By.cssSelector(".main-txt.text-center"));
            Assert.assertTrue(subHeader.isDisplayed());
        }

        //Closing the browser
        {
            driver.close();
        }
    }
}
