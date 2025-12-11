package WebFormPageTests;

import browser.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.base.WebFormPage;

import static browser.Config.START_URL;
import static pages.MainPage.COUNT_CATEGORY_CARDS;

public class webFormPage {
    private WebDriver driver;
    private WebFormPage webFormPage;

    @BeforeTest
    public void beforeTest(){
        driver = Browser.createDriver();
        webFormPage = new WebFormPage(driver);
        webFormPage.openURL(START_URL);
    }

    @Test
    public void step_1() throws InterruptedException {
        webFormPage.setTextInput("FIO");
        webFormPage.setTextArea("FIO");
        webFormPage.setPassword("AMOGUS");
        Assert.assertEquals(webFormPage.getTextInputText(),"FIO");
        Assert.assertEquals(webFormPage.getPasswordText(),"AMOGUS");
        Assert.assertEquals(webFormPage.getTextAreaText(),"FIO");
    }

    @Test
    public void step_2() throws InterruptedException {
        webFormPage.setCheckBox("Checked checkbox",true);
        webFormPage.setCheckBox("Default checkbox",true);
        Assert.assertTrue(webFormPage.getCheckBoxState("Checked checkbox"));
        Assert.assertTrue(webFormPage.getCheckBoxState("Default checkbox"));
    }

    @Test
    public void step_3() throws InterruptedException {
        webFormPage.setRadioButton("Default radio");
        Assert.assertTrue(webFormPage.getStateRadioButton("Default radio"));
    }

    @Test
    public void step_5() throws InterruptedException {
        webFormPage.clickSubmit();
        Assert.assertEquals(webFormPage.getText1(),"Form submitted");
        Assert.assertEquals(webFormPage.getText2(),"Received!");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
