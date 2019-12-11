package page.yahoo;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooHomePage {

    private WebDriver driver;

    @FindBy(css = "a#uh-mail-link")
    private WebElement mailButton;


    public YahooHomePage(WebDriver driver){
        this.driver = driver;
    }

    public YahooUserPage clickToMailButton(){
        Driver.waitForElementToLoad(mailButton, 20);
        mailButton.click();

        return PageFactory.initElements(driver, YahooUserPage.class);
    }
}
