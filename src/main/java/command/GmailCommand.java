package command;

import driver.WebDriverBuilder;
import page.gmail.GmailHomePage;
import util.AppReadProperties;
import org.openqa.selenium.support.PageFactory;
import page.gmail.GmailLoginPage;
import page.gmail.GmailPasswordPage;

public class GmailCommand {

    GmailLoginPage gmailLoginPage;
    GmailPasswordPage gmailPasswordPage;
    GmailHomePage gmailHomePage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    AppReadProperties appReadProperties = new AppReadProperties();

    public GmailCommand() {
        webDriverBuilder.set("gmail");
    }

    public void login(){
        gmailLoginPage = PageFactory.initElements(webDriverBuilder.webDriver, GmailLoginPage.class);
        gmailPasswordPage = gmailLoginPage.sendTextToEmailInput(appReadProperties.getApplicationGmailAccountName());
        gmailHomePage = gmailPasswordPage.sendTextToPasswordInput(appReadProperties.getApplicationGmailAccountPassword());
    }

    public void sendMail(String recipient, String subject, String message){
        gmailHomePage.clickToWriteButton();
        gmailHomePage.setTextToRecipientInput(recipient);
        gmailHomePage.setTextToSubjectInput(subject);
        gmailHomePage.setTextToTextbox(message);
       // gmailHomePage.clickToSendButton();
    }

    public void closeThePage(){
        webDriverBuilder.tearDown();
    }

}
