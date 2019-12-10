package page.tradingView;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewHomePage {

    private WebDriver driver;

    @FindBy(css = "span[class='tv-header__dropdown-text']")
    WebElement signInButton;

    @FindBy(xpath = "//li/a[contains(text(),'Markets')]")
    private WebElement marketButton;

    public TradingViewHomePage(WebDriver driver){
        this.driver = driver;
    }

    public TradingViewLoginPage clicktoSignInButton(){
        Driver.waitForElementToLoad(signInButton, 20);
        signInButton.click();
        return PageFactory.initElements(driver, TradingViewLoginPage.class);
    }

    public TradingViewMarketPage clickToMarketButton(){
        Driver.waitForElementToLoad(marketButton, 20);
        Driver.waitForElementToBeClickable(marketButton, 20);
        marketButton.click();

        return PageFactory.initElements(driver, TradingViewMarketPage.class);
    }
}
