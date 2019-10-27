package page.tradingView;

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

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public TradingViewCryptoPricesPage clickToMoreCryptocurrenciesButton(){
        moreCryptocurrenciesButton.click();
        return PageFactory.initElements(driver, TradingViewCryptoPricesPage.class);
    }
}
