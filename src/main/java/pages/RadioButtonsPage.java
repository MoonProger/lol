package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class RadioButtonsPage extends BasePage {
    public RadioButtonsPage(WebDriver driver) {
        super(driver);
    }
    public By headerLocator = By.xpath("//div[@class='main-header' and text()='Radio Button']");
    public static final String RADIO_BUTTON_XPATH = "//input[@type='radio'][following-sibling::label[contains(., '%s')]]";
    public static final String RADIO_BUTTON_CLICK_XPATH = "//input[@type='radio']/following-sibling::label[contains(., '%s')]";
    public static final String RADIO_BUTTON_NAME_1 = "Yes";
    public boolean isPageOpen(){
        return driver.findElement(headerLocator).isDisplayed();
    }

    public boolean getStateRadioButton(String radioButtonName){
        By locator = By.xpath(String.format(RADIO_BUTTON_XPATH,radioButtonName));
        return driver.findElement(locator).isSelected();
    }

    public void setRadioButton(String radioButtonName){
        By locator = By.xpath(String.format(RADIO_BUTTON_CLICK_XPATH, radioButtonName));
        driver.findElement(locator).click();
    }

    public boolean radioButtonIsEnabled(String radioButtonName){
        By locator = By.xpath(String.format(RADIO_BUTTON_XPATH, radioButtonName));
        return driver.findElement(locator).isEnabled();
    }

}
