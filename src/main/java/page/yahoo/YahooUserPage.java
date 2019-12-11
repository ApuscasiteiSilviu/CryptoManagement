package page.yahoo;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooUserPage {
    private WebDriver driver;

    @FindBy(css = "a[data-test-id='compose-button']")
    private WebElement composeButton;

    @FindBy(xpath = "//*[@id=\"message-to-field\"]")
    private WebElement recipientInput;

    @FindBy(css = "input[placeholder='Subiect']")
    private WebElement subjectInput;

    @FindBy(xpath = "//*[@id=\"editor-container\"]/div[1]")
    private WebElement textBox;

    @FindBy(css = "button[data-test-id='compose-send-button']")
    private WebElement sendButton;

    @FindBy(xpath = "//span[contains(text(),'a fost trimis.')]")
    private WebElement confirmationPopup;

    public YahooUserPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickToComposeButton(){
        Driver.waitForElementToLoad(composeButton, 20);
        composeButton.click();
    }

    public void setTextToRecipientInput(String text){
        Driver.waitForElementToLoad(recipientInput, 20);
        recipientInput.sendKeys(text);
    }

    public void setTextToSubjectInput(String text){
        Driver.waitForElementToLoad(subjectInput, 20);
        subjectInput.sendKeys(text);
    }

    public void setTextToTextBox(String text){
        Driver.waitForElementToLoad(textBox, 20);
        textBox.sendKeys(text);
    }

    public void clickToSendButton(){
        Driver.waitForElementToLoad(sendButton, 20);
        sendButton.click();
        Driver.waitForElementToLoad(confirmationPopup, 20);
    }

}
