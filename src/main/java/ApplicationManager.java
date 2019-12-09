import command.MathCommand;
import command.TradingViewCommends;
import cucumber.api.java.eo.Do;
import util.AppReadProperties;
import util.MailUtil;
import util.UserReadProperties;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationManager {

    private UserReadProperties userReadProperties = new UserReadProperties();
    private AppReadProperties appReadProperties = new AppReadProperties();
    private TradingViewCommends tradingViewCommends;

    private MathCommand mathCommand = new MathCommand();
    private List<Double> startValue = new ArrayList<>();
    private List<Double> lastValue = new ArrayList<>();
//    private Double[] startValue = {1.0, 1.0};
//    private Double[] lastValue = {9577.0};

    //bitcoin and eth
    private Double[][] prices = {{10274.00, 295.0},  {10750.00, 310.0}, {10850.00, 308.0}, {11050.00, 311.0}, {12850.00, 318.0}, {11200.00, 339.0}, {12350.00, 297.0}, {11900.00, 310.0},  {10800.00, 318.0}, {10650.00, 292.0}, {10900.00, 294.0}, {12000.00, 290.0}, {11150.00, 300.0}, {11000.00, 283.0}, {11300.00, 287.0}, {11500.00, 288.0}, {12300.00, 305.0}, {12500.00, 311.0}, {12100.00, 307.0}, {11400.00, 288.0}, {11750.00, 267.0}, {11350.00, 273.0}, {10200.00, 268.0}, {10800.00, 255.0}, {9400.00, 227.0}, {9650.00, 198.0}, {10600.00, 209.0}, {10500.00, 225.0}, {10750.00, 220.0}, {10550.00, 227.0}, {10300.00, 226.0}, {9850.00, 216.0}, {9800.00, 212.0}, {9900.00, 216.0}};

    private List<String> coinList = Arrays.asList(userReadProperties.getCryptoCoin().split(","));
    private Integer indexPricesList = 0;


    public void initializeValues() throws Exception {

//        tradingViewCommends = new TradingViewCommends();
//        tradingViewCommends.login();
//        for (String coin:coinList){
////             take values from page (every coin)
//            tradingViewCommends.goToCurrency(coin);
//            startValue.add(Double.valueOf(tradingViewCommends.getCurrentPrice()));
//            lastValue.add(Double.valueOf(tradingViewCommends.getCurrentPrice()));
//        }
//        tradingViewCommends.closeThePage();


        startValue.add(7368.03);
        startValue.add(147.205916);
        startValue.add(507.68);

        lastValue.add(7477.29);
        lastValue.add(149.306);
        lastValue.add(515.0);
    }

    public void manage() throws Exception{

        /* --------------------------------------------------------- */
            // loop with all the crypto coins
                //take current value from the page for one crypto coin
                //take start and last value for that crypto coin
                //take decision
                //update values ( + send mail if its a good trade)

        /* -------------------------------------------------------- */

        tradingViewCommends = new TradingViewCommends();
        sendLifeServerCheckEmail();
        tradingViewCommends.login();

        Integer index = 0;
       while (index < coinList.size()){

            //take current value from page
           tradingViewCommends.goToCurrency(coinList.get(index));
           System.out.println("current price: " + tradingViewCommends.getCurrentPrice());

           // List<Object> list =  mathCommand.takeDecision(startValue.get(index), lastValue.get(index), prices[indexPricesList][index], coinList.get(index));
            List<Object> list =  mathCommand.takeDecision(startValue.get(index), lastValue.get(index), Double.valueOf(tradingViewCommends.getCurrentPrice()), coinList.get(index));


           System.out.println(list.get(0));
            System.out.println(list.get(1));
//            System.out.println(list.get(2));

            //update values
            startValue.set(index, Double.valueOf(String.valueOf(list.get(0))));
            lastValue.set(index, Double.valueOf(String.valueOf(list.get(1))));

           System.out.println("Start values: " + startValue.toString());
           System.out.println("Last values: " + lastValue.toString());

           //send mail
           if (list.get(2) != ""){
               System.out.println(list.get(2));
               MailUtil.sendMail(userReadProperties.getGmailAccount(), appReadProperties.getApplicationGmailAccountName() , appReadProperties.getApplicationGmailAccountPassword() , (String) list.get(2));
           }

            index++;
       }

       tradingViewCommends.closeThePage();
       indexPricesList++;
    }

    public void closeDriverConnection(){
        tradingViewCommends = new TradingViewCommends();
        tradingViewCommends.closeThePage();
    }

    public void sendLifeServerCheckEmail(){
        MailUtil.sendMail(appReadProperties.getApplicationGmailAccountName() + "@gmail.com", appReadProperties.getApplicationGmailAccountName(), appReadProperties.getApplicationGmailAccountPassword(), "The server is running");
    }
}
