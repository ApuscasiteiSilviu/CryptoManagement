package command;

import driver.WebDriverBuilder;
import util.AppReadProperties;
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
    }

}
