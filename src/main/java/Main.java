import command.GitHubCommends;
import command.TradingViewCommand;
import driver.WebDriverBuilder;
import command.GmailCommand;
import driver.Driver;

import org.openqa.selenium.WebDriver;
import util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

    private static WebDriverBuilder webDriverBuilder;
    private static Driver driver;
    private static WebDriver webDriver;
    private static TradingViewCommand tradingViewCommand;
    private static GmailCommand gmailCommand;
    private static GitHubCommends gitHubCommends;
    private static ValueReadProperties valueReadProperties = new ValueReadProperties();
    private static String currentDirectoryPath = System.getProperty("user.dir");
    private static ApplicationManager applicationManager = new ApplicationManager();
    private static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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


    public static void main(String args[]) throws Exception {

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
////        tradingViewCommand = new TradingViewCommand();
////        tradingViewCommand.login();
////        tradingViewCommand.goToCurrency();
////        Double percentage = tradingViewCommand.calculatePercentage();
//        Double percentage = 5645.00;
//        System.out.println(percentage);
//
//        manage();
//
////        gmailCommends = new GmailCommends();
////        gmailCommends.sendMail();


        applicationManager.initializeValues();


        Runnable runnable = new Runnable() {
            int count = 0;
            public void run() {
                Date date = new Date(System.currentTimeMillis());
                System.out.println("************************************** run *****************************************");
                System.out.println("Running number: " + count + " at " + formatter.format(date));
                while(true){
                    try {
                        applicationManager.manage();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception on trading view site...");
                        applicationManager.closeDriverConnectionWithTradingViewSite();
                    }
                }

//                if(count > 0 && count % 2 == 0){
//                    while(true){
//                        try {
//                            applicationManager.sendLifeServerCheckEmail();
//                            break;
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            System.out.println("Exception on gmail...");
////                            applicationManager.closeDriverConnectionWithGmail();
//                        }
//                    }
//                }
                System.out.println("Waiting for the next run...");
                count++;
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 6, TimeUnit.HOURS);


}


}
