import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class Webtest {
    @Test
    public void test1() {
        setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");

        WebElement element = driver.findElement(By.className("header-search__button"));
        element.click();

        WebElement menuButton = driver.findElement(By.cssSelector(".hamburger-menu__button"));
        Assert.assertTrue(menuButton.isDisplayed());
        Assert.assertEquals(menuButton.getText(), "MENU");

        menuButton.getAttribute("class");

//        driver.close();
    }

 /*@Test
    public void test2() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        driver.close();
    }*/

}
