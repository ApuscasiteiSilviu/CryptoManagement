package page.yahoo;

import driver.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooAuthPage {
    private WebDriver driver;

    @FindBy(css = "a#uh-signin")
    private WebElement authButton;

    @FindBy(css = "button[name='agree']")
    private WebElement okPopupButton;

    public YahooAuthPage(WebDriver driver){
        this.driver = driver;
    }

    public YahooLoginPage clickToAuthButton(){

        try {
            Driver.waitForElementToLoad(okPopupButton, 20);
            okPopupButton.click();
        }catch (Exception e){
            System.out.println("Exception on clicking the popup button");
        }
        System.out.println("ok popup button was clicked");


        Driver.waitForElementToLoad(authButton, 20);
        authButton.click();
        System.out.println("auth button was clicked");
        return PageFactory.initElements(driver, YahooLoginPage.class);
    }

}
