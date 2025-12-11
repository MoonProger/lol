package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import javax.swing.plaf.PanelUI;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public By categoryCards = By.xpath("//div[@class='card mt-4 top-card']//h5[contains(text(), '')]");

    public By categoryCardsElements = By.xpath("//div[@class='card mt-4 top-card']//h5[contains(text(), 'Elements')]");

    public static final int COUNT_CATEGORY_CARDS = 6;

    public int getCategoryCount(){
        return driver.findElements(categoryCards).size();
    }

    public ElementsPage openElements(){
        driver.findElement(categoryCardsElements).click();
        return new ElementsPage(driver);
    }

}
