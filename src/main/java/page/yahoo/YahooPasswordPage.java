package page.yahoo;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooPasswordPage {

    private WebDriver driver;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInput;

    public YahooPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public YahooHomePage setTextToPasswordInput(String text){
        Driver.waitForElementToLoad(passwordInput, 20);
        passwordInput.sendKeys(text, Keys.ENTER);

        return PageFactory.initElements(driver, YahooHomePage.class);
    }
}
