package page.tradingView;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewSearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//li/a[contains(text(),'Markets')]")
    private WebElement marketButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div[4]/span[1]/span[1]/span[2]")
    private WebElement loggedUser;

    public TradingViewSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public TradingViewMarketPage clickToMarketButton(){
        Driver.waitForElementToBeClickable(loggedUser, 20);
        Driver.waitForElementToLoad(marketButton, 20);
        Driver.waitForElementToBeClickable(marketButton, 20);
        marketButton.click();

        return PageFactory.initElements(driver, TradingViewMarketPage.class);
    }
}
