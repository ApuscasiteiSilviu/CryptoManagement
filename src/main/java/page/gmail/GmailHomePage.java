package page.gmail;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Scrie')]")
    private WebElement writeButton;

    @FindBy(css = "textarea[name='to']")
    private WebElement recipientInput;

    @FindBy(css = "input[name='subjectbox']")
    private WebElement subjectInput;

    @FindBy(css = "div[role='textbox']")
    private WebElement textbox;

    @FindBy(css = "div[class='dC']>div[role='button']")
    private WebElement sendButton;

    @FindBy(xpath = "//span[contains(text(), 'Mesajul a fost trimis')]")
    private WebElement confirmationPopup;

    public GmailHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToWriteButton(){
        Driver.waitForElementToLoad(writeButton, 20);
        writeButton.click();
    }

    public void setTextToRecipientInput(String text){
        Driver.waitForElementToLoad(recipientInput, 20);
        recipientInput.sendKeys(text);
    }

    public void setTextToSubjectInput(String text){
        Driver.waitForElementToLoad(subjectInput, 20);
        subjectInput.sendKeys(text);
    }

    public void setTextToTextbox(String text){
        Driver.waitForElementToLoad(textbox, 20);
        textbox.sendKeys(text);
    }

    public void clickToSendButton(){
        Driver.waitForElementToLoad(sendButton, 20);
        sendButton.click();
        Driver.waitForElementToLoad(confirmationPopup, 20);
    }
}
