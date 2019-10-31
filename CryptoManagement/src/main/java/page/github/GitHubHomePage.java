package page.github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubHomePage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/a[1]")
    WebElement signInButton;

    public GitHubHomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public GitHubLoginPage clicktoSignInButton(){
        signInButton.click();
        return PageFactory.initElements(driver, GitHubLoginPage.class);
    }

}
