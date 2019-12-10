package page.gmail;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPasswordPage {

    private WebDriver driver;

    @FindBy(css = "input[type='password']")
    WebElement passwordInput;

    public GmailPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public GmailHomePage sendTextToPasswordInput(String text){
        Driver.waitForElementToLoad(passwordInput, 20);
        passwordInput.clear();
        passwordInput.sendKeys(text, Keys.ENTER);
        return PageFactory.initElements(driver, GmailHomePage.class);
    }

}
