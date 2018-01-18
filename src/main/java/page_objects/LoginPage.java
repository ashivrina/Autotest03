package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo>span")
    private WebElement username;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsUnderImages;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".main-title.text-center")
    private WebElement header;

    @FindBy(css = ".main-txt.text-center")
    private WebElement subheader;

    public void open(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public void checkPageTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void login(String name, String password) {
        loginFormButton.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUsername(String fullName) {
        assertTrue(username.isDisplayed());
        assertEquals(username.getText(), fullName);
    }

    public void checkImages() {
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }
    }

    public void checkTextsUnderImages (List<String> correctTexts) {
        for (int i = 0; i < textsUnderImages.size(); i++) {
            assertTrue(textsUnderImages.get(i).isDisplayed());
            assertEquals(textsUnderImages.get(i).getText().replaceAll("\n", " "), correctTexts.get(i));
        }
    }

    public void checkHeaderDisplayed() {
        assertTrue(header.isDisplayed());
    }

    public void checkSubheaderDisplayed() {
        assertTrue(subheader.isDisplayed());
    }
}
