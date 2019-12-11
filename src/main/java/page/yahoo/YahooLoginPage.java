package page.yahoo;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooLoginPage {

    private WebDriver driver;

    @FindBy(css = "input[name='username']")
    private WebElement usernameInput;


    public YahooLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public YahooPasswordPage setTextToUsernameInput(String text){
        Driver.waitForElementToLoad(usernameInput, 20);
        usernameInput.sendKeys(text, Keys.ENTER);
        return PageFactory.initElements(driver, YahooPasswordPage.class);
    }

}
