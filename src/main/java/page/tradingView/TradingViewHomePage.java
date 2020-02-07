package page.tradingView;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewHomePage {

    private WebDriver driver;

    @FindBy(css = "span[class='tv-header__dropdown-text']")
    private WebElement signInButton;

    @FindBy(xpath = "//li/a[contains(text(),'Markets')]")
    private WebElement marketButton;

    @FindBy(css = "button[class='button-1iktpaT1- size-m-2G7L7Qat- intent-primary-1-IOYcbg- appearance-default-dMjF_2Hu-']")
    private WebElement popupButton;

    public TradingViewHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void closePopup(){
        Driver.waitForElementToLoad(popupButton, 20);
        popupButton.click();
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
