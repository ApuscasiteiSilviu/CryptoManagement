import command.GitHubCommends;
import cucumber.api.java.eo.Do;
import driver.WebDriverBuilder;
import command.GmailPageObjectCommends;
import command.TradingViewCommends;
import driver.CreateDriver;

import org.openqa.selenium.WebDriver;
import sun.plugin2.applet.ManagerCache;
import util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

    private static WebDriverBuilder webDriverBuilder;
    private static CreateDriver createDriver;
    private static WebDriver driver;
    private static TradingViewCommends tradingViewCommends;
    private static GmailPageObjectCommends gmailPageObjectCommends;
    private static GitHubCommends gitHubCommends;
    private static AppReadProperties appReadProperties = new AppReadProperties();
    private static UserReadProperties userReadProperties = new UserReadProperties();
    private static ValueReadProperties valueReadProperties = new ValueReadProperties();
    private static String currentDirectoryPath = System.getProperty("user.dir");
    private static ApplicationManager applicationManager = new ApplicationManager();
    private static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

    public static void manageTest() {

        Double startValue = 9577.00;
        Double lastValue = 9577.00;

        Double[] prices = {10274.00, 10750.00, 10850.00, 11050.00, 12850.00, 11200.00, 12350.00, 11900.00, 10800.00, 10650.00, 10900.00, 12000.00, 11150.00, 11000.00, 11300.00, 11500.00, 12300.00, 12500.00, 12100.00, 11400.00, 11750.00, 11350.00, 10200.00, 10800.00, 9400.00, 9650.00, 10600.00, 10500.00, 10750.00, 10550.00, 10300.00, 9850.00, 9800.00, 9900.00};


        for (Double index : prices) {
            if (index <= lastValue) {
                //continue;
            } else if (index > lastValue) {
                if ((100 * (startValue - index)) / startValue > 2) {
                    // gmailCommends.sendMail();
                    System.out.println("make trade (price is lower) " + (100 * (startValue - index)) / startValue);
                    startValue = index;
                    lastValue = index;
                    System.out.println("start value = " + startValue);
                }
            }

            if (index >= lastValue) {
                //continue;
            } else if (index < lastValue) {
                if ((100 * (index - startValue)) / index > 2) {
                    //gmailCommends.sendMail();
                    System.out.println("make trade (price is higher) " + (100 * (index - startValue)) / index);
                    startValue = index;
                    lastValue = index;
                    System.out.println("start value = " + startValue);
                }
            }

            lastValue = index;
        }
    }


    public static void manage(Double currentValue) {

        Double startValue = Double.valueOf(valueReadProperties.getStartPrice());
        Double lastValue = Double.valueOf(valueReadProperties.getLastPrice());

        if (currentValue <= lastValue) {
            //continue;
        } else if (currentValue > lastValue) {
            if ((100 * (startValue - currentValue)) / startValue >= 10) {
                Double percentage = (100 * (startValue - currentValue)) / startValue;
                //MailUtil.sendMail(userReadProperties.getGmailAccount(), appReadProperties.getApplicationGmailAccountName() , appReadProperties.getApplicationGmailAccountPassword() ,"Make a Trade!! Price is lower with " + percentage + "%");
                System.out.println("make trade (price is lower) " + (100 * (startValue - currentValue)) / startValue);
                try (FileInputStream objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\value.properties")) {
                    Properties properties = new Properties();
                    properties.load(objFile);
                    properties.setProperty("startPrice", String.valueOf(currentValue));
                    properties.setProperty("lastPrice", String.valueOf(currentValue));
                    FileOutputStream output = new FileOutputStream(currentDirectoryPath + "\\src\\main\\resources\\value.properties");
                    properties.store(output, "Update values");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("start value = " + startValue);
            }
        }

        if (currentValue >= lastValue) {
            //continue;
        } else if (currentValue < lastValue) {
            if ((100 * (currentValue - startValue)) / currentValue >= 10) {
                Double percentage = (100 * (currentValue - startValue)) / currentValue;
                // MailUtil.sendMail(userReadProperties.getGmailAccount(), appReadProperties.getApplicationGmailAccountName() , appReadProperties.getApplicationGmailAccountPassword() ,"Make a Trade!! Price is higher with " + percentage + "%");
                System.out.println("make trade (price is higher) " + (100 * (currentValue - startValue)) / currentValue);
                try (FileInputStream objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\value.properties")) {
                    Properties properties = new Properties();
                    properties.load(objFile);
                    properties.setProperty("startPrice", String.valueOf(currentValue));
                    properties.setProperty("lastPrice", String.valueOf(currentValue));
                    FileOutputStream output = new FileOutputStream(currentDirectoryPath + "\\src\\main\\resources\\value.properties");
                    properties.store(output, "Update values");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("start value = " + startValue);
            }
        }

        try (FileInputStream objFile = new FileInputStream(currentDirectoryPath + "\\src\\main\\resources\\value.properties")) {
            Properties properties = new Properties();
            properties.load(objFile);
            properties.setProperty("lastPrice", String.valueOf(currentValue));
            FileOutputStream output = new FileOutputStream(currentDirectoryPath + "\\src\\main\\resources\\value.properties");
            properties.store(output, "Update last value");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String args[]) throws InterruptedException {

        /* --------------------------------------------------------------------------- */

//        while(true){
//            Double currentValue = 9325.0;
//            Thread.sleep(60000);
//            System.out.println(currentValue);
//            //manage(currentValue);
//        }

//
//


    //manage(currentValue);

    /* --------------------------------------------------------------------------- */
//        System.out.println("Hello world");
//
//        System.out.println(System.getProperty("user.dir"));
//
////        tradingViewCommends = new TradingViewCommends();
////        tradingViewCommends.login();
////        tradingViewCommends.goToCurrency();
////        Double percentage = tradingViewCommends.calculatePercentage();
//        Double percentage = 5645.00;
//        System.out.println(percentage);
//
//        manage();
//
////        gmailCommends = new GmailCommends();
////        gmailCommends.sendMail();

        applicationManager.initializeValues();

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("************************************** run *****************************************");
                try {
                    applicationManager.manage();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Date date = new Date(System.currentTimeMillis());
                //System.out.println(formatter.format(date));
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.SECONDS);


}


}
