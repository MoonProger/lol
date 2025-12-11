package radioButtonsTest;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.MainPage;
import pages.RadioButtonsPage;

import static browser.Config.START_URL;

public class openRadioButtonsPage {
    private WebDriver driver;
    private MainPage mainPage;

    private RadioButtonsPage radioButtonsPage;
    private ElementsPage elementsPage;


    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        driver.get(START_URL);
        elementsPage = mainPage.openElements();

    }
    @Test
    public void step_1(){
        radioButtonsPage = elementsPage.openRadioButtonPage();
        Assert.assertTrue(radioButtonsPage.isPageOpen());
    }
    @Test
    public void step_2(){
        radioButtonsPage.setRadioButton("Yes");
        Assert.assertTrue(radioButtonsPage.getStateRadioButton("Yes"));
    }
    @Test
    public void step_3(){
        radioButtonsPage.setRadioButton("Impressive");
        Assert.assertFalse(radioButtonsPage.getStateRadioButton("Yes"));
        Assert.assertTrue(radioButtonsPage.getStateRadioButton("Impressive"));
        Assert.assertFalse(radioButtonsPage.radioButtonIsEnabled("No"));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}

