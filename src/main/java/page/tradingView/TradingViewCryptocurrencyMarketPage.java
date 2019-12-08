package page.tradingView;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewCryptocurrencyMarketPage {

    private WebDriver driver;

    @FindBy(xpath = "//div/a[contains(text(),'More Cryptocurrencies')]")
    WebElement moreCryptocurrenciesButton;

    public TradingViewCryptocurrencyMarketPage(WebDriver driver){
        this.driver = driver;
    }

    public TradingViewCryptoPricesPage clickToMoreCryptocurrenciesButton(){
        Driver.waitForElementToLoad(moreCryptocurrenciesButton, 20);
        moreCryptocurrenciesButton.click();
        return PageFactory.initElements(driver, TradingViewCryptoPricesPage.class);
    }
}
