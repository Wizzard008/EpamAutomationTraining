package BringItOnPasteBin.Tests;

import BringItOnPasteBin.PageObject.PasteBinWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteBinWebPageTest {
    private WebDriver driver;
    private PasteBinWebPage webPage;
    @BeforeMethod(alwaysRun = true)
    public  void resetBrowser() {
        driver=new ChromeDriver();
        webPage=new PasteBinWebPage(driver)
                .openPage()
                .editPasteField()
                .editSyntaxField()
                .editExpirationField()
                .editTitleField()
                .submitPaste();


    }
    @Test(description = "Test for https://pastebin.com")
    public  void PasteTitleTest() {

        Assert.assertTrue(webPage.checkPasteTitle(),"Title not match with input data!");
    }
    @Test(description = "Test for https://pastebin.com")
    public  void SyntaxFormatTest() {
        Assert.assertTrue(webPage.checkSyntaxFormat(), "Syntax not highlighted as Git!");
    }
    @Test(description = "Test for https://pastebin.com")
    public  void PasteTextTest() {
        Assert.assertTrue(webPage.checkPasteText(), "Paste field text not match with input data!");
    }
    @AfterMethod(alwaysRun = true)
    public  void quiteBrowser() {
        driver.quit();
        driver=null;
    }
}
