package page.github;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubUserPage {
    private WebDriver driver;

    @FindBy(css = "ul>li>div>a>span[title=\"CryptoManagement\"]")
    private WebElement repository;

    public GitHubUserPage(WebDriver driver){
        this.driver = driver;
    }

    public GitHubRepositoryPage clickToRepository(){
        Driver.waitForElementToLoad(repository, 20);
        repository.click();
        return PageFactory.initElements(driver, GitHubRepositoryPage.class);
    }
}
