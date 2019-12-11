package command;

import driver.WebDriverBuilder;
import org.openqa.selenium.support.PageFactory;
import page.yahoo.*;
import util.AppReadProperties;

public class YahooCommand {

    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    AppReadProperties appReadProperties = new AppReadProperties();
    YahooAuthPage yahooAuthPage;
    YahooLoginPage yahooLoginPage;
    YahooPasswordPage yahooPasswordPage;
    YahooHomePage yahooHomePage;
    YahooUserPage yahooUserPage;

    public YahooCommand() {
        webDriverBuilder.set("yahoo");
    }

    public void login(){
        yahooAuthPage = PageFactory.initElements(webDriverBuilder.webDriver, YahooAuthPage.class);
        System.out.println("Page is opened");
        yahooLoginPage = yahooAuthPage.clickToAuthButton();
        yahooPasswordPage = yahooLoginPage.setTextToUsernameInput(appReadProperties.getApplicationYahooAccountName());
        yahooHomePage = yahooPasswordPage.setTextToPasswordInput(appReadProperties.getApplicationYahooAccountPassword());
    }

    public void sendMail(String recipient, String subject, String message){
        yahooUserPage = yahooHomePage.clickToMailButton();
        yahooUserPage.clickToComposeButton();
        yahooUserPage.setTextToRecipientInput(recipient);
        yahooUserPage.setTextToSubjectInput(subject);
        yahooUserPage.setTextToTextBox(message);
        yahooUserPage.clickToSendButton();
    }

    public void closeThePage(){
        webDriverBuilder.tearDown();
    }
}
