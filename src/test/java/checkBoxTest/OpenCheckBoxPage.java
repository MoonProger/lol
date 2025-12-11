package checkBoxTest;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.ElementsPage;
import pages.MainPage;
import pages.TextBoxPage;

import static browser.Config.START_URL;

public class OpenCheckBoxPage {
    private WebDriver driver;
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private CheckBoxPage checkBoxPage;


    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        // выносим открытие главной страницы в предусловие
        mainPage.openURL(START_URL);
        elementsPage = mainPage.openElements();
    }

    @Test
    public void step_1(){
        checkBoxPage = elementsPage.openCheckBoxPage();
        Assert.assertTrue(checkBoxPage.isPageOpen());
    }

    @Test
    public void step_2(){
        checkBoxPage.openListCheckBox("Home");
        checkBoxPage.setCheckBox("Desktop",false);
        checkBoxPage.getCheckBoxState("Desktop");
        //Assert.assertTrue(checkBoxPage.getCheckBoxState("Home"));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
