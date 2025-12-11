package dynamicPage;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DynamicPropertiesPage;
import pages.ElementsPage;
import pages.MainPage;

import java.time.Duration;

import static browser.Config.START_URL;

public class OpenDynamicPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private DynamicPropertiesPage dynamicPropertiesPage;
    private ElementsPage elementsPage;

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        driver.get(START_URL);
        elementsPage = mainPage.openElements();

    }

    @Test
    public void step_1() throws InterruptedException {
        dynamicPropertiesPage = elementsPage.openDynamicPropertiesPage();
        Assert.assertTrue(dynamicPropertiesPage.isPageOpen());
    }

    @Test
    public void step_2(){
         new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(DynamicPropertiesPage.BTN_VISIBLE_AFTER));
         //new WebDriverWait(driver, Duration.ofSeconds(30)).until(d -> driver.findElement(DynamicPropertiesPage.BTN_VISIBLE_AFTER).isDisplayed());
         WebElement element = driver.findElement(DynamicPropertiesPage.BTN_VISIBLE_AFTER);
         element.click();

    }

    @Test
    public void step_3(){
        WebElement element = driver.findElement(DynamicPropertiesPage.BTN_ENABLE_AFTER);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(DynamicPropertiesPage.BTN_VISIBLE_AFTER));
        //new WebDriverWait(driver,Duration.ofSeconds(5)).until(d -> element.isEnabled());
        Assert.assertTrue(element.isEnabled());
    }
    @Test
    public void step_4(){
        WebElement element = driver.findElement(DynamicPropertiesPage.BTN_COLOR_CHANGE);
//        Assert.assertEquals(dynamicPropertiesPage.getColorBtn(),"rgba(220, 53, 69, 1)");
          new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> dynamicPropertiesPage.isColorChange());
//        Assert.assertEquals(dynamicPropertiesPage.getColorBtn(), DynamicPropertiesPage.color);

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}