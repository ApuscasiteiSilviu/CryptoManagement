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

    public void openFile() throws InterruptedException {
        repoDirectory.click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span>a[title=\"This path skips through empty directories\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span>a[title=\"resources\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span>a[title=\"application.properties\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='btn-octicon tooltipped tooltipped-nw']")).click();
        Thread.sleep(2000);
    }
}
