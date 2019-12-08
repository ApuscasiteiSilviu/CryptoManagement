package page.github;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubRepositoryPage {

    private WebDriver driver;

    @FindBy(css = "span>a[title=\"CryptoManagement\"]")
    WebElement repoDirectory;

    public GitHubRepositoryPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public void clickToDeleteFile() throws InterruptedException {
        repoDirectory.click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span>a[title=\"This path skips through empty directories\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span>a[title=\"resources\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span>a[title=\"user.properties\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='btn-octicon btn-octicon-danger tooltipped tooltipped-nw']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button#submit-file")).click();
        Thread.sleep(2000);
    }

    public void clickToCreateNewFile(){
        driver.findElement(By.cssSelector("button[class='btn btn-sm BtnGroup-item']")).click();
    }

    public void setTextToNewNameInput(String name){
        driver.findElement(By.cssSelector("input[class='form-control js-blob-filename js-breadcrumb-nav mr-1 mt-1 mt-sm-0 col-12 width-sm-auto']")).sendKeys(name);
    }

    public void writeText(String text){
        WebElement file = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div/div/form[2]/div[5]/div[2]/div/div[5]/div[1]/div/div/div/div[5]"));
        file.click();
        file.sendKeys(text);
    }

    public void setTextToCommitMessageInput(String text){
        driver.findElement(By.cssSelector("input#commit-summary-input")).sendKeys(text);
    }

    public void commitChanges(){
        driver.findElement(By.cssSelector("button[class='btn btn-primary js-blob-submit flex-auto mx-3 ml-md-3 mr-md-0 ml-lg-0 mb-3 mb-md-0']")).click();
    }
}
