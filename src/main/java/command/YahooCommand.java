package command;

import driver.WebDriverBuilder;
import org.openqa.selenium.support.PageFactory;
import page.gmail.GmailLoginPage;
import page.yahoo.YahooLoginPage;
import util.AppReadProperties;

public class YahooCommand {

    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    AppReadProperties appReadProperties = new AppReadProperties();
    YahooLoginPage yahooLoginPage;

    public YahooCommand() {
        webDriverBuilder.set("yahoo");
    }

    public void login(){
        yahooLoginPage = PageFactory.initElements(webDriverBuilder.webDriver, YahooLoginPage.class);
        System.out.println("Page is opened");
        yahooLoginPage.clickToAuthButton();
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMail(String recipient, String subject, String message){
    }

    public void closeThePage(){
        webDriverBuilder.tearDown();
    }
}
