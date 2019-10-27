package page.gmail;

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

    public boolean isOpened(){
        return "YouTube".equals(driver.getTitle());
    }

    public GmailHomePage sendTextToPasswordInput(String text){

        passwordInput.clear();
        passwordInput.sendKeys(text, Keys.ENTER);
        return PageFactory.initElements(driver, GmailHomePage.class);
    }

}
