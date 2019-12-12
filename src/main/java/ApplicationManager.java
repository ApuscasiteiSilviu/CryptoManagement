import command.GmailCommand;
import command.MathCommand;
import command.TradingViewCommand;
import command.YahooCommand;
import util.AppReadProperties;
import util.MailUtil;
import util.UserReadProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationManager {

    private UserReadProperties userReadProperties = new UserReadProperties();
    private AppReadProperties appReadProperties = new AppReadProperties();

    private TradingViewCommand tradingViewCommand;
    private MathCommand mathCommand = new MathCommand();
    private GmailCommand gmailCommand;
    private YahooCommand yahooCommand;

    private List<Double> startValue = new ArrayList<>();
    private List<Double> lastValue = new ArrayList<>();
//    private Double[] startValue = {1.0, 1.0};
//    private Double[] lastValue = {9577.0};

    //bitcoin and eth
    private Double[][] prices = {{10274.00, 295.0},  {10750.00, 310.0}, {10850.00, 308.0}, {11050.00, 311.0}, {12850.00, 318.0}, {11200.00, 339.0}, {12350.00, 297.0}, {11900.00, 310.0},  {10800.00, 318.0}, {10650.00, 292.0}, {10900.00, 294.0}, {12000.00, 290.0}, {11150.00, 300.0}, {11000.00, 283.0}, {11300.00, 287.0}, {11500.00, 288.0}, {12300.00, 305.0}, {12500.00, 311.0}, {12100.00, 307.0}, {11400.00, 288.0}, {11750.00, 267.0}, {11350.00, 273.0}, {10200.00, 268.0}, {10800.00, 255.0}, {9400.00, 227.0}, {9650.00, 198.0}, {10600.00, 209.0}, {10500.00, 225.0}, {10750.00, 220.0}, {10550.00, 227.0}, {10300.00, 226.0}, {9850.00, 216.0}, {9800.00, 212.0}, {9900.00, 216.0}};

    private List<String> coinList = Arrays.asList(userReadProperties.getCryptoCoin().split(","));
    private Integer indexPricesList = 0;


    public void initializeValues() throws Exception {

//        tradingViewCommand = new TradingViewCommand();
//        tradingViewCommand.login();
//        for (String coin:coinList){
////             take values from page (every coin)
//            tradingViewCommand.goToCurrency(coin);
//            startValue.add(Double.valueOf(tradingViewCommand.getCurrentPrice()));
//            lastValue.add(Double.valueOf(tradingViewCommand.getCurrentPrice()));
//        }
//        tradingViewCommand.closeThePage();


        startValue.add(7368.03);
        startValue.add(147.205916);
        startValue.add(507.68);

        lastValue.add(7194.5);
        lastValue.add(142.459);
        lastValue.add(486.3);
    }

    public void manage(){

        /* --------------------------------------------------------- */
            // loop with all the crypto coins
                //take current value from the page for one crypto coin
                //take start and last value for that crypto coin
                //take decision
                //update values ( + send mail if its a good trade)

        /* -------------------------------------------------------- */

        tradingViewCommand = new TradingViewCommand();
        tradingViewCommand.login();

        System.out.println("Values before running");
        System.out.println("Start values: " + startValue.toString());
        System.out.println("Last values: " + lastValue.toString());
        System.out.println("");

        Integer index = 0;
       while (index < coinList.size()){

            //take current value from page
           tradingViewCommand.goToCurrency(coinList.get(index));
           System.out.println("cryptoCoin: " + coinList.get(index));
           System.out.println("current price: " + tradingViewCommand.getCurrentPrice());
           System.out.println("");

           // List<Object> list =  mathCommand.takeDecision(startValue.get(index), lastValue.get(index), prices[indexPricesList][index], coinList.get(index));
            List<Object> list =  mathCommand.takeDecision(startValue.get(index), lastValue.get(index), Double.valueOf(tradingViewCommand.getCurrentPrice()), coinList.get(index));

            //update values
            startValue.set(index, Double.valueOf(String.valueOf(list.get(0))));
            lastValue.set(index, Double.valueOf(String.valueOf(list.get(1))));

           //send mail
           if (list.get(2) != ""){
               System.out.println(list.get(2));
               gmailCommand = new GmailCommand();
               gmailCommand.login();
               gmailCommand.sendMail(userReadProperties.getGmailAccount(), "Time to make a trade" , (String) list.get(2));
               gmailCommand.closeThePage();
           }

            index++;
       }

        System.out.println("Values after running");
        System.out.println("Start values: " + startValue.toString());
        System.out.println("Last values: " + lastValue.toString());
        System.out.println("");

       tradingViewCommand.closeThePage();
       indexPricesList++;
    }

    public void closeDriverConnectionWithTradingViewSite(){
        tradingViewCommand = new TradingViewCommand();
        tradingViewCommand.closeThePage();
    }

    public void closeDriverConnectionWithGmail(){
        gmailCommand = new GmailCommand();
        gmailCommand.closeThePage();
    }

    public void sendLifeServerCheckEmail(){
//        gmailCommand = new GmailCommand();
//        System.out.println("Sending life server check email..");
//        gmailCommand.login();
//        System.out.println("Prepare the message");
//        gmailCommand.sendMail(appReadProperties.getApplicationGmailAccountName(), "Server life cycle" , "The server is running");
//        System.out.println("Email sent successfully");
//        gmailCommand.closeThePage();

//        yahooCommand = new YahooCommand();
//        System.out.println("Sending life server check email..");
//        yahooCommand.login();
//        System.out.println("Prepare the message");
//        yahooCommand.sendMail(appReadProperties.getApplicationGmailAccountName(), "Server life cycle" , "The server is running");
//        System.out.println("Email sent successfully");
//        yahooCommand.closeThePage();

//        MailUtil.sendMail(appReadProperties.getApplicationGmailAccountName(), appReadProperties.getApplicationGmailAccountName(), appReadProperties.getApplicationGmailAccountPassword(), "The server is running");

        try {
            MailUtil.sendMail(userReadProperties.getGmailAccount(), appReadProperties.getApplicationGmailAccountName(), "Server life cycle", "Hello sir, The server is still running! Thank you! :)");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            MailUtil.sendMail(appReadProperties.getApplicationGmailAccountName(), appReadProperties.getApplicationGmailAccountName(), "Server life cycle", "The server is running");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}
