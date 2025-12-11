package textBoxTest;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.MainPage;
import pages.TextBoxPage;

import static browser.Config.START_URL;

public class EmailValidation {
    private WebDriver driver;
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;

    private String email = "test";
    public String emailInputErrorColor = "rgb(255, 0, 0)";

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        mainPage = new MainPage(driver);
        mainPage.openURL(START_URL);
        elementsPage = mainPage.openElements();
    }

    @Test
    public void step_1(){
        textBoxPage = elementsPage.openTextBoxPage();
        Assert.assertTrue(textBoxPage.isPageOpen());
    }

    @Test
    public void step_2(){
        textBoxPage.setEmail(email);
        textBoxPage.clickSubmit();
        textBoxPage.getInputEmailColor();
        Assert.assertEquals(textBoxPage.getInputEmailColor(), emailInputErrorColor);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
