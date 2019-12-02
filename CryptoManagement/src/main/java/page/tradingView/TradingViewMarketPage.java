package page.tradingView;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewMarketPage {

    private WebDriver driver;

    @FindBy(xpath = "//div/a[contains(text(),'Cryptocurrency')]")
    WebElement cryptocurrencyButton;

    public TradingViewMarketPage(WebDriver driver){
        this.driver = driver;
    }

    public TradingViewCryptocurrencyMarketPage clickToCryptocurrencyButton(){
        Driver.waitForElementToLoad(cryptocurrencyButton, 20);
        cryptocurrencyButton.click();
        return PageFactory.initElements(driver, TradingViewCryptocurrencyMarketPage.class);
    }
}
