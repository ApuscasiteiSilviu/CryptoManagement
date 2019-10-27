package page.tradingView;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradingViewHomePage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[4]/span[2]/a")
    WebElement signInButton;

    public TradingViewHomePage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public TradingViewLoginPage clicktoSignInButton(){
        signInButton.click();
        return PageFactory.initElements(driver, TradingViewLoginPage.class);
    }
}
