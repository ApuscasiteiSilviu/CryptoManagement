package page.github;

import cucumber.api.java.de.Wenn;
import driver.Driver;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubRepositoryPage {

    private WebDriver driver;

    @FindBy(css = "span>a[title=\"This path skips through empty directories\"]")
    private WebElement srcMainDirectory;

    @FindBy(css = "span>a[title=\"resources\"]")
    private WebElement resourcesDirectory;

    @FindBy(css = "span>a[title=\"user.properties\"]")
    private WebElement userPropertiesFile;

    @FindBy(css = "button[class='btn-octicon btn-octicon-danger tooltipped tooltipped-nw']")
    private WebElement deleteButton;

    @FindBy(css = "button#submit-file")
    private WebElement commitChangesButton;

    @FindBy(css = "button[class='btn btn-sm BtnGroup-item']")
    private WebElement createNewFileButton;

    @FindBy(css = "input[class='form-control js-blob-filename js-breadcrumb-nav mr-1 mt-1 mt-sm-0 col-12 width-sm-auto']")
    private WebElement inputName;

    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div/form[2]/div[5]/div[2]/div/div[5]/div[1]/div/div/div/div[5]")
    private WebElement file;

    @FindBy(css = "input#commit-summary-input")
    private WebElement commitMessageInput;

    @FindBy(css = "button[class='btn btn-primary js-blob-submit flex-auto mx-3 ml-md-3 mr-md-0 ml-lg-0 mb-3 mb-md-0']")
    private WebElement commitNewFileButton;

    public GitHubRepositoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToDeleteFile(){
        Driver.waitForElementToLoad(srcMainDirectory, 20);
        srcMainDirectory.click();
        Driver.waitForElementToLoad(resourcesDirectory, 20);
        resourcesDirectory.click();
        Driver.waitForElementToLoad(userPropertiesFile, 20);
        userPropertiesFile.click();
        Driver.waitForElementToLoad(deleteButton, 20);
        deleteButton.click();
        Driver.waitForElementToLoad(commitChangesButton, 20);
        commitChangesButton.click();
    }

    public void clickToCreateNewFile(){
        Driver.waitForElementToLoad(createNewFileButton, 20);
        createNewFileButton.click();
    }

    public void setTextToNewNameInput(String name) {
        Driver.waitForElementToLoad(inputName, 20);
        inputName.sendKeys(name);
    }

    public void writeText(String text){
        Driver.waitForElementToLoad(file, 20);
        file.click();
        file.sendKeys(text);
    }

    public void setTextToCommitMessageInput(String text){
        Driver.waitForElementToLoad(commitMessageInput, 20);
        commitMessageInput.sendKeys(text);
    }

    public void commitChanges(){
        Driver.waitForElementToLoad(commitNewFileButton, 20);
        commitNewFileButton.click();
    }
}
