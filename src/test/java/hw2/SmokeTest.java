package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTest {
    private WebDriver driver;

    @BeforeTest (alwaysRun = true)
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @AfterTest (alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"smoke"})
    public void testTitle() {
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    @Test(groups = {"smoke"})
    public void testUserName() {

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

        WebElement userName = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/span"));
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }
}
