package HurtMePlenty.Tests;

import HurtMePlenty.PageObject.CloudGoogleDotComPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CloudGoogleDotComTests {
    private WebDriver driver;
    private CloudGoogleDotComPageObject webPage;
    @BeforeMethod(alwaysRun = true)
    public  void resetBrowser() {
        driver=new ChromeDriver();
        webPage=new CloudGoogleDotComPageObject(driver)
                .openPage()
                .submitSearchRequest()
                .openRequestedSearchResult()
                .fillEstimateFormFields()
                .submitAddToEstimate();
    }
    @Test(description = "Test for https://cloud.google.com/")
    public  void checkEstimateFields() {
        List<String> estimateFieldsValues=webPage.getEstimateFormValues();
        Boolean checkVMClass=estimateFieldsValues.get(1).equalsIgnoreCase("VM class: regular");
        Boolean checkInstanceType=estimateFieldsValues.get(2).equalsIgnoreCase("Instance type: n1-standard-8");
        Boolean checkRegion=estimateFieldsValues.get(3).equalsIgnoreCase("Region: Frankfurt");
        Boolean checkLocalSSD=estimateFieldsValues.get(4).equalsIgnoreCase("Total available local SSD space 2x375 GiB");
        Boolean checkCommitmentTerm=estimateFieldsValues.get(5).equalsIgnoreCase("Commitment term: 1 Year");

        Assert.assertTrue(checkVMClass&checkInstanceType&checkRegion&checkLocalSSD&checkCommitmentTerm
                ,"Estimate form values differ from expected!");
    }
    @Test(description = "Test for https://cloud.google.com/")
    public  void checkMonthlyPayment() {
        Assert.assertEquals(webPage.getTotalEstimatedCost(), 1082.77, 0.0
                , "Monthly payment value differ from expected!");
    }

    @AfterMethod(alwaysRun = true)
    public  void quiteBrowser() {
        driver.quit();
        driver=null;
    }
}
