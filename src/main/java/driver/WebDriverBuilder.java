package driver;

import util.AppReadProperties;
import org.openqa.selenium.WebDriver;

public class WebDriverBuilder {


    private Driver driver =  new Driver();
    public static WebDriver webDriver;

    public WebDriverBuilder(){
        webDriver = driver.getInstance();
    }

    public static void set(String site){
        AppReadProperties appReadProperties = new AppReadProperties();
        if ("tradingview".equals(site)){
            webDriver.get(appReadProperties.getTradingViewURL());
        }
        else if ("gmail".equals(site)){
            webDriver.get(appReadProperties.getGmailURL());
        }
        else if ("github".equals(site)){
            webDriver.get(appReadProperties.getGithubURL());
        }
        else if ("yahoo".equals(site)){
            webDriver.get(appReadProperties.getYahooURL());
        }
        else {
            System.out.println("Invalid application/website");
        }
    }

    public void tearDown(){
        driver.tearDown();
    }
}
