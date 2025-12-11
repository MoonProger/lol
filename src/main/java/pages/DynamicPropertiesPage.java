package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class DynamicPropertiesPage extends BasePage {
    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }
    public By headerLocator = By.xpath("//div[@class='main-header' and text()='Dynamic Properties']");
    public static final By BTN_ENABLE_AFTER = By.id("enableAfter");
    public static final By BTN_COLOR_CHANGE = By.id("colorChange");
    public static final By BTN_VISIBLE_AFTER = By.id("visibleAfter");
    public static final String color = "rgba(220, 53, 69, 1)";
    public boolean isPageOpen(){
        return driver.findElement(headerLocator).isDisplayed();
    }

    public String getColorBtn(){
        WebElement element = driver.findElement(BTN_COLOR_CHANGE);

        return element.getCssValue("color");
    }

    public boolean isColorChange(){
        return getColorBtn().equals(color);
    }
}
