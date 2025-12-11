package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebFormPage {
    protected WebDriver driver;

    public WebFormPage(WebDriver driver){
        this.driver = driver;
    }
    public void openURL(String url){
        driver.get(url);
    }

    public By textInputLocator = By.id("my-text-id");
    public By passwordLocator = By.xpath("//input[@type='password']");
    public By textAreaLocator = By.xpath("//textarea[@class='form-control']");


    public static final String CHECK_BOX_INPUT_XPATH = "//label[contains(normalize-space(), '%s')]";
    public static final String CHECK_BOX_XPATH = CHECK_BOX_INPUT_XPATH + "/input";

    public static final String RADIO_BUTTON_CLICK_XPATH = "//label[contains(normalize-space(), '%s')]";
    public static final String RADIO_BUTTON_XPATH = RADIO_BUTTON_CLICK_XPATH + "/input";

    public By buttonLocator = By.xpath("//button[@type='submit']");
    public static final String OUTPUT_XPATH = "//h1[text()='%s']";

    public void setTextInput(String fullName){
        driver.findElement(textInputLocator).sendKeys(fullName);
    }
    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void setTextArea(String text) {
        driver.findElement(textAreaLocator).sendKeys(text);
    }

    public boolean getCheckBoxState(String checkBoxName){
        return driver.findElement(By.xpath(String.format(CHECK_BOX_XPATH,checkBoxName))).isSelected();
    }
    public void setCheckBox(String checkBoxName, boolean state){
        //String locator = String.format(CHECK_BOX_XPATH, checkBoxName) + "/following-sibling::span[@class='rct-checkbox']";
        if (!getCheckBoxState(checkBoxName)==state){
            driver.findElement(By.xpath(String.format(CHECK_BOX_INPUT_XPATH,checkBoxName))).click();
        }
    }

    public boolean getStateRadioButton(String radioButtonName){
        By locator = By.xpath(String.format(RADIO_BUTTON_XPATH,radioButtonName));
        return driver.findElement(locator).isSelected();
    }

    public void setRadioButton(String radioButtonName){
        By locator = By.xpath(String.format(RADIO_BUTTON_CLICK_XPATH, radioButtonName));
        driver.findElement(locator).click();
    }

    public void clickSubmit() {
        driver.findElement(buttonLocator).click();
    }

    public String getTextInputText() {
        return driver.findElement(textInputLocator).getAttribute("value");
    }

    public String getPasswordText() {
        return driver.findElement(passwordLocator).getAttribute("value");
    }

    public String getTextAreaText() {
        return driver.findElement(textAreaLocator).getAttribute("value");
    }

    public String getText1() {
        String locator = String.format(OUTPUT_XPATH, "Form submitted");
        return driver.findElement(By.xpath(locator)).getText();
    }

    public String getText2() {
        String locator = String.format(OUTPUT_XPATH, "Received!");
        return driver.findElement(By.xpath(locator)).getText();
    }

}
