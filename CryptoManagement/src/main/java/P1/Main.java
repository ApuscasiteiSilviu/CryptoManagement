package P1;

import command.GitHubCommends;
import driver.WebDriverBuilder;
import command.GmailCommends;
import command.GmailPageObjectCommends;
import command.TradingViewCommends;
import driver.CreateDriver;
import org.openqa.selenium.WebDriver;


public class Main {

    private static WebDriverBuilder webDriverBuilder;
    private static CreateDriver createDriver;
    private static WebDriver driver;
    private static TradingViewCommends tradingViewCommends;
    private static GmailPageObjectCommends gmailPageObjectCommends;
    private static GmailCommends gmailCommends;
    private static GitHubCommends gitHubCommends;


    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello world");

        System.out.println(System.getProperty("user.dir"));

        tradingViewCommends = new TradingViewCommends();
        tradingViewCommends.login();
        tradingViewCommends.goToCurrency();
        Double percentage = tradingViewCommends.calculatePercentage();
        System.out.println(percentage);

        if(percentage > 10) {
            gmailCommends = new GmailCommends();
            gmailCommends.sendMail();
        }

    }

}
