package page.github;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubLoginPage {
    private WebDriver driver;

    @FindBy(css = "input#login_field")
    private WebElement usernameInput;

    @FindBy(css = "input#password")
    private WebElement passwordInput;

    @FindBy(css = "input[name='commit']")
    private WebElement signInButton;

    public GitHubLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setTextToUsernameInput(String username){
        Driver.waitForElementToLoad(usernameInput, 20);
        usernameInput.sendKeys(username);
    }

    public void setTextToPasswordInput(String password){
        Driver.waitForElementToLoad(passwordInput, 20);
        passwordInput.sendKeys(password);
    }

    public GitHubUserPage clickToSignInButton(){
        Driver.waitForElementToLoad(signInButton, 20);
        signInButton.click();
        return PageFactory.initElements(driver, GitHubUserPage.class);
    }
}
