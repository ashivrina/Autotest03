package page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DropdownEnum;
import enums.RadioButtonsEnum;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage {

    @FindBy(css = "#mCSB_1_container")
    private SelenideElement leftPanel;

    @FindBy(css = "#mCSB_2_container")
    private SelenideElement rightPanel;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radiobuttons;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".panel-body-list.logs li")
    private ElementsCollection logPanelTexts;

    public void checkDifferentElementsPageInterface() {
        leftPanel.shouldBe(visible);
        rightPanel.shouldBe(visible);
        checkboxes.shouldHaveSize(4);
        radiobuttons.shouldHaveSize(4);
    }

    public void selectCheckboxes() {
        SelenideElement waterCheckbox = checkboxes.find(text("Water"));
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldBe(checked);

        SelenideElement windCheckbox = checkboxes.find(text("Wind"));
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldBe(checked);
    }

    public void deselectCheckboxes() {
        SelenideElement waterCheckbox = checkboxes.find(text("Water"));
        waterCheckbox.find("input").click();
        waterCheckbox.find("input").shouldNotBe(checked);

        SelenideElement windCheckbox = checkboxes.find(text("Wind"));
        windCheckbox.find("input").click();
        windCheckbox.find("input").shouldNotBe(checked);
    }

    public void selectRadiobutton(RadioButtonsEnum radiobutton) {
        String radiobuttonText = radiobutton.text;
        SelenideElement selenRadiobutton = radiobuttons.find(text(radiobuttonText));
        selenRadiobutton.find("input").click();
        selenRadiobutton.find("input").shouldBe(checked);
    }

    public void selectDropdownOption(DropdownEnum dropdownOption) {
        String dropdownOptionText = dropdownOption.text;
        dropdown.click();
        dropdown.selectOption(dropdownOptionText);
    }

    public void checkLog(String value, String status) {
        SelenideElement logLine = logPanelTexts.find(text(value));
        logLine.shouldHave(text(status));
    }
}
