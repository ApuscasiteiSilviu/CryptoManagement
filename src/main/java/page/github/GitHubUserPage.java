package page.github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubUserPage {
    private WebDriver driver;

    @FindBy(css = "ul>li>div>a>span[title=\"CryptoManagement\"]")
    WebElement repository;

    public GitHubUserPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public GitHubRepositoryPage clickToRepository(){
        repository.click();
        return PageFactory.initElements(driver, GitHubRepositoryPage.class);
    }
}
