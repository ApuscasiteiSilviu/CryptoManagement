package page.tradingView;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TradingViewItemPage {

    private WebDriver driver;

    @FindBy(css = "div[class='tv-symbol-price-quote__value js-symbol-last']")
    private WebElement value;

    public TradingViewItemPage(WebDriver driver){
        this.driver = driver;
    }

    public String takeValue(){
        Driver.waitForElementToLoad(value, 20);
        return value.getText();
    }
}
