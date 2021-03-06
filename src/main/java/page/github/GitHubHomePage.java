package page.github;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubHomePage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/a[1]")
    private WebElement signInButton;

    public GitHubHomePage(WebDriver driver){
        this.driver = driver;
    }

    public GitHubLoginPage clicktoSignInButton(){
        Driver.waitForElementToLoad(signInButton, 20);
        signInButton.click();
        return PageFactory.initElements(driver, GitHubLoginPage.class);
    }

}
