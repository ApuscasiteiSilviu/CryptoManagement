package command;

import builder.WebDriverBuilder;
import data.AppReadProperties;
import org.openqa.selenium.support.PageFactory;
import page.gmail.GmailLoginPage;
import page.gmail.GmailPasswordPage;

public class GmailPageObjectCommends {

    GmailLoginPage gmailLoginPage;
    GmailPasswordPage gmailPasswordPage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    AppReadProperties appReadProperties = new AppReadProperties();

    public GmailPageObjectCommends() {
        webDriverBuilder.set("gmail");
    }

    public void login() throws InterruptedException {
        gmailLoginPage = PageFactory.initElements(webDriverBuilder.webDriver, GmailLoginPage.class);
        gmailPasswordPage = gmailLoginPage.sendTextToEmailInput("silviuapu@gmail.com");
        Thread.sleep(2000);
        gmailPasswordPage.sendTextToPasswordInput("Masterzed98");
    }

}
