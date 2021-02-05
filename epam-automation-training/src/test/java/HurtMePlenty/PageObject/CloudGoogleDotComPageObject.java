package HurtMePlenty.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CloudGoogleDotComPageObject {
    private WebDriver driver;
    private static final String HOMEPAGE_URL="https://cloud.google.com/";
    private final int WAIT_TIMEOUT_SECONDS=30;

    @FindBy(xpath = "//form[@class='devsite-search-form']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchInputField;

    @FindBy(xpath = "//iframe[@src='/products/calculator/" +
            "index_ad8ca20a6d1799e286a0c0839aeb86ca523afe927b04501d8ba77dc59e5b8523.frame']")
    WebElement iFrame;

    public CloudGoogleDotComPageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public CloudGoogleDotComPageObject submitSearchRequest(){
        searchButton.click();
        searchInputField.sendKeys("Google Cloud Platform Pricing Calculator\n");
        return this;
    }

    public CloudGoogleDotComPageObject openRequestedSearchResult(){
        List<WebElement> titleInputs=new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//div[@class='gsc-thumbnail-inside']/div/a")));
        for (WebElement searchResult:titleInputs) {
            if(searchResult.getText().contains("Google Cloud Platform Pricing Calculator"))searchResult.click();break;
        }
        return this;
    }
    public CloudGoogleDotComPageObject openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public void selectCalculatorFrame(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(iFrame));
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt("myFrame"));
    }

    public CloudGoogleDotComPageObject fillEstimateFormFields(){
        selectCalculatorFrame();
        //Number of instances: 4
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//input[@id='input_63' and @name='quantity']"))).sendKeys("4");

        //What are these instances for?: оставить пустым
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("input_64"))).clear();

        //Operating System Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_76"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_65"))).click();

        //VM Class: Regular
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_80"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_78"))).click();

        //Instance type: n1
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_88"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_188"))).click();

        //Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_90"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']"))).click();

//        driver.findElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")).click();
        //Выбрать Add GPUs
        WebElement addGPUCheckBox=new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-checkbox[@aria-label='Add GPUs']")));
//        WebElement addGPUCheckBox= driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']"));
        if(addGPUCheckBox.getAttribute("aria-checked").equalsIgnoreCase("false"))addGPUCheckBox.click();

        //Number of GPUs: 1
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_394"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-option[@ng-repeat='item in listingCtrl" +
                        ".supportedGpuNumbers[listingCtrl.computeServer.gpuType]' " +
                        "and @value='1']"))).click();

        //GPU type: NVIDIA Tesla V100
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_396"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']"))).click();

        //Local SSD: 2x375 Gb
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-select[contains(@aria-label,'Local SSD')]"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_381"))).click();

        //Datacenter location: Frankfurt (europe-west3)
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-select[contains(@aria-label,'Datacenter')]"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_205"))).click();

        //Committed usage: 1 Year
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//md-select[contains(@aria-label,'Committed usage')]"))).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.id("select_option_97"))).click();

        return this;
    }

    public CloudGoogleDotComPageObject submitAddToEstimate(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .elementToBeClickable(By.xpath("//button[contains(@aria-label,'Add to Estimate')]"))).click();
        return this;
    }

    public int getInstances(){
        String textFieldValue =new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[contains(@class  ,'ng-scope')]")))
                .getText();
        textFieldValue=textFieldValue.substring(0,textFieldValue.indexOf(" "));
    return Integer.parseInt(textFieldValue);
    }

    public List<String> getEstimateFormValues(){
        List<WebElement> elementsOfEstimatedForm = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class  ,'md-list-item-text ng-binding')]")));
        List<String> valuesOfEstimatedForm = new ArrayList<>();
        for (WebElement element:elementsOfEstimatedForm) {
            valuesOfEstimatedForm.add(element.getText());
        }
        return valuesOfEstimatedForm;
    }

    public Double getTotalEstimatedCost(){
        String textFieldValue =new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id='resultBlock']/md-card/md-card-content//h2/b[@class='ng-binding']")))
                .getText();
        return Double.parseDouble(textFieldValue.substring(textFieldValue.indexOf(":")+5,textFieldValue.indexOf("p")-1)
                .replaceAll(",",""));
    }

//    public static void main(String[] args) {
//        WebDriver driver=new ChromeDriver();
//        System.out.println(new CloudGoogleDotComPageObject(driver)
//                .openPage()
//                .submitSearchRequest()
//                .openRequestedSearchResult()
//                .fillEstimateFormFields()
//                .submitAddToEstimate().getTotalEstimatedCost());
//
//
//    }
}
