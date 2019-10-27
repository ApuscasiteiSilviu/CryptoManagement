package page.tradingView;

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

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public void setTextToEmailInput(String text){
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(text);
    }

    public void setTextToPasswordInput(String text){
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(text);
    }

    public TradingViewSearchPage clickToLoginButton(){
        loginButton.click();
        return PageFactory.initElements(driver, TradingViewSearchPage.class);
    }
}
