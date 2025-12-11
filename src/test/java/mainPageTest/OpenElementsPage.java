package mainPageTest;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.MainPage;

import static browser.Config.START_URL;
import static pages.MainPage.COUNT_CATEGORY_CARDS;

public class OpenElementsPage {
    private WebDriver driver;
    private MainPage mainPage;

    // добавляется переменная, так как нам нужен экземпляр новой страницы
    private ElementsPage elementsPage;

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        // выносим открытие главной страницы в предусловие
        mainPage.openURL(START_URL);
    }

    @Test
    public void step_1(){
        elementsPage = mainPage.openElements();
        Assert.assertTrue(elementsPage.isPageOpen());
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
