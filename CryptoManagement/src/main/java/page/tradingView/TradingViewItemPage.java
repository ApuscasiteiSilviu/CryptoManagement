package page.tradingView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TradingViewItemPage {

    private WebDriver driver;

    @FindBy(css = "div[class='tv-symbol-price-quote__value js-symbol-last']")
    WebElement value;

    public TradingViewItemPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public String takeValue(){
        return value.getText();
    }
}
