package page.tradingView;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewSearchPage {

    private WebDriver driver;

    @FindBy(css = "input[type='search']")
    WebElement searchInput;

    @FindBy(xpath = "//li/a[contains(text(),'Markets')]")
    WebElement marketButton;

    public TradingViewSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public TradingViewMarketPage clickToMarketButton(){
        marketButton.click();
        return PageFactory.initElements(driver, TradingViewMarketPage.class);
    }
}
