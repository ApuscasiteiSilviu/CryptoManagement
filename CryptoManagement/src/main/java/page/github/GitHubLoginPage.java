package page.github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubLoginPage {
    private WebDriver driver;

    @FindBy(css = "input#login_field")
    WebElement usernameInput;

    @FindBy(css = "input#password")
    WebElement passwordInput;

    @FindBy(css = "input[name='commit']")
    WebElement signInButton;

    public GitHubLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public void setTextToUsernameInput(String username){
        usernameInput.sendKeys(username);
    }

    public void setTextToPasswordInput(String password){
        passwordInput.sendKeys(password);
    }

    public GitHubUserPage clickToSignInButton(){
        signInButton.click();
        return PageFactory.initElements(driver, GitHubUserPage.class);
    }
}
