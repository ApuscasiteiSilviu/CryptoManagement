package builder;

import data.AppReadProperties;
import driver.CreateDriver;
import org.openqa.selenium.WebDriver;

public class WebDriverBuilder {


    private CreateDriver createDriver =  new CreateDriver();
    public static WebDriver webDriver;

    public WebDriverBuilder(){
        webDriver = createDriver.getInstance();
    }

    public static void set(String url){
        AppReadProperties appReadProperties = new AppReadProperties();
        if ("tradingview".equals(url)){
            webDriver.get(appReadProperties.getTradingViewURL());
        }
        else if ("gmail".equals(url)){
            webDriver.get(appReadProperties.getGmailURL());
        }
        else {
            System.out.println("Invalid application/website");
        }
    }
}
