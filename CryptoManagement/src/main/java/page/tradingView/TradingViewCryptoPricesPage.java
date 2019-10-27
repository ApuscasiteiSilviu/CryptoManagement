package page.tradingView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewCryptoPricesPage {

    private WebDriver driver;
    private String[] exchangeType = {"BITSTAMP", "BINANCE", "BITTREX", "CEXIO", "BITFINEX", "HITBTC", "POLONIEX", "KRAKEN"};

    public TradingViewCryptoPricesPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public TradingViewItemPage clickToItem(String item){

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
