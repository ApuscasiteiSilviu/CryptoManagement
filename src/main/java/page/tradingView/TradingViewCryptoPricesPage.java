package page.tradingView;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewCryptoPricesPage {

    private WebDriver driver;
    private String[] exchangeType = {"BITSTAMP", "BINANCE", "BITTREX", "CEXIO", "BITFINEX", "HITBTC", "POLONIEX", "KRAKEN", "GEMINI"};

    @FindBy(xpath = "//*[@id=\"js-screener-container\"]/div[3]/table/thead/tr/th[1]/div/div/div[3]/input")
    private WebElement searchInput;

    public TradingViewCryptoPricesPage(WebDriver driver){
        this.driver = driver;
    }

    public TradingViewItemPage clickToItem(String item){
        Driver.waitForElementToLoad(searchInput, 20);

        int index = 0;
        while (index < exchangeType.length)
        {
            try {
                driver.findElement(By.cssSelector("tr[data-symbol='" + exchangeType[index] + ":" + item + "']>td>a")).click();
                break;
            }catch (Exception e){
                index++;
                continue;
            }
        }

        return PageFactory.initElements(driver, TradingViewItemPage.class);
    }
}
