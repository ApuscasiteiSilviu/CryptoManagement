package page.tradingView;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewLoginPage {

    private WebDriver driver;

    @FindBy(css = "input[name='username']")
    WebElement emailInput;

    @FindBy(css = "input[name='password']")
    WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public TradingViewLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setTextToEmailInput(String text){
        Driver.waitForElementToLoad(emailInput, 20);
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(text);
    }

    public void setTextToPasswordInput(String text){
        Driver.waitForElementToLoad(passwordInput, 20);
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(text);
    }

    public TradingViewSearchPage clickToLoginButton(){
        Driver.waitForElementToLoad(loginButton, 20);
        loginButton.click();
        return PageFactory.initElements(driver, TradingViewSearchPage.class);
    }
}
