package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeSuite
    public void setupBeforeSuite() {
        setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void performBeforeMethod() {
        System.out.println(System.currentTimeMillis());
    }


    @AfterMethod
    public void performAfterMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @AfterSuite
    public void tearDownTestSuite() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @Test
    public void testWebsite() {
        //1 Open website by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().fullscreen();


        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#Login")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal [type='submit']")).click();

        //4 Assert User name in the left-top side of screen that user is logged in
//        WebElement userName = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/span"));
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo>span"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title...again
        assertEquals(driver.getTitle(), "Index Page");

        //6 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
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

        //8 Assert that there are the main header and the text below it on the Home Page
        WebElement header = driver.findElement(By.cssSelector(".main-title.text-center"));
        assertTrue(header.isDisplayed());
        WebElement subHeader = driver.findElement(By.cssSelector(".main-txt.text-center"));
        assertTrue(subHeader.isDisplayed());
    }
}
