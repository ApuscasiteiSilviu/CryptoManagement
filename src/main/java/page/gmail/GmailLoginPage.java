package page.gmail;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.tradingView.TradingViewLoginPage;

public class GmailLoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    WebElement emailInput;

    public GmailLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public GmailPasswordPage sendTextToEmailInput(String text){

        System.out.println("title: " + driver.getTitle());
        Driver.waitForElementToLoad(emailInput, 20);
        emailInput.clear();
        emailInput.sendKeys(text, Keys.ENTER);
        return PageFactory.initElements(driver, GmailPasswordPage.class);
    }
}
