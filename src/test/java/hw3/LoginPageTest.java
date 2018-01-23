package hw3;

import base.TestBase;
import enums.IndexPageTextsEnum;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.LoginPage;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;

    @BeforeClass
    public void setUpPages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginTest() {
        //1 Open website by URL
        loginPage.open(driver);

        //2 Assert Browser title
        loginPage.checkPageTitle(driver, "Index Page");

        //3 Perform login
        loginPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is logged in
        loginPage.checkUsername("PITER CHAILOVSKII");

        //5 Assert Browser title...again
        loginPage.checkPageTitle(driver, "Index Page");

        //6 Assert that there are 4 images on the Home Page and they are displayed
        loginPage.checkImages();

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        loginPage.checkTextsUnderImages(IndexPageTextsEnum.values());

        //8 Assert that there are the main header and the text below it on the Home Page
        loginPage.checkHeaderDisplayed();
        loginPage.checkSubheaderDisplayed();
    }
}
