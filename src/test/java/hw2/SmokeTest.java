package hw2;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @BeforeTest
    public void setUp() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @Test(groups = {"smoke"})
    public void testTitle() {
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @Test(groups = {"smoke"})
    public void testUserName() {
        WebElement profilePicture = driver.findElement(By.cssSelector(".uui-profile-menu"));
        profilePicture.click();

        WebElement loginField = driver.findElement(By.cssSelector("#Login"));
        loginField.click();
        loginField.sendKeys("epam");

        WebElement passwordField = driver.findElement(By.cssSelector("#Password"));
        passwordField.click();
        passwordField.sendKeys("1234");

        WebElement enterButton = driver.findElement(By.cssSelector(".fa-sign-in"));
        enterButton.click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo>span"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }
}
