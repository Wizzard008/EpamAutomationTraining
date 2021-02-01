package BringItOnPasteBin.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PasteBinWebPage{
    private static final String HOMEPAGE_URL="https://pastebin.com/";
    private final WebDriver driver;
    private final int WAIT_TIMEOUT_SECONDS=10;
    private String outputLineForPaste;

    @FindBy(id = "postform-text")
    private WebElement codePasteField;

    @FindBy(id = "select2-postform-format-container")
    WebElement syntaxSelector;

    @FindBy(className = "select2-search__field")
    WebElement syntaxInputField;

    @FindBy(className = "toggle__control")
    WebElement enableSyntaxHighlight;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    WebElement expiration10MinSelector;

    @FindBy(xpath = "//*[@role='combobox']")
    List<WebElement> pageComboBoxes;

    @FindBy(id = "postform-name")
    WebElement titleField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(className = "textarea")
    WebElement rawTextInput;

    @FindBy(xpath = "//li[@class='li1']/div/span[@class='kw2']")
    List<WebElement> listOfGitParts;

    @FindBy(xpath = "//li[@class='li1']/div/span[@class='re5']")
    List<WebElement> listOfAttributeParts;

    @FindBy(xpath = "//li[@class='li1']/div/span[@class='st0']")
    List<WebElement> listOfValuesParts;

    public PasteBinWebPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public PasteBinWebPage openPage(){
        driver.get(HOMEPAGE_URL);
//        driver.manage().window().maximize();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(CompletionOfPageScripts.jQueryAJAXsCompleted());
        return this;
    }

    public PasteBinWebPage editPasteField(){
        outputLineForPaste="git config --global user.name  \"New Sheriff in Town\"\n"+
                           "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"+
                           "git push origin master --force";
        codePasteField.sendKeys(outputLineForPaste);
        return this;
    }
    public PasteBinWebPage editSyntaxField(){
        syntaxSelector.click();
        syntaxInputField.sendKeys("Bash\n");
        enableSyntaxHighlight.click();
        return this;
    }
    public PasteBinWebPage editExpirationField(){
        pageComboBoxes.get(1).click();
        expiration10MinSelector.click();
        return this;
    }
    public PasteBinWebPage editTitleField(){
        titleField.sendKeys("how to gain dominance among developers");
        return this;
    }
    public PasteBinWebPage submitPaste(){
        submitButton.click();
        return this;
    }

    public Boolean checkPasteTitle(){
        WebElement pageTitleToBeChecked=new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='info-top']/h1")));
        return pageTitleToBeChecked.getText().equalsIgnoreCase("how to gain dominance among developers");
    }
    public Boolean checkSyntaxFormat(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(CompletionOfPageScripts.jQueryAJAXsCompleted());
        boolean checkFormatOfData=true;
        for (WebElement text:listOfGitParts) {
            if ((!text.getCssValue("color").equalsIgnoreCase("rgb(194, 12, 185)"))|
                    (!text.getCssValue("font-weight").equalsIgnoreCase("700"))){

                checkFormatOfData=false;break;
            }
        }
        if(checkFormatOfData) {
            for (WebElement text : listOfAttributeParts) {
                if((!text.getCssValue("color").equalsIgnoreCase("rgb(102, 0, 51)"))|
                        (!text.getCssValue("font-weight").equalsIgnoreCase("400"))){
                    checkFormatOfData=false;break;
                }
            }
        }
        if(checkFormatOfData) {
            for (WebElement text : listOfValuesParts) {
                if((!text.getCssValue("color").equalsIgnoreCase("rgb(255, 0, 0)"))|
                        (!text.getCssValue("font-weight").equalsIgnoreCase("400"))){
                    checkFormatOfData=false;break;
                }
            }
        }
        return checkFormatOfData;
    }
    public Boolean checkPasteText(){
        return outputLineForPaste.equalsIgnoreCase(rawTextInput.getAttribute("value"));
    }


}
