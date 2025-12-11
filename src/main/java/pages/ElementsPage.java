package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ElementsPage extends BasePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public By header = By.xpath("//div[@class='main-header' and text() = 'Elements']");
    public By message = By.xpath("//div[text() = 'Please select an item from left to start practice.']");
    public By textBoxLocator = By.xpath("//span[text()='Text Box']");
    public By checkBoxLocator = By.xpath("//span[text()='Check Box']");
    public By radioButtonLocator = By.xpath("//span[text()='Radio Button']");
    public By dynamicPropertiesLocator = By.xpath("//span[text()='Dynamic Properties']");

    public boolean isPageOpen() {
        boolean a = driver.findElement(header).isDisplayed();
        boolean b = driver.findElement(message).isDisplayed();
        return a && b;
    }

    public TextBoxPage openTextBoxPage() {
        driver.findElement(textBoxLocator).click();
        return new TextBoxPage(driver);
    }

    public CheckBoxPage openCheckBoxPage() {
        driver.findElement(checkBoxLocator).click();
        return new CheckBoxPage(driver);
    }

    public RadioButtonsPage openRadioButtonPage() {
        driver.findElement(radioButtonLocator).click();
        return new RadioButtonsPage(driver);
    }

    public DynamicPropertiesPage openDynamicPropertiesPage(){
        driver.findElement(dynamicPropertiesLocator).click();
        return new DynamicPropertiesPage(driver);
    }
}