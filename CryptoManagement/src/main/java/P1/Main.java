package P1;

import driver.WebDriverBuilder;
import command.GmailCommends;
import command.GmailPageObjectCommends;
import command.TradingViewCommends;
import driver.CreateDriver;
import org.openqa.selenium.WebDriver;
import util.GitHub;


public class Main {

    private static WebDriverBuilder webDriverBuilder;
    private static CreateDriver createDriver;
    private static WebDriver driver;
    private static TradingViewCommends tradingViewCommends;
    private static GmailPageObjectCommends gmailPageObjectCommends;
    private static GmailCommends gmailCommends;
    private static GitHub gitHub;


    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello world");

        System.out.println(System.getProperty("user.dir"));
//
//        tradingViewCommends = new TradingViewCommends();
//        tradingViewCommends.login();
//        tradingViewCommends.goToCurrency();
//        System.out.println(tradingViewCommends.calculatePercentage());
//
//        double x = 100;
//        double y = 133;
//        double result = ((y - x)/(double) 100);
//        System.out.println(result);

//
//        gmailPageObjectCommends = new GmailPageObjectCommends();
//        gmailPageObjectCommends.login();


//        gmailCommends = new GmailCommends();
//        gmailCommends.sendMail();

        gitHub = new GitHub();
        gitHub.pushRepo();

    }




}
