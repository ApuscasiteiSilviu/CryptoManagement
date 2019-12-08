package page.gmail;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.tradingView.TradingViewLoginPage;

public class GmailLoginPage {

    private WebDriver driver;

    @FindBy(css = "input#identifierId")
    WebElement emailInput;

    public GmailLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public GmailPasswordPage sendTextToEmailInput(String text){

        emailInput.clear();
        emailInput.sendKeys(text, Keys.ENTER);
        return PageFactory.initElements(driver, GmailPasswordPage.class);
    }
}
