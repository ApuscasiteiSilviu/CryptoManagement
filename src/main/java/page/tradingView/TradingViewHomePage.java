package page.tradingView;

import driver.Driver;
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

    public TradingViewLoginPage clicktoSignInButton(){
        System.out.println("title: " + driver.getTitle());
        Driver.waitForElementToLoad(signInButton, 20);
        signInButton.click();
        return PageFactory.initElements(driver, TradingViewLoginPage.class);
    }
}
